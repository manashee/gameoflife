package com.ashok.gameoflife;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple GameOfLife.
 */
public class GameOfLifeTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void toStringTest()
    {
        boolean [][] board = {
                {true,true,true},
                {true,true,false},
                {true,false,true},
                {false,true,true},
                {false,false,false}
        };

        String boardString = "xxx\n" +
                "xx \n" +
                "x x\n" +
                " xx\n" +
                "   \n";

        GameOfLife gameOfLife = new GameOfLife(board);
        assertEquals( boardString , gameOfLife.toString() );
    }


    @Test
    public void liveNeighboursTest()
    {
        boolean [][] board = {
                {true,true,true},
                {true,true,false},
                {true,false,true},
                {false,true,true},
                {false,false,false}
        };

        GameOfLife gameOfLife = new GameOfLife(board);
        short [][] expectedLiveNeighbourCounts = {
                {3,4,2},
                {4,6,4},
                {3,6,3},
                {2,3,2},
                {1,2,2},
        };
        short [][]actualLiveNeighbourCounts = gameOfLife.liveNeighbours();

        assertArrayEquals(expectedLiveNeighbourCounts,actualLiveNeighbourCounts);
    }

    @Test
    public void underPopulationTest()
    {
        boolean [][] board = {
                {false,true,false},
                {false,true,false},
                {false,true,false}
        };

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        String boardString =
                "   \n" +
                        "xxx\n" +
                        "   \n";
        assertEquals(boardString,gameOfLife.toString());
    }

    @Test
    public void liveOnTest()
    {

        boolean [][] board = {
                {true,true},
                {true,true}
        };

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();


        String boardString =
                "xx\n" +
                        "xx\n";
        assertEquals(boardString,gameOfLife.toString());
    }

    @Test
    public void overCrowdingTest()
    {

        boolean [][] board = {
                {true,true,false},
                {true,true,false},
                {true,false,false}
        };

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();


        String boardString =
                "xx \n" +
                        "   \n" +
                        "xx \n";
        assertEquals(boardString,gameOfLife.toString());
    }

    @Test
    public void reproductionTest()
    {
        boolean [][] board = {
                {false,true},
                {true,true}
        };

        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        String boardString =
                "xx\n" +
                "xx\n";
        assertEquals(boardString,gameOfLife.toString());
    }

    @Test
    public void nextGenTest()
    {
        boolean [][] board = {
                {true,true,true},
                {true,true,false},
                {true,false,true},
                {false,true,true},
                {false,false,false},
                {false,true,false},
                {true,true,false}
        };



        GameOfLife gameOfLife = new GameOfLife(board);
        gameOfLife.nextGen();

        String boardString =
                "x x\n" +
                        "   \n" +
                        "x x\n" +
                        " xx\n" +
                        " xx\n" +
                        "xx \n" +
                        "xx \n";

        assertEquals(boardString,gameOfLife.toString());
    }

}
