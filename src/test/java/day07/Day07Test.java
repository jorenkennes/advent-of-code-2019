package day07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import util.Util;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class Day07Test {

    int[] INPUT_1 = {3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0};

    @Mock
    Util util;

    @Test
    public void executePart1_INPUT_1_expects_43210() throws IOException {
        when(util.readIntStream(any(), ",")).thenReturn(Arrays.stream(INPUT_1));
        assertThat(new Day07(util).executePart1()).isEqualTo(43210);
    }

    @Test
    public void executePart2() {
    }
}
