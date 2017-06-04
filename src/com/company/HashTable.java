package com.company;

import java.util.LinkedList;

/**
 * Basic Hash Table implementation with error handling
 * Created by simeonlees on 04/06/2017.
 */
class HashTable {
    private LinkedList<HashTableItem>[] table;

    HashTable(int length) {
        this.table = (LinkedList<HashTableItem>[]) new LinkedList<?>[length];
    }

    void addItem(String key, String content) {
        HashTableItem item = new HashTableItem(key, content);
        int index = this.hash(item.getKey());
        if (this.table[index] == null) {
            this.table[index] = new LinkedList<HashTableItem>();
        }
        this.table[index].addLast(item);
    }

    String getItem(String key) throws IndexOutOfBoundsException {
        int index = this.hash(key);
        if (this.table[index] == null) {
            throw new IndexOutOfBoundsException();
        }
        for (HashTableItem item: this.table[index]) {
            if (item.getKey().equals(key)) {
                return item.getContent();
            }
        }
        throw new IndexOutOfBoundsException();
    }

    private int hash(String stringToHash) {
        int code = Math.abs(stringToHash.hashCode());
        return code % this.table.length;
    }

    private class HashTableItem {

        private String key;
        private String content;

        private HashTableItem(String key, String content) {
            this.key = key;
            this.content = content;
        }

        private String getKey() {
            return this.key;
        }

        private String getContent() {
            return this.content;
        }
    }
}
