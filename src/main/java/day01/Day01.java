package day01;

import common.Day;
import util.Util;

import java.io.IOException;

public class Day01 extends Day {

    private Util util;

    public static void main(String[] args) throws IOException {
        Day day01 = new Day01(new Util());
        day01.printResults();
    }

    public Day01(Util util) {
        this.util = util;
    }

    @Override
    public int executePart1() throws IOException {
        return util.readFile("day01.txt").stream()
                .map(mass -> new SpacecraftModule(Double.parseDouble(mass)))
                .map(SpacecraftModule::calculateFuel).mapToInt(Integer::intValue).sum();
    }

    @Override
    public int executePart2() throws IOException {
        return util.readFile("day01.txt").stream()
                .map(mass -> new SpacecraftModule(Double.parseDouble(mass)))
                .map(spacecraftModule -> spacecraftModule.calculateTotalFuel(spacecraftModule.getMass()))
                .mapToInt(Integer::intValue).sum();
    }
}
