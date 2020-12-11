package com.company;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Implementation of LRU cache using LinkedHashMap.
 *
 * @param <K> Key Type
 * @param <V> Value Type
 */
public class LruCacheImpl<K, V> implements LruCache<K, V> {

    // FIFO collection of K, V pairs
    private final LinkedHashMap<K, V> cache;

    // Maximum capacity of cache
    private final int capacity;

    LruCacheImpl(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity <= 0");
        this.capacity = capacity;

        /* Using a special constructor to create a linked hash map
         * whose order of iteration is the order in which its entries
         * were last accessed, from least-recently accessed to most-recently
         * (access-order). This kind of map is well-suited to building LRU caches.
         */
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            // Restricting cache to the given capacity.
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public V get(K key) {
        if (key == null)
            throw new NullPointerException("key == null");
        return cache.get(key);
    }

    @Override
    public void set(K key, V value) {
        if (key == null)
            throw new NullPointerException("key == null");
        if (value == null)
            throw new NullPointerException("value == null");
        cache.put(key, value);
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    @Override
    public int getLimit() {
        return capacity;
    }

    public void print() {
        for (Map.Entry<K, V> entry : cache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
