package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world");
        HashTable hashTable = new HashTable(20);
        hashTable.addItem("A unique title", "The content of the item");
        System.out.println(hashTable.getItem("A unique title"));
    }
}
