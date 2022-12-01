package com.amaktala.adventofcode;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day1 {
    private static final String DATA_FILE = "./day1-input.txt";
    private static final String EOL = "\\n";

    private List<Integer> readData() throws IOException {
        var content = new String(Files.readAllBytes(Paths.get(DATA_FILE)));

        return Arrays.stream(content.split(EOL+EOL))
                .map(elf -> Arrays.stream(elf.split(EOL)).mapToInt(Integer::parseInt).sum())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    private void findMostCalories() throws IOException {
        var dataList = readData();
        System.out.println(String.format("Part 1: %d", dataList.get(0)));

    }

    private void findTop3MostCalHolders() throws IOException{
        var dataList = readData();
        var total = IntStream.range(0, 3).map(i -> dataList.get(i)).sum();
        System.out.println(String.format("Part 2: %d", total));
    }
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        try {
            day1.findMostCalories();
            day1.findTop3MostCalHolders();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}