package com.amaktala.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day3 {

    public static void problem1(List<String> lines) {
        System.out.println(lines.stream()
                .map(Day3::splitInHalf)
                .map(stringList -> Day3.findCommonCharacter(stringList.get(0), stringList.get(1)))
                .mapToInt(Day3::getPriority)
                .sum()
        );
    }

    public static void problem2(List<String> lines) {
        Collection<List<String>> subLists = createRows(lines, 3);
        System.out.println(subLists.stream()
                .map(stringList -> Day3.findCommonCharacter(stringList.get(0), stringList.get(1), stringList.get(2)))
                .mapToInt(Day3::getPriority)
                .sum()
        );
    }

    private static int getPriority(char c) {
        if (Character.isLowerCase(c)) {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }

    private static List<String> readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day3.txt"));
        return bufferedReader.lines().toList();

    }

    private static char findCommonCharacter(String first, String second) {
        try {
            for (char c : first.toCharArray()) {
                if (second.indexOf(c) >= 0)
                    return c;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        throw new IllegalStateException();
    }


    private static char findCommonCharacter(String first, String second, String third) {
        try {

            for (char c : first.toCharArray()) {
                if (second.indexOf(c) >= 0 && third.indexOf(c) >= 0)
                    return c;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        throw new IllegalStateException();
    }

    public static List<String> splitInHalf(String s) {
        int mid = s.length() / 2;
        return List.of(s.substring(0, mid), s.substring(mid));
    }

    public static <T> Collection<List<T>> createRows(List<T> inputList, int columnsPerRow) {
        AtomicInteger counter = new AtomicInteger();
        System.err.println(inputList
                .stream()
                .collect(Collectors.groupingBy(gr -> counter.getAndIncrement() / columnsPerRow))
                .values());
        return inputList
                .stream()
                .collect(Collectors.groupingBy(gr -> counter.getAndIncrement() / columnsPerRow))
                .values();
    }

    public static void main(String[] args) {
        try {
            List<String> lines = readFile();
            problem1(lines);
            problem2(lines);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

}
