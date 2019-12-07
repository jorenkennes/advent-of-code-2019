package common;

import java.io.IOException;

public abstract class Day {

    public abstract int executePart1() throws IOException;
    public abstract int executePart2() throws IOException;

    public void printResults() throws IOException {
        System.out.println("result part1: " + executePart1());
        System.out.println("result part2: " + executePart2());
    }
}
