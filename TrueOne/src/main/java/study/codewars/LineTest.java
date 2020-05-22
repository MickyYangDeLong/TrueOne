package study.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LineTest {
    @Test
    public void test1() {
        assertEquals("YES", Line.Tickets(new int[] {25, 25, 50,50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", Line.Tickets(new int []{25, 100}));
    }
    @Test
    public void test3() {
        assertEquals("NO", Line.Tickets(new int []{25, 25, 50, 50, 100}));
    }
    @Test
    public void test4() {
        assertEquals("NO", Line.Tickets(new int[] {25, 25, 50,50,50}));
    }
}
