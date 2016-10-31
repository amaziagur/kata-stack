package com.stack.kata;

public interface KataStack<E> {

    E push(E element);

    E pop();

    E peek();

    int count();

    class KataStackOutOfBounds extends RuntimeException{
        public KataStackOutOfBounds(String message){
            super(message);
        }
    }

    class KataStackEmpty extends RuntimeException{
        public KataStackEmpty(String message){
            super(message);
        }
    }
}
