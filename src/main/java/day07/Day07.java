package day07;

import common.Day;
import day05.Day05;
import util.Util;

import java.io.IOException;

public class Day07 extends Day {

    private  Util util;

    public static void main(String[] args) throws IOException {
        new Day07(new Util()).printResults();
    }

    public Day07(Util util) {
        this.util = util;
    }

    @Override
    public int executePart1() throws IOException {
        int[] program = util.readIntStream("Day07.txt", ",").toArray();
        return new Day05().runProgram(program, new int[]{4, 0});
    }

    @Override
    public int executePart2() throws IOException {
        return 0;
    }
}
