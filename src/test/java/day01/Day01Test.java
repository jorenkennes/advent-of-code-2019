package day01;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Day01Test {

    List<String> testList = List.of("12", "14", "1969", "100756");

    @Test
    public void calculateExercise1() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise1(testList)).isEqualTo(34241);
    }

    @Test
    public void calculateExercise2_given_12_expects_2() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise2(List.of("12"))).isEqualTo(2);
    }

    @Test
    public void calculateExercise2_given_14_expects_2() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise2(List.of("14"))).isEqualTo(2);
    }

    @Test
    public void calculateExercise2_given_1969_expects_966() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise2(List.of("1969"))).isEqualTo(966);
    }

    @Test
    public void calculateExercise2_given_100756_expects_50346() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise2(List.of("100756"))).isEqualTo(50346);
    }

    @Test
    public void calculateTotalFuel_given_List_expects_sum() {
        Day01 day01 = new Day01();
        assertThat(day01.calculateExercise2(testList)).isEqualTo(50346 + 966 + 2 + 2);
    }
}
