package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import me.puguan.lbp.pocker.algorithm.Strategy;

/**
 * A tree test class.
 * @author pguan
 */
public class Mid_Tree {
    private int index=0;
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(new Integer(4));
        dq.add(4);
        System.out.println(dq.pollFirst().equals(dq.pollLast()));
        Mid_Tree mt = new Mid_Tree();
        Node root = init();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String strategy = sc.nextLine();
            if (strategy.isEmpty()) {
                break;                
            }
            mt.traverse(strategy, root);
        }       
    }
    /**
     * Build a tree like this:
     *               H
     *             /   \
     *            D     G
     *           / \   / \
     *          B   C  7  F
     *         / \       / \
     *        9   A      E  8
     * 
     *  
     * @return 
     */
    public static Node init() {
        Node a = new Node('A');
        Node b = new Node('B', new Node('9'), a);
        Node c = new Node('C');
        Node d = new Node('D', b, c);
        Node e = new Node('E');
        Node f = new Node('F', e, new Node('8'));
        Node g = new Node('G', new Node('7'), f);
        Node h = new Node('H', d, g);
        return h;// root    
    }
    
    public void traverse(String strategy, Node node){
        switch(strategy) {
            case "recursivePreOrder":
                recursivePreOrder(node);
                break;
            case "iterativePreOrder":
                iterativePreOrder(node);
                break;
            case "recursiveMidOrder":
                recursiveMidOrder(node);
                break;
            case "iterativeMidOrder":
                iterativeMidOrder(node);
                break;
            case "recursivePostOrder":
                recursivePostOrder(node);
                break;
            case "iterativePostOrder":
                iterativePostOrder(node);
                break;
            case "loopByLayer":
                loopByLayer(node);
                break;
            default:
                System.out.println("Method not supported");
        }
    }
    
    private void visit(Node node) {
        if(node == null ) {
            System.out.printf(" - null - ");
        }
        System.out.printf(" - %s -", node.val);
    }
    
    private void recursivePreOrder(Node root) {
        if(root!=null) {
            visit(root);
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
        
    }
    
    private void iterativePreOrder(Node root) {
        Deque<Node> stack = new LinkedList<>();
        if(root!=null){
            stack.push(root);
            do {
                Node node = stack.pop();
                visit(node);
                if(node.right!=null) {
                    stack.push(node.right);
                }
                if(node.left!=null) {
                    stack.push(node.left);
                }
            } while(!stack.isEmpty());
        }       
    }

    private void recursiveMidOrder(Node root) {
        if(root!=null) {
            recursiveMidOrder(root.left);
            visit(root);
            recursiveMidOrder(root.right);
        }
    }
    
    private void iterativeMidOrder(Node p) {
        Deque<Node> stack = new LinkedList<>();
        while (p != null) {
            while (p != null) {
                if (p.right!= null) {
                    stack.push(p.right);
                }
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            while (!stack.isEmpty() && p.right == null) {
                visit(p);
                p = stack.pop();
            }
            visit(p);
            if (!stack.isEmpty()) {
                p = stack.pop();
            } else {
                p = null;
            }
        }
    }
    
    private void recursivePostOrder(Node root) {
        if (root != null) {
            recursivePostOrder(root.left);
            recursivePostOrder(root.right);
            visit(root);
        }
    }
    
    private void iterativePostOrder(Node root) {
        Deque<Node> stack = new LinkedList<>();
        if (root != null) {
            stack.push(root);
            do {
                Node node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                visit(node);
            } while (!stack.isEmpty());
        }
    }
    
    private void loopByLayer(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                visit(temp);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }
}
class Node {
    public Node left;
    public Node right;
    public char val;
    
    public Node(char val, Node left, Node right) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
    
    public Node(char val) {
        this.val = val;
    }
    
}
