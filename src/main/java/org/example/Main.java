package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int i=0;
        while(i<=10){
            System.out.println("hi "+i);
            i++;
        }
        if (i != 0) {
    throw new RuntimeException("Test failed: i is not 0");
}
    }
}
