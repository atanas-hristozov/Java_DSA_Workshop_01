package com.company.dsa.queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements Queue<E> {
    public static final int DEFAULT_CAPACITY = 5;
    private E[] items;
    private int head, tail, size;
    public ArrayQueue() {
        this.items = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void enqueue(E element) {
        if(size == items.length){
            expandArray();
        }
        items[tail] = element;
        size++;
        tail = size;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E removedItem = items[head];
        size--;
        head++;
        return removedItem;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return items[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
    private void expandArray(){
        this.items = Arrays.copyOf(this.items, items.length*2);
        tail = size;
    }
}
