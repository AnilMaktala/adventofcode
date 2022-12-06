package com.amaktala.adventofcode;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6 {

    private static int findMarker(String inputString, int packetSize) {
        return IntStream.range(packetSize, inputString.length())
                .mapToObj(i -> inputString.substring(i - packetSize, i))
                .filter(s -> s.chars().distinct().count() == packetSize)
                .mapToInt(inputString::indexOf)
                .findFirst()
                .getAsInt() + packetSize;
    }

    private static String readFile() throws IOException {
        Scanner scanner = new Scanner(Paths.get("Day6.txt"));
        return scanner.nextLine();

    }

    public static void main(String[] args) {
        try {
            String content = readFile();
            System.out.println(findMarker(content, 4));
            System.out.println(findMarker(content, 14));
        } catch (Exception exception) {
            System.out.println(exception.getLocalizedMessage());
        }

    }

}
