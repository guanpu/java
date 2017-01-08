/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.puguan.lbp.pocker.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * A collection of five cards with an intrinsic "Mark" used to compare with each other.
 * @author pguan
 */
public class Handful implements Comparable<Handful> {

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    private Map<Integer, Integer> map;
    private Set<Shape> shapes = new TreeSet<>();

    private static final int STRIGHT_FLUSH = 52;
    private static final int FOUR_KIND = 48;

    /**
     * Though full_house has 2 'characteristic number', we only need 1 card(4
     * bit) to compare the value to others. Since the card which is pair will be
     * added in the tailing of the mark. For example 33322 will have mark
     * <pre> 3&lt;&lt;44+ 3&lt;&lt;4 + 3&lt;&lt;3 +3&lt;&lt;2 + 2&lt;&lt;1+2</pre>,
     * it is distinguishable to 33355, though not from the 3&lt;&lt;44 part.
     */
    private static final int FULL_HOUSE = 44;
    private static final int FLUSH = 40;
    private static final int STRIGHT = 36;
    private static final int THREE_KIND = 32;
    /**
     * Two pair need 2 'characteristic number', thus its bit-shift to one pair
     * is 8, unlike those only need 1 characteristic card. mark would around
     * 6993843536
     */
    //private static final int DOUBLE_PAIR = 28;
    private static final int SINGLE_PAIR = 20;

    private long mark;

    public Handful(Card[] assignedCards) {
        Arrays.sort(assignedCards, (Card c1, Card c2) -> {
            //A reversed order
            return c2.getNumber().compareTo(c1.getNumber());
        });
        this.cards = Arrays.asList(assignedCards);
        cards.stream().forEachOrdered((Card c1) -> {
            shapes.add(c1.getShape());
        });
        this.map = cards.stream().collect(Collectors.toMap(c -> c.getNumber().getValue(), c -> {
            return 1;
        }, (i1, i2) -> {
            return i1 + i2;
        }));
        setMark(calculate());
    }

    /**
     * Calculate the literal value of the cards, regardless of its composition.
     * Say 8433A, will return A&lt;&lt;4 + 8&lt;&lt;3 + 4&lt;&lt;2 + 3&lt;&lt;1
     * + 3 It's not useful to compare ordinary non-pairs, but can also compare
     * Kickers. Basically won't bigger than 978670
     *
     * @return
     */
    private long calculate() {
        int num_size = map.keySet().size();
        long char_num = 0;
        long literal = 0L;

        switch (num_size) {
            case 2: //Four kind or full_house
                if ((char_num = isFourKind()) > 0) {
                    literal = char_num << FOUR_KIND;
                    setTitle(Combination.Four);
                    break;
                }
                char_num = isThreeKind();
                setTitle(Combination.FULLHOUSE);
                literal = char_num << FULL_HOUSE;
                break;
            case 3: //Three_kind or two pair
                if ((char_num = isThreeKind()) > 0) {
                    literal = char_num << THREE_KIND;
                    setTitle(Combination.THREE);
                    break;
                } else {
                    char_num = isPair();
                    setTitle(Combination.TWOPAIR);
                    literal = char_num << SINGLE_PAIR;
                    break;
                }
            case 4:
                char_num = isPair();
                setTitle(Combination.PAIR);
                literal = char_num << SINGLE_PAIR;
                break;
            default:
                if ((char_num = isStraight()) > 0) {
                    if (isFlush()) {
                        literal = char_num << STRIGHT_FLUSH;
                        setTitle(Combination.SF);
                    } else {
                        literal = char_num << STRIGHT;
                        setTitle(Combination.STRIGHT);
                    }
                } else if (isFlush()) {
                    literal = 1L << FLUSH;
                    setTitle(Combination.FLUSH);
                } else {
                    setTitle(Combination.OTHER);
                }
                break;
        }
        //Add the literal value so it reveals kicker and the pair of full_house in total mark.
        return literal += calcLiteral();

    }

    /**
     * Calculate the value of the five cards.
     *
     * @return
     */
    private long calcLiteral() {
        long result = 0L;
        for (int i = 0; i < cards.size(); i++) {
            if(i>1) result <<= 4;
            result += cards.get(i).getNumber().getValue();
        }
        return result;
    }

    /**
     * With preconditions: 1. cards are sorted 2. There's no repeating card in
     * the list. To just if the handful is straight. If it is straight, return
     * the largest single number, if not return zero.
     *
     * @return
     */
    private long isStraight() {
        int largest = cards.get(0).getNumber().getValue();
        int smallest = cards.get(4).getNumber().getValue();
        if (largest == 0xd) {
            if (smallest == 1 && cards.get(3).getNumber().getValue() == 4) {
                return 4L;//Ace,2,3,4,5
            } else {
                return 0L;//not straight
            }

        } else //No Ace involved
        if (largest - smallest == 4) {
            return largest;
        } else {
            return 0L;//not straight
        }

    }

    private boolean isFlush() {
        return shapes.size() == 1;
    }

    /**
     * Test if the handful is Four_kind, if so, return the number which
     * appearing 4 times, otherwise, return zero.
     *
     * @return
     */
    private long isFourKind() {
        if (map.values().contains(4)) {
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 4) {
                    return (long) entry.getKey();
                }
            }
        }
        return 0L;
    }

    private long isThreeKind() {
        if (map.values().contains(3)) {
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 3) {
                    return (long) entry.getKey();
                }
            }
        }
        return 0L;
    }

    private long isPair() {
        long i = 0L;
        if (map.values().contains(2)) {
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    if (i == 0L) {
                        i = (long) entry.getKey();
                    } else {
                        long k = (long) entry.getKey();
                        i = Math.max(i, k) << 4 + Math.min(i, k);
                    }
                }
            }
        }
        return i;
    }

    @Override
    public int compareTo(Handful o) {
        if (this.getMark() > o.getMark()) {
            return 1;
        } else if (this.getMark() < o.getMark()) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Get the value of mark
     *
     * @return the value of mark
     */
    public long getMark() {
        return mark;
    }

    /**
     * Set the value of mark
     *
     * @param mark new value of mark
     */
    private final void setMark(long mark) {
        this.mark = mark;
    }
    
        private Combination title;

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public Combination getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    private void setTitle(Combination title) {
        this.title = title;
    }


}
