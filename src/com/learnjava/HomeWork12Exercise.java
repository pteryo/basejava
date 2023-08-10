package com.learnjava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork12Exercise {
    public static int minValue(int[] values) {
        return Arrays.stream(values).sorted().distinct().reduce(0, (subResult, currentNum) -> subResult * 10 + currentNum);
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        List<List<Integer>> oddEven = integers.stream().collect(Collectors.teeing(
                Collectors.filtering(num -> num % 2 == 0, Collectors.toList()),
                Collectors.filtering(num -> num % 2 != 0, Collectors.toList()), List::of));
        if (oddEven.get(0).size() % 2 == 0) {
            return oddEven.get(1);
        } else {
            return oddEven.get(0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 4, 5, 5, 9, 8};
        System.out.println("Минимальное значение по условиям задачи: " + minValue(arr));
        List<Integer> intList = Arrays.asList(1, 2, 3, 7, 8);
        System.out.println("четные или не четные числа: " + oddOrEven(intList));
    }
}
