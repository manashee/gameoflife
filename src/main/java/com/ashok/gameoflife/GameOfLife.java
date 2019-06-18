package com.ashok.gameoflife;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class GameOfLife
{
    boolean [][] board;

    public GameOfLife(boolean[][] board){
        this.board = board.clone();
    }

    public void nextGen(){
        board = nextGenPure( board );
    }

    public boolean [][] nextGenPure( boolean [][] board ) {
        boolean [][] boardClone = board.clone();
        short [][]liveNeighbourCount = liveNeighboursPure(boardClone);

        for ( int row = 0 ; row < boardClone.length ; row++ ) {
            for ( int col = 0 ; col < boardClone[row].length ; col++ ) {
                if ( boardClone [row][col] ) {
                    if (liveNeighbourCount[row][col] < 2 || liveNeighbourCount[row][col] > 3) {
                        boardClone [row][col] = false;
                    }
                } else {
                    if (3 == liveNeighbourCount[row][col]) {
                        boardClone [row][col] = true;
                    }
                }
            }
        }
        return boardClone;
    }

    public short [][] liveNeighbours() {
        return liveNeighboursPure(board);
    }

    public short [][] liveNeighboursPure(boolean [][] board) {

        if ( null == board[0] )
        {
            return null;
        }

        short [][] liveNeighbourCount = new short[board.length][board[0].length];

        for ( int row = 0 ; row < board.length ; row++ ) {
            for ( int col = 0 ; col < board[row].length ; col++ ) {
                liveNeighbourCount[row][col] = liveNeighbours(row,col);
            }
        }
        return liveNeighbourCount;
    }

    public short liveNeighbours(int row, int col ) {
        short liveNeighbourCount = 0;

        int nextRow = row+1;
        int nextCol = col+1;
        int prevRow = row-1;
        int prevCol = col-1;

        if ( prevRow >= 0 ) {
            if ( prevCol >= 0) {
                if ( board [prevRow][prevCol] )
                    liveNeighbourCount++;
            }
            if ( board [prevRow][col] )
                liveNeighbourCount++;

            if ( nextCol < board [prevRow].length) {
                if ( board [prevRow][nextCol] )
                    liveNeighbourCount++;
            }
        }

        if ( prevCol >= 0) {
            if ( board [row][prevCol] )
                liveNeighbourCount++;
        }

        if ( nextCol < board [row].length) {
            if ( board [row][nextCol] )
                liveNeighbourCount++;
        }

        if ( nextRow < board.length ) {
            if ( prevCol >= 0) {
                if ( board [nextRow][prevCol] )
                    liveNeighbourCount++;
            }
            if ( board [nextRow][col] )
                liveNeighbourCount++;

            if ( nextCol< board [nextRow].length) {
                if ( board [nextRow][nextCol] )
                    liveNeighbourCount++;
            }
        }

    return liveNeighbourCount;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();

        for ( int row = 0 ; row < board.length ; row++ ) {
            for ( int col = 0 ; col < board[row].length ; col++ ) {
                stringBuilder.append( board[row][col] ? 'x' : ' ');
            }
            stringBuilder.append( System.lineSeparator() );
        }
        return stringBuilder.toString();
    }


    public static void main( String[] args ) throws Exception
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

        for ( int i = 0 ; i < 5 ; i++ ) {
            System.out.println( gameOfLife.toString() );
            System.out.println(Arrays.deepToString(gameOfLife.liveNeighbours() ));

            gameOfLife.nextGen();
            Thread.sleep(1000);
        }
    }
}
