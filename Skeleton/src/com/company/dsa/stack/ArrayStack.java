package com.company.dsa.stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    public static final int DEFAULT_CAPACITY=5;
    private E[] items;
    private int top;

    public ArrayStack(){
        this.items = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void push(E element) {
        if(top == items.length){
            expandArray();
        }
        items[top] = element;
        top++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        E removedItem = items[top-1];
        top--;
        return removedItem;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return items[top-1];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    private void expandArray(){
        this.items = Arrays.copyOf(this.items, items.length*2);
    }

}
