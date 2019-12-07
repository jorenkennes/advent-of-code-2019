package day05;

import common.Day;
import util.Util;

import java.io.IOException;

public class Day05 extends Day {

    public static void main(String[] args) throws IOException {
        new Day05().printResults();
    }

    public int runProgram(int[] input, int programInput) {
        int result = 0;
        int opcodePosition = 0;
        int[] valuePositions;
        while (true) {
            String extendedOpcode = parseOpcode(input[opcodePosition]);
            int opcode = Integer.parseInt(extendedOpcode.substring(extendedOpcode.length() - 2));
            int[] paramModes = getParamModes(extendedOpcode);
            switch (opcode) {
                case 1:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    input[valuePositions[0]] = input[valuePositions[2]] + input[valuePositions[1]];
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 2:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    input[valuePositions[0]] = input[valuePositions[2]] * input[valuePositions[1]];
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 3:
                    //take input save to address in param 1
                    input[input[opcodePosition + 1]] = programInput;
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 4:
                    //take value at address in param 1 and output it
                    int valuePosition = getValuePosition(input, opcodePosition, paramModes);
                    System.out.println(input[valuePosition]);
                    result = input[valuePosition];
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 5:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    if (input[valuePositions[2]] != 0) {
                        opcodePosition = input[valuePositions[1]];
                    } else {
                        opcodePosition += findInstructionLength(opcode);
                    }
                    break;
                case 6:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    if (input[valuePositions[2]] == 0) {
                        opcodePosition = input[valuePositions[1]];
                    } else {
                        opcodePosition += findInstructionLength(opcode);
                    }
                    break;
                case 7:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    input[valuePositions[0]] = input[valuePositions[2]] < input[valuePositions[1]] ? 1 : 0;
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 8:
                    valuePositions = performParamMode(paramModes, opcodePosition, input);
                    input[valuePositions[0]] = input[valuePositions[2]] == input[valuePositions[1]] ? 1 : 0;
                    opcodePosition += findInstructionLength(opcode);
                    break;
                case 99:
                    return result;
            }
        }
    }

    private int getValuePosition(int[] input, int opcodePosition, int[] paramModes) {
        int valuePosition;
        if (paramModes[2] == 0) {
            valuePosition = input[opcodePosition + 1];
        } else {
            valuePosition = opcodePosition + 1;
        }
        return valuePosition;
    }

    private int[] getParamModes(String extendedOpcode) {
        String params = extendedOpcode.substring(0, 3);
        int[] result = new int[3];
        for (int i = 0; i < params.length(); i++) {
            result[i] = Integer.parseInt(params.substring(i, i + 1));
        }
        return result;
    }

    private int[] performParamMode(int[] paramsModes, int opcodePosition, int[] input) {
        int[] positions = new int[3];
        for (int i = 0; i < paramsModes.length; i++) {
            if (paramsModes[i] == 0) {
                //position mode
                positions[i] = input[opcodePosition + 3 - i];
            } else {
                //immediate mode
                positions[i] = opcodePosition + 3 - i;
            }
        }
        return positions;
    }

    private String parseOpcode(int opcode) {
        return String.format("%05d", opcode);
    }

    private int findInstructionLength(int opcode) {
        switch (opcode) {
            case 1:
            case 2:
                return 4;
            case 3:
            case 4:
                return 2;
            case 5:
            case 6:
                return 3;
            case 7:
            case 8:
                return 4;
            case 99:
                return 1;
        }

        return 0;
    }


    @Override
    public int executePart1() throws IOException {
        return runProgram(new Util().readIntStream("day05.txt").toArray(), 1);
    }

    @Override
    public int executePart2() throws IOException {
        return runProgram(new Util().readIntStream("day05.txt").toArray(), 5);
    }
}
