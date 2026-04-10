package ex1;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K,V> extends AbstractMap<K,V> {
  protected int n = 0;                 
  protected int capacity;              
  private int prime;                   
  private long scale, shift;           

  protected double maxLoadFactor = 0.5; // method added by Fatima

  /** Creates a hash table with the given capacity and prime factor. */
  public AbstractHashMap(int cap, int p) {
    this(cap, p, 0.5); // method added by Fatima
  }

  // method added by Fatima
  public AbstractHashMap(int cap, int p, double loadFactor) {
    prime = p;
    capacity = cap;
    maxLoadFactor = loadFactor;
    Random rand = new Random();
    scale = rand.nextInt(prime-1) + 1;
    shift = rand.nextInt(prime);
    createTable();
  }

  /** Creates a hash table with given capacity and prime factor 109345121. */
  public AbstractHashMap(int cap) { this(cap, 109345121, 0.5); }  // method added by Fatima

  /** Creates a hash table with capacity 17 and prime factor 109345121. */
  public AbstractHashMap() { this(17, 109345121, 0.5); }          // method added by Fatima

  @Override
  public int size() { return n; }

  @Override
  public V get(K key) { return bucketGet(hashValue(key), key); }

  @Override
  public V remove(K key) { return bucketRemove(hashValue(key), key); }

  @Override
  public V put(K key, V value) {
    V answer = bucketPut(hashValue(key), key, value);

    if ((double) n / capacity > maxLoadFactor) // method added by Fatima
      resize(2 * capacity - 1);

    return answer;
  }

  private int hashValue(K key) {
    return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
  }

  private void resize(int newCap) {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(n);
    for (Entry<K,V> e : entrySet())
      buffer.add(e);
    capacity = newCap;
    createTable();                     
    n = 0;                             
    for (Entry<K,V> e : buffer)
      put(e.getKey(), e.getValue());
  }

  protected abstract void createTable();

  protected abstract V bucketGet(int h, K k);

  protected abstract V bucketPut(int h, K k, V v);

  protected abstract V bucketRemove(int h, K k);
}