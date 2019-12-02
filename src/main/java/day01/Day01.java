package day01;

import util.Util;

import java.io.IOException;
import java.util.List;

public class Day01 {

    public static void main(String[] args) throws IOException {
        Day01 day01 = new Day01();

        int result1 = day01.calculateExercise1(Util.readFile("day01.txt"));
        int result2 = day01.calculateExercise2(Util.readFile("day01.txt"));

        System.out.println(result1);
        System.out.println(result2);
    }

    Day01() {
    }

    int calculateExercise1(List<String> fileInput) {
        return fileInput.stream()
                .map(mass -> new SpacecraftModule(Double.valueOf(mass)))
                .map(SpacecraftModule::calculateFuel).mapToInt(Integer::intValue).sum();
    }

    int calculateExercise2(List<String> fileInput) {
        return fileInput.stream()
                .map(mass -> new SpacecraftModule(Double.valueOf(mass)))
                .map(spacecraftModule -> spacecraftModule.calculateTotalFuel(spacecraftModule.getMass()))
                .mapToInt(Integer::intValue).sum();
    }

}
