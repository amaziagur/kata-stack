package com.stack.kata;

public class KataStackImpl<E> implements KataStack<E> {

    public static final int DEFAULT_SIZE = 10;
    int counter = 0;
    Object[] elements;
    int size;

    public KataStackImpl(int size){
        this.size = size;
        elements = new Object[size];
    }

    public KataStackImpl(){
        this.size = DEFAULT_SIZE;
        elements = new Object[DEFAULT_SIZE];
    }

    @Override
    public E push(E element) {
        validateSize();
        elements[counter++] = element;
        return element;
    }

    private void validateSize() {
        if(counter >= size){
            throw new KataStackOutOfBounds("can't add element, beyond init size");
        }
    }

    @Override
    public E pop() {
        validateNotEmpty();
        E elemToRemove = peek();
        elements[counter] = elements[counter--];
        return elemToRemove;
    }

    private void validateNotEmpty() {
        if(counter == 0){
            throw new KataStackEmpty("can't preform operations on empty kataStack");
        }
    }

    @Override
    public E peek() {
        validateNotEmpty();
        return (E) elements[counter -1];
    }

    @Override
    public int count() {
        return counter;
    }
}
