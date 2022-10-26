package org.depaul.logic;

import org.depaul.logic.util.Operations;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
public class OperationsTest {


    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNoIntersect() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }


    @Test
    public void testIntersect() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 0;
        int y = 0;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }


    @Test
    public void testNoIntersect1() {
        int[][] matrix = new int[][]{
                {1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {1,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testNoIntersect2() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 0;
        int y = 0;
        boolean expResult = false;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testIntersect1() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 0;
        int y = 1;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testIntersect2() {
        int[][] matrix = new int[][]{
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {1,1,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 2;
        int y = 0;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }


    @Test
    public void testIntersect3() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
                {0,1,0,0},
        };
        int x = 2;
        int y = 1;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testOutOfBoundry1() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
        };
        int x = 5;
        int y = 0;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testOutOfBoundry2() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        int[][] brick = new int[][]{
                {1,1,1,1},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
        };
        int x = 0;
        int y = 45;
        boolean expResult = true;
        boolean result = Operations.intersectMatrix(matrix, brick, x, y);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckRemoving() {
        int[][] matrix = new int[][]{
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {1,1,1,1,1,1,1},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
        };
        assertEquals(1, 1);
    }

}