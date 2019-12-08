package day08;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.Util;

import java.io.IOException;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Day08Test {

    int[] layer_0 = new int[]{2, 1, 2, 0, 0};
    int[] layer_1 = new int[]{2, 1, 0, 0, 0};
    int[] layer_2 = new int[]{2, 1, 2, 1, 2};
    int[][] pixelgroup = new int[][]{layer_0, layer_1, layer_2};
    IntStream pixels = IntStream.of(1,2,3,4,5,6,7,8,9,0,1,2);

    @Mock
    Util util;

    @Test
    public void executePart1() throws IOException {
        when(util.readIntStream(any(), eq(""))).thenReturn(pixels);
        Assertions.assertThat(new Day08(util).findOnesAndTwos(3,2)).isEqualTo(1);
    }

    @Test
    public void getLayerFewest0Digits() {
        assertThat(new Day08(util).getLayerFewest0Digits(pixelgroup)).isEqualTo(2);
    }
}
