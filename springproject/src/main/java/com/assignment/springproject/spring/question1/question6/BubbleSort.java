package com.assignment.springproject.spring.question1.question6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubbleSort")
public class BubbleSort implements SortAlgorithm {
    public int[] sort(int[] arr){
        System.out.println("using bubblesort");
        return new int[0];
    }
}
