package com.assignment.springproject.question1;

public class TightCoupling {
    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] arr = {1,3,2,4,6};
        System.out.println(search.binarySearch(arr));
    }
}
