package day02;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day02Test {

    List<Integer> LIST_A = List.of(1,9,10,3,2,3,11,0,99,30,40,50);
    List<Integer> LIST_A_RESULT = List.of(3500,9,10,70,2,3,11,0,99,30,40,50);

    List<Integer> LIST_B = List.of(1,0,0,0,99);
    List<Integer> LIST_B_RESULT = List.of(2,0,0,0,99);

    List<Integer> LIST_C = List.of(2,3,0,3,99);
    List<Integer> LIST_C_RESULT = List.of(2,3,0,6,99);

    List<Integer> LIST_D = List.of(2,4,4,5,99,0);
    List<Integer> LIST_D_RESULT = List.of(2,4,4,5,99,9801);

    List<Integer> LIST_E = List.of(1,1,1,4,99,5,6,0,99);
    List<Integer> LIST_E_RESULT = List.of(30,1,1,4,2,5,6,0,99);

    @Test
    public void runProgram_given_LIST_A_expects_LIST_A_RESULT() {
        Day02 day02 = new Day02();
        assertThat(day02.runProgram(LIST_A)).isEqualTo(LIST_A_RESULT);
    }

    @Test
    public void runProgram_given_LIST_B_expects_LIST_B_RESULT() {
        Day02 day02 = new Day02();
        assertThat(day02.runProgram(LIST_B)).isEqualTo(LIST_B_RESULT);
    }

    @Test
    public void runProgram_given_LIST_C_expects_LIST_C_RESULT() {
        Day02 day02 = new Day02();
        assertThat(day02.runProgram(LIST_C)).isEqualTo(LIST_C_RESULT);
    }

    @Test
    public void runProgram_given_LIST_D_expects_LIST_D_RESULT() {
        Day02 day02 = new Day02();
        assertThat(day02.runProgram(LIST_D)).isEqualTo(LIST_D_RESULT);
    }

    @Test
    public void runProgram_given_LIST_E_expects_LIST_E_RESULT() {
        Day02 day02 = new Day02();
        assertThat(day02.runProgram(LIST_E)).isEqualTo(LIST_E_RESULT);
    }
}
