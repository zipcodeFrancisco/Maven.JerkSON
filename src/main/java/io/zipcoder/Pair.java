package io.zipcoder;

/**
 * You need to store two values of type `E`, set them in a constructor,
 * and have the following methods,
 * getFirst
 * getSecond
 * min -> returns the minimum of the pair
 * max -> returns the maximum of the pair
 */
public class Pair<E> {

    private String value1;
    private E value2;

    public Pair(String value1, E value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getFirst() {
        return value1;
    }

    public E getSecond() {
        return value2;
    }

//    public E min(){
//        return value1.compareTo(value2)  < 0 ? value1 : value2;
//    }
//
//    public E max(){
//        return value1.compareTo(value2)  > 0 ? value1 : value2;
//    }
}