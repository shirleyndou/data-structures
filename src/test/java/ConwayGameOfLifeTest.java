import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ConwayGameOfLifeTest {

    @Test
    void nextGenerationTest() {
        ConwayGameOfLife gol = new ConwayGameOfLife(10,10);

        int alive =1;
        int dead =0;
        int[][] grid = new int[alive][dead];

        assertArrayEquals(alive, gol.nextGeneration());
        assertArrayEquals(dead, gol.nextGeneration());

    }

    private void assertArrayEquals(int alive, int[][] nextGeneration) {
    }
}