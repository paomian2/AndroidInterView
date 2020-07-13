package com.linxz.DataStructure.Map;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 09:34
 * version：v4.5.4
 * 描述：映射
 */
public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V value);

    int getSize();

    boolean isEmpty();
}
