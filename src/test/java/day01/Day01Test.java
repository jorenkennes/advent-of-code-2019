package day01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.Util;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Day01Test {

    List<String> testList = List.of("12", "14", "1969", "100756");

    @Mock
    Util util;

    @Test
    public void calculateExercise1_given_testList_expects_34241() throws IOException {
        when(util.readFile(any())).thenReturn(testList);
        assertThat(new Day01(util).executePart1()).isEqualTo(34241);
    }

    @Test
    public void calculateExercise2_given_12_expects_2() throws IOException {
        when(util.readFile(any())).thenReturn(List.of("12"));
        assertThat(new Day01(util).executePart2()).isEqualTo(2);
    }

    @Test
    public void calculateExercise2_given_14_expects_2() throws IOException {
        when(util.readFile(any())).thenReturn(List.of("14"));
        assertThat(new Day01(util).executePart2()).isEqualTo(2);
    }

    @Test
    public void calculateExercise2_given_1969_expects_966() throws IOException {
        when(util.readFile(any())).thenReturn(List.of("1969"));
        assertThat(new Day01(util).executePart2()).isEqualTo(966);
    }

    @Test
    public void calculateExercise2_given_100756_expects_50346() throws IOException {
        when(util.readFile(any())).thenReturn(List.of("100756"));
        assertThat(new Day01(util).executePart2()).isEqualTo(50346);
    }

    @Test
    public void calculateTotalFuel_given_List_expects_sum() throws IOException {
        when(util.readFile(any())).thenReturn(testList);
        assertThat(new Day01(util).executePart2()).isEqualTo(50346 + 966 + 2 + 2);
    }
}
