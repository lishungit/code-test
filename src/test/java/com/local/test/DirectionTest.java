package com.local.test;

import java.util.Arrays;

public class DirectionTest {

    public static void main(String[] args) {
        final String[] dirSource = {"SOUTH", "NORTH", "NORTH", "EAST", "WEST"};
        System.out.println("Solution before:");
        Arrays.stream(dirSource).map(str -> str + ",").forEach(System.out::print);
        System.out.println();
        final String[] dirResult = Direction.solution(dirSource);
        System.out.println("Solution after:");
        Arrays.stream(dirResult).map(str -> str + ",").forEach(System.out::print);
    }
}
