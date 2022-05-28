package array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;
import org.junit.Test;

public class AppTest {
    private static int length;
    private static int range1;
    private static int range2;
    private static int expectedResult;

    /** array section init change the length value as you want */
    static {
        try {
            length = new Random().nextInt(8);// lenght of array if(>10000000) - heap space problem
        } catch (Exception e) {
            e.printStackTrace();
        }
        range1 = new Random().nextInt();// range1
        range2 = new Random().nextInt();// range2
        if (range1 == range2) {
            expectedResult = range1 + range1 + 1;
        } else if (range1 < range2) {
            expectedResult = range1 + range1 + 1;// expected cause we add 2 elements min and min+1
        } else {
            expectedResult = range2 + range2 + 1;
        }
        System.out.println(" array length (" + length + ")");
    }

    @Test
    public void testGenerateArray() {

        try {
            assertNotNull(App.generateArray(length, range1, range2));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Array generation problem");
        }
    }

    @Test
    public void testAlgCollections() {
        try {
            assertEquals(AppTest.expectedResult, App.algCollections(App.generateArray(length, range1, range2)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testAlgMath() {
        try {
            assertEquals(AppTest.expectedResult, App.algMath(App.generateArray(length, range1, range2)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testAlgSort() {
        try {
            assertEquals(AppTest.expectedResult, App.algSort(App.generateArray(length, range1, range2)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testAlgStream() {
        try {
            assertEquals(AppTest.expectedResult, App.algStream(App.generateArray(length, range1, range2)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void testAlgCompare() {
        try {
            assertEquals(AppTest.expectedResult, App.algCompare(App.generateArray(length, range1, range2)));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
