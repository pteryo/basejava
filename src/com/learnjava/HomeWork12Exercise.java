package com.learnjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class HomeWork12Exercise {
    public static int minValue(int[] values) {
        int answer = 0;
        int[] uniqueFigure = new int[10];
        IntStream inputStream = Arrays.stream(values);
        inputStream.forEach(num -> uniqueFigure[num] = 1);
        for (int i = 1; i < 10; i++) {
            if (uniqueFigure[i] == 1) {
                answer = answer * 10 + i;
            }
        }
        return answer;
    }

    public static List<Integer> oddOrEven(List<Integer> integers) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        integers.forEach(integer -> {
            if (integer % 2 == 0) {
                even.add(integer);
            } else {
                odd.add(integer);
            }
        });
        if (odd.size() % 2 == 0) {
            return odd;
        } else {
            return even;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 4, 5, 5, 9, 8};
        System.out.println("Минимальное значение по условиям задачи: " + minValue(arr));
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("четные или не четные числа: " + oddOrEven(intList));
    }
}
