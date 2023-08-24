package com.company.dsa.stack;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int size;

    @Override
    public void push(E element) {
        Node newNode = new Node<>(element);
        if(top==null){
            top = newNode;
            size++;
            return;
        }
        newNode.next = top;
        top = newNode;
        size++;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> removedElement = top;
        top = removedElement.next;
        size--;
        return removedElement.data;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }
}
