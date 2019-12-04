package day04;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.DateUtil;
import org.junit.Test;

import static org.junit.Assert.*;

public class Day04Test {

    @Test
    public void findPassword() {
        Day04 day04 = new Day04();

    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_111122_returns_true() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("111122");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_123444_returns_false() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("123444");
        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_112233_returns_true() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("112233");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_113456_returns_true() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("113456");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_803400_returns_true() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("803400");
        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void strictlyTwoAdjacentMatchingNumbers_input_779999_returns_true() {
        Day04 day04 = new Day04();
        boolean result = day04.strictlyTwoAdjacentMatchingNumbers("779999");
        Assertions.assertThat(result).isTrue();
    }
}
