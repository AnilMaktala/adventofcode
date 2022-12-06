package com.amaktala.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Day2 {

    enum Reference {
        A(Shape.ROCK),
        B(Shape.PAPER),
        C(Shape.SCISSORS),
        X(Shape.ROCK),
        Y(Shape.PAPER),
        Z(Shape.SCISSORS);
        public final Shape shape;

        private Reference(Shape shape) {
            this.shape = shape;
        }
    }

    enum Shape {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        public final int points;

        private Shape(int points) {
            this.points = points;
        }

        public Shape beats() {
            return switch (this) {
                case ROCK -> SCISSORS;
                case PAPER -> ROCK;
                case SCISSORS -> PAPER;
            };
        }
    }


    public static void getTotalScore(List<String> lines) {
        System.out.println(lines.stream()
                .map(str -> str.split(" "))
                .map(Day2::problem1)
                .mapToInt(Integer::intValue)
                .sum()
        );
    }

    public static void getTotalScore2(List<String> lines) {
        System.out.println(lines.stream()
                .map(str -> str.split(" "))
                .map(Day2::problem2)
                .mapToInt(Integer::intValue)
                .sum()
        );
    }

    public static int problem1(String[] players) {
        Reference opponent = Reference.valueOf(players[0]);
        Reference player = Reference.valueOf(players[1]);

        if (player.shape == opponent.shape) {
            return player.shape.points + 3;
        } else if (player.shape.beats() == opponent.shape) {
            return player.shape.points + 6;
        } else {
            return player.shape.points;
        }
    }

    public static int problem2(String[] players) {
        Reference opponent = Reference.valueOf(players[0]);
        Reference player = Reference.valueOf(players[1]);

        if (player == Reference.X) {
            return opponent.shape.beats().points;
        } else if (player == Reference.Y) {
            return opponent.shape.points + 3;
        } else {
            return opponent.shape.beats().beats().points + 6;
        }
    }

    private static List<String> readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("day2.txt"));
        return bufferedReader.lines().toList();

    }

    public static void main(String[] args) {
        try {
            List<String> lines = readFile();
            getTotalScore(lines);
            getTotalScore2(lines);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
