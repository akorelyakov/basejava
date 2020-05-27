package com.github.akorelyakov.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainStreams {
    private static int minValue(int[] values) {
        return Arrays.stream(values)
                .distinct()
                .sorted()
                .reduce((x, y) -> x * 10 + y)
                .orElse(-1);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        int sum = integers.stream().mapToInt(Integer::intValue).sum();
        return integers.stream().collect(Collectors.partitioningBy(s -> s % 2 == 0)).get(sum % 2 != 0 ? TRUE : FALSE);
    }

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 3, 2, 3, 4};
        System.out.println(minValue(values));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(oddOrEven(list));
    }
}