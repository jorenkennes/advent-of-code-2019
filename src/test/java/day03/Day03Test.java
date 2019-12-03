package day03;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Day03Test {

    List<String> INPUT_1 = List.of("R75,D30,R83,U83,L12,D49,R71,U7,L72", "U62,R66,U55,R34,D71,R55,D58,R83");
    List<String> INPUT_2 = List.of("R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51", "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7");

    @Test
    public void findPositions() {
        Day03 day03 = new Day03();
        List<Position> d5 = day03.findPositions("D5,L1");
        d5.forEach(position -> System.out.println(position.getX() + "," + position.getY()));

        assertThat(d5.get(0).getY()).isEqualTo(-1);
        assertThat(d5.get(1).getY()).isEqualTo(-2);
        assertThat(d5.get(2).getY()).isEqualTo(-3);
        assertThat(d5.get(3).getY()).isEqualTo(-4);
        assertThat(d5.get(4).getY()).isEqualTo(-5);

        assertThat(d5.get(5).getX()).isEqualTo(-1);
        assertThat(d5.get(5).getY()).isEqualTo(-5);
    }

    @Test
    public void findWires_INPUT1_expects_159() {
        Day03 day03 = new Day03();
        int distance = day03.findWires(INPUT_1);
        assertThat(distance).isEqualTo(159);
    }

    @Test
    public void findWires_INPUT2_expects_135() {
        Day03 day03 = new Day03();
        int distance = day03.findWires(INPUT_2);
        assertThat(distance).isEqualTo(135);
    }
}
