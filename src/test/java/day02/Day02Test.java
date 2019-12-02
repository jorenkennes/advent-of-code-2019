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
    public void exercise1_given_LIST_A_expects_first_3500() {
        Day02 day02 = new Day02();
        List<Integer> finalList = day02.exercise1(LIST_A);
        assertThat(finalList).isEqualTo(LIST_A_RESULT);
        assertThat(finalList.get(0)).isEqualTo(3500);
    }

    @Test
    public void exercise1_given_LIST_B_expects_first_2() {
        Day02 day02 = new Day02();
        List<Integer> finalList = day02.exercise1(LIST_B);
        assertThat(finalList).isEqualTo(LIST_B_RESULT);
        assertThat(finalList.get(0)).isEqualTo(2);
    }

    @Test
    public void exercise1_given_LIST_C_expects_first_2() {
        Day02 day02 = new Day02();
        List<Integer> finalList = day02.exercise1(LIST_C);
        assertThat(finalList).isEqualTo(LIST_C_RESULT);
        assertThat(finalList.get(0)).isEqualTo(2);
    }

    @Test
    public void exercise1_given_LIST_D_expects_first_2() {
        Day02 day02 = new Day02();
        List<Integer> finalList = day02.exercise1(LIST_D);
        assertThat(finalList).isEqualTo(LIST_D_RESULT);
        assertThat(finalList.get(0)).isEqualTo(2);
    }

    @Test
    public void exercise1_given_LIST_D_expects_first_30() {
        Day02 day02 = new Day02();
        List<Integer> finalList = day02.exercise1(LIST_E);
        assertThat(finalList).isEqualTo(LIST_E_RESULT);
        assertThat(finalList.get(0)).isEqualTo(30);
    }

    @Test
    public void setNounAndVerb() {
        int counter = 0;
        while (counter <= 9999) {
            System.out.println(counter / 100 + " " + counter % 100);
            counter++;
        }
    }
}
