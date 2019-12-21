package ua.edu.ucu;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class StreamAppTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamToArray() {
        System.out.println("streamToArray");
        int[] expResult = {-1, 0, 1, 2, 3};
        int[] result = StreamApp.streamToArray(intStream);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testStreamForEach() {
        System.out.println("streamForEach");
        String expResult = "-10123";
        String result = StreamApp.streamForEach(intStream);
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamAverage() {
        System.out.println("StreamAverage");
        double expResult = 1.0;
        double result = intStream.average();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testStreamMax() {
        System.out.println("StreamMax");
        double expResult = 3;
        double result = intStream.max();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testStreamMin() {
        System.out.println("StreamMin");
        double expResult = -1;
        double result = intStream.min();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testStreamCount() {
        System.out.println("StreamCount");
        double expResult = 5;
        double result = intStream.count();
        assertEquals(expResult, (Object) result);
    }

    @Test
    public void testStreamSum() {
        System.out.println("StreamSum");
        double expResult = 5;
        double result = intStream.sum();
        assertEquals(expResult, (Object) result);
    }
    @Test
    public void testStreamFilter() {
        System.out.println("StreamFilter");
        int[] expResult = {2, 3};
        intStream = intStream.filter(x -> x > 1);
        assertArrayEquals(expResult, intStream.toArray());
    }
    @Test
    public void testStreamMap() {
        System.out.println("StreamMap");
        int[] expResult = {1, 0, 1, 4, 9};
        intStream = intStream.map(x -> x * x);
        assertArrayEquals(expResult, intStream.toArray());
    }
    @Test
    public void testStreamReduce() {
        System.out.println("StreamReduce");
        int expResult = 5;
        int result = intStream.reduce(0, (sum, x) -> sum += x);
        assertEquals(expResult, result);
    }
    @Test
    public void testStreamFlatMap() {
        System.out.println("testStreamFlatMap");
        int[] expResult = {-3, -1, -2, 0, -1, 1, 0, 2, 1, 3};
        intStream = intStream.flatMap(x -> AsIntStream.of(x-2, x));
        assertArrayEquals(expResult, intStream.toArray());
    }
}

