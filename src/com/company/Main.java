package com.company;

public class Main {

    public static void main(String[] args) {
        var lru = new LruCacheImpl<Integer, String>(5);
        lru.set(1, "one");
        lru.set(2, "two");
        lru.set(3, "three");
        lru.set(4, "four");
        lru.get(1);
        lru.set(5, "five");
        lru.set(6, "six");
        lru.set(7, "seven");
        lru.set(8, "eight");
        lru.print();
    }
}
