package com.assignment.springproject.spring.question1.question6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BinarySearch {

    SortAlgorithm sortAlgorithm;
    @Autowired
    public BinarySearch(@Qualifier("quickSort") SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int binarySearch(int[] arr){
        sortAlgorithm.sort(arr);
        return 3;
    }
}