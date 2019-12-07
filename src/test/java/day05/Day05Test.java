package day05;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Day05Test {

    int[] INPUT_POSITION_MODE_EQUALS = {3,9,8,9,10,9,4,9,99,-1,8};
    int[] INPUT_POSITION_MODE_LESS_THAN = {3,9,7,9,10,9,4,9,99,-1,8};
    int[] INPUT_IMMEDIATE_MODE_EQUALS = {3,3,1108,-1,8,3,4,3,99};
    int[] INPUT_IMMEDIATE_MODE_LESS_THAN = {3,3,1107,-1,8,3,4,3,99};
    int[] POSITION_MODE_JUMP = {3,12,6,12,15,1,13,14,13,4,13,99,-1,0,1,9};
    int[] IMMEDIATE_MODE_JUMP = {3,3,1105,-1,9,1101,0,0,12,4,12,99,1};
    int[] BIG_EXAMPLE = {3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
            1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
            999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99};

    @Test
    public void runProgram_given_POSITION_MODE_EQUALS_when_input_8_expects_1() {
        assertThat(new Day05().runProgram(INPUT_POSITION_MODE_EQUALS, 8)).isEqualTo(1);
    }

    @Test
    public void runProgram_given_POSITION_MODE_EQUALS_when_input_Not8_expects_0() {
        assertThat(new Day05().runProgram(INPUT_POSITION_MODE_EQUALS, 7)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_POSITION_MODE_LESS_THAN_when_input_less_than_8_expects_1() {
        assertThat(new Day05().runProgram(INPUT_POSITION_MODE_LESS_THAN, 7)).isEqualTo(1);
    }

    @Test
    public void runProgram_given_POSITION_MODE_LESS_THAN_when_input_more_than_8_expects_0() {
        assertThat(new Day05().runProgram(INPUT_POSITION_MODE_LESS_THAN, 9)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_IMMEDIATE_MODE_EQUALS_when_input_8_expects_1() {
        assertThat(new Day05().runProgram(INPUT_IMMEDIATE_MODE_EQUALS, 8)).isEqualTo(1);
    }

    @Test
    public void runProgram_given_IMMEDIATE_MODE_EQUALS_when_input_Not8_expects_0() {
        assertThat(new Day05().runProgram(INPUT_IMMEDIATE_MODE_EQUALS, 9)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_INPUT_IMMEDIATE_MODE_LESS_THAN_when_input_less_than_8_expects_1() {
        assertThat(new Day05().runProgram(INPUT_IMMEDIATE_MODE_LESS_THAN, 7)).isEqualTo(1);
    }

    @Test
    public void runProgram_given_INPUT_POSITION_MODE_LESS_THAN_when_input_more_than_8_expects_0() {
        assertThat(new Day05().runProgram(INPUT_IMMEDIATE_MODE_LESS_THAN, 9)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_POSITION_MODE_JUMP_when_input_0_expects_0() {
        assertThat(new Day05().runProgram(POSITION_MODE_JUMP, 0)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_IMMEDIATE_MODE_JUMP_when_input_0_expects_0() {
        assertThat(new Day05().runProgram(IMMEDIATE_MODE_JUMP, 0)).isEqualTo(0);
    }

    @Test
    public void runProgram_given_large_example_when_input_less_than_8_expects_999() {
        assertThat(new Day05().runProgram(BIG_EXAMPLE, 5)).isEqualTo(999);
    }

    @Test
    public void runProgram_given_large_example_when_input_equal_to_8_expects_1000() {
        assertThat(new Day05().runProgram(BIG_EXAMPLE, 8)).isEqualTo(1000);
    }

    @Test
    public void runProgram_given_large_example_when_input_more_than_8_expects_1001() {
        assertThat(new Day05().runProgram(BIG_EXAMPLE, 10)).isEqualTo(1001);
    }
}
