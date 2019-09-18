package com.epam.collections.binaryTree;

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree<Integer,Integer>binaryTree=new BinaryTree<Integer, Integer>();

        binaryTree.put(1,11);
        binaryTree.put(2,22);
        binaryTree.put(2,33);binaryTree.put(3,34);
        binaryTree.put(6,66);
        binaryTree.put(5,55);
        binaryTree.put(5,54);
        binaryTree.put(8,88);
        binaryTree.showThisMap();
    }
}
