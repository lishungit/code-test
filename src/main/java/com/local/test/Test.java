package com.local.test;

public class Test {

    public static void main(String[] args) {
        final int size = 3;
        System.out.println(climbStairs(size));
    }

    public static int climbStairs(int n) {
        int[] step = new int[n + 1];
        if (n < 2) return n;
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i < step.length; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }
}
