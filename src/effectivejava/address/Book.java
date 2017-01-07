/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectivejava.address;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author pguan
 * @param <T>
 */
public class Book {
    private static Book book;
    private static final String FILENAME = "addressbook";
    private List<Address> addresslist;
    public static Book getInstance() throws FileNotFoundException, PatternSyntaxException, IOException {
        if(book != null) {
            return book;
        }else {
            return new Book();
        }
    }
    private Book() throws FileNotFoundException,PatternSyntaxException, IOException {
        addresslist = new ArrayList<Address> ();
        FileReader fr = new FileReader(FILENAME);
        BufferedReader sc = new BufferedReader(fr);
        while(true) {
            String s = sc.readLine();
            if(s==null) break;
            String[] add = s.split("\\s");
            Address address = new Address();
            address.setFn(add[0]);
            address.setLn(add[1]);
            address.setPhoneNum(add[2]);
            address.setEmail(add[3]);
            addresslist.add(address);          
        }
    }   
    public void add(Address address) throws IOException, MyException{
//        List<Address> sublist = Arrays.asList((Address[]) addresslist.stream().filter(new Predicate<Address>() {
//            @Override
//            public boolean test(Address ea) {
//                return ea.getFn().equals(address.getFn());
//            }
//        }).filter((Address a)->{
//            return a.getLn().equals(address.getLn());
//        }).toArray());
//        if(sublist.size() > 1) {
//            throw new MyException("duplicated");
//        }
        addresslist.add(address);
        write();
    }
    public Optional getBy(Predicate<Address> p) throws IOException {
        return addresslist.stream().filter(p).findFirst();
    }
    public void removeBy(Predicate<Address> p) throws IOException {
        addresslist.removeIf(p);
        write();
    }
    
    public void sortBy(Function<Address, String> keyExtractor) throws IOException {
        Collections.sort(addresslist,Comparator.comparing(keyExtractor));        
        write();
    }
    public void write() throws IOException {
        FileWriter fw = new FileWriter(FILENAME);
        fw.write(listToString(addresslist, '\n'));
    }
    
    public void show() {       
        System.out.println(listToString(addresslist, '\n'));
    }
    public String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(separator);
        }
        return sb.toString().substring(0, sb.toString().length() - 1);
    }
}
