package com.assignment.springproject.spring.question1.question5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BinarySearch {
    @Autowired
    @Qualifier("bubbleSort")
    SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] arr){
        sortAlgorithm.sort(arr);
        return 3;
    }
}