package com.learnjava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeWork12Exercise {
    public static int minValue(int[] values) {
        return Arrays.stream(values)
                .sorted()
                .distinct()
                .reduce(0, (subResult, currentNum) -> subResult * 10 + currentNum);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {

        Map<Boolean, List<Integer>> map = integers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
       return map.get(false).size() % 2 == 0 ? map.get(true) : map.get(false);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 4, 5, 5, 9, 8};
        System.out.println("Минимальное значение по условиям задачи: " + minValue(arr));
        List<Integer> intList = Arrays.asList(1, 2, 3, 7, 8, 3);
        System.out.println("четные или не четные числа: " + oddOrEven(intList));
    }
}
