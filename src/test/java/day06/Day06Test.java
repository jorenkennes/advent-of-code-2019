package day06;

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
public class Day06Test {

    List<String> orbitMap = List.of("COM)B","B)C", "C)D", "D)E", "E)F","B)G", "G)H", "D)I", "E)J", "J)K","K)L");
    List<String> orbitMap2 = List.of("COM)B","B)C", "C)D", "D)E", "E)F","B)G", "G)H", "D)I", "E)J", "J)K","K)L", "K)YOU",
    "I)SAN");

    @Mock
    Util util;

    @Test
    public void executePart1() throws IOException {
        when(util.readFile(any())).thenReturn(orbitMap);
        assertThat(new Day06(util).executePart1()).isEqualTo(42);
    }

    @Test
    public void executePart2() throws IOException {
        when(util.readFile(any())).thenReturn(orbitMap2);
        assertThat(new Day06(util).executePart2()).isEqualTo(4);
    }
}
