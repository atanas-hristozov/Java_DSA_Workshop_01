package com.company.dsa.queue;

import com.company.dsa.Node;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> head, tail;
    private int size;

    @Override
    public void enqueue(E element) {
        if(head==null) {
            Node<E> newNode = new Node<>(element);
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        Node<E> newNode = new Node<>(element);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<E> removedElement = head;
        head = removedElement.next;
        size--;
        return removedElement.data;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }
}
