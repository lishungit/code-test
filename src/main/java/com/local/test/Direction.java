package com.local.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Direction {

    private static final String SOUTH = "SOUTH";
    private static final String NORTH = "NORTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";

    public static String[] solution(String[] dirs) {
        List<String> dirResult = new ArrayList<>();
        for (int i = 0; i < dirs.length - 1; i++) {
            final String preDir = dirs[i];
            final String nextDir = dirs[i + 1];
            if (!isOpposite(preDir, nextDir)) {
                if (!dirResult.contains(preDir)) dirResult.add(preDir);
                if (!dirResult.contains(nextDir)) dirResult.add(nextDir);
            }
        }
        return dirResult.stream().toArray(String[]::new);
    }

    private static boolean isOpposite(final String preDir,
                                      final String nextDir) {
        if ((preDir.equals(SOUTH) && nextDir.equals(NORTH))
                || (preDir.equals(NORTH) && nextDir.equals(SOUTH))
                || (preDir.equals(EAST) && nextDir.equals(WEST))
                || (preDir.equals(WEST) && nextDir.equals(EAST))) {
            return true;
        }
        return false;
    }
}
