package com.assignment.springproject.question2and3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BinarySearch {
    @Autowired
    SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] arr){
        sortAlgorithm.sort(arr);
        return 3;
    }
}