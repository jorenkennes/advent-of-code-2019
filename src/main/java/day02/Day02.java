package day02;

import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day02 {

    public static void main(String[] args) throws IOException {

        Day02 day02 = new Day02();

        List<Integer> input = Util.readCommaSeparatedFile("day02.txt");

        System.out.println(day02.exercise1(input));
        System.out.println(day02.exercise2(input));
    }

    int exercise1(List<Integer> input) {
        List<Integer> preprocessInput = preprocessInput(12, 2, input);
        return runProgram(preprocessInput).get(0);
    }

    List<Integer> runProgram(List<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>(input);
        int opcodeStartPosition = 0;
        while (true) {
            int operation = output.get(opcodeStartPosition);
            if (operation == 99) break;
            int posInputA = output.get(opcodeStartPosition + 1);
            int posInputB = output.get(opcodeStartPosition + 2);
            int posOutput = output.get(opcodeStartPosition + 3);
            if (operation == 1) {
                output.set(posOutput, Math.addExact(output.get(posInputA), output.get(posInputB)));
            } else if (operation == 2) {
                output.set(posOutput, Math.multiplyExact(output.get(posInputA), output.get(posInputB)));
            }
            opcodeStartPosition += 4;
        }
        return output;
    }

    private ArrayList<Integer> preprocessInput(int input1, int input2, List<Integer> input) {
        ArrayList<Integer> output = new ArrayList<>(input);
        output.set(1, input1);
        output.set(2, input2);
        return output;
    }

    int exercise2(List<Integer> input) {
        int result = 0;
        int counter = 0;
        while (counter <= 9999) {
            List<Integer> output = new ArrayList<>(input);
            output = preprocessInput(counter / 100, counter % 100, output);
            result = runProgram(output).get(0);
            if (result == 19690720) break;
            counter++;
        }
        System.out.println(counter);
        System.out.println(result);
        return counter;
    }
}
