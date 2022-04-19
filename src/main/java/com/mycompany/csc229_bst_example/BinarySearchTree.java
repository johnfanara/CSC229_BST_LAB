package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    // ToDo 1: complete InOrder Traversal
    public void inOrderTraversal() {
        doInOrder(this.root);
    }
    
    private void doInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        
        doInOrder(root.getLeft());
        System.out.println(root.getData());
        doInOrder(root.getRight());
    }
    
    // ToDo 2: complete the pre-order travesal
    public void preOrderTraversal() {
        doPreOrder(this.root);
    }
    
    private void doPreOrder(BstNode root) {
        if (root == null) {
        return;
    }   
        System.out.println(root.getData());
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }
    
    // ToDo 3: Find the height of a tree
    public Integer findHeight() {
        return doFindHeight(this.root);
    }
    
    private Integer doFindHeight(BstNode root) {
        int leftHeight, rightHeight;
        if (root == null) {
            return -1;
        }
        leftHeight = doFindHeight(root.getLeft());
        rightHeight = doFindHeight(root.getRight());
        
        return Math.max(leftHeight, rightHeight);
    }

    //ToDo 4: complete getDepth of a node 
    public int getDepth(BstNode node) {
        return doGetDepth(this.root);
    }
    
    private int doGetDepth(BstNode node) {
        int leftDepth, rightDepth;
        if (root == null) {
            return -1;
        }
        leftDepth = doGetDepth(node.getLeft());
        rightDepth = doGetDepth(node.getRight());
        
        return Math.max(leftDepth, rightDepth);
    }

    // ToDo 5: complete the print of the BST
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
       doPrint(" ", root, false);
        
    }
   private void doPrint(String prefix, BstNode n, boolean left) {
       if (n == null) {
           return;
       }
       if (n != root) {
           System.out.println(prefix + (left ?"/-- " : "\\-- ") + n.getData());
       }
       else {
           System.out.println(n.getData() + "--");
       }
       
       doPrint(prefix + (left ? "|   " : "    "), n.getLeft(), true);
        doPrint(prefix + (left ? "|   " : "    "), n.getRight(), false);
   } 

}
