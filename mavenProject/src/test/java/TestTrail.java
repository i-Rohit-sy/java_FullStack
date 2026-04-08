import org.junit.jupiter.api.Test;

import java.util.Arrays;

import  static org.junit.jupiter.api.Assertions.*;
public class TestTrail {
    @Test
    void test(){
        int [] ex = {2,4,6,8};
        int [] ac = {8,6,4,2};
        Arrays.sort(ac);
        assertArrayEquals(ex,ac);
    }
}
