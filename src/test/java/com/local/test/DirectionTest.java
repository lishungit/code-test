package com.local.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

    @Test
    public void solutionTest() {
        final String[] dirSource = {"SOUTH", "NORTH", "NORTH", "EAST", "WEST"};
        System.out.println("Solution before:");
        Arrays.stream(dirSource).map(str -> str + ",").forEach(System.out::print);
        System.out.println();

        final String[] dirResult = Direction.solution(dirSource);
        System.out.println("Solution after:");
        Arrays.stream(dirResult).map(str -> str + ",").forEach(System.out::print);

        final String[] expectedDirs = {"NORTH","EAST"};
        Assert.assertArrayEquals("",expectedDirs, dirResult);
    }
}
