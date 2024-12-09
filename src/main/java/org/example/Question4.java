package org.example;

import java.util.Stack;

/**
 * Name:
 * Class Group:
 */

public class Question4  // Flood Fill (Stack, 2D Array)
{
    static final int ROWS = 5;
    static final int COLUMNS = 5;

    public static void main(String[] args)
    {
        System.out.println("Question 4. Floodfill algorithm.");

        // Starter matrix (2D Array) with 0 representing an empty cell,
        // and -1 representing a wall. Flood fill can not cross through
        // a wall ( and not pass through diagionally).
        //
        int[][] matrix = new int[ROWS][COLUMNS]; // 2D Array of int
        // define values for each row, -1 to prevent change
        matrix[0] = new int[]{ 0, 0, -1, -1, 0};
        matrix[1] = new int[]{ 0, 0, -1, -1, 0};
        matrix[2] = new int[]{-1, 0,  0,  0, 0};
        matrix[3] = new int[]{-1, 0, -1, -1, 0};
        matrix[4] = new int[]{ 0,-1, -1,  0, 0};

        System.out.println("Original matrix");
        display(matrix);
        floodFill(1, 1, matrix);
        System.out.println("Filled matrix");
        display(matrix);

    }

    /*
        Helper function to display the 2D Array
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < ROWS; x++)
        {
            for (int y = 0; y < COLUMNS; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }

    private static void floodFill(int r, int c, int[][] arr)
    {
        if (arr[r][c] == -1)
        {
            System.out.println("Cannot change this cell");
            return;
        }
        Stack<Cell> stack = new Stack<>();
        stack.push(new Cell(c, r));
        int counter = 0;
        while (!stack.empty())
        {
            Cell cell = stack.pop();
//            System.out.println("Working on [" + cell.r + "," + cell.c + "], counter " + counter);

            if (arr[cell.r][cell.c] == 0)
            {
                counter++;
                arr[cell.r][cell.c] = counter;
                if (cell.r > 0)
                    stack.push(new Cell(cell.r - 1, cell.c));
                if (cell.r < ROWS - 1)
                    stack.push(new Cell(cell.r + 1, cell.c));
                if (cell.c > 0)
                    stack.push(new Cell(cell.r, cell.c - 1));
                if (cell.c < COLUMNS - 1)
                    stack.push(new Cell(cell.r, cell.c + 1));
            }
//            printStack(stack);
        }
    }

    private static void printStack(Stack<Cell> stack)
    {
        for (Cell cell : stack)
        {
            System.out.print("[" + cell.r + "," + cell.c + "] ");
        }
        System.out.println();
    }

    private static class Cell
    {
        int c, r;

        public Cell(int r, int c)
        {
            this.c = c;
            this.r = r;
        }
    }
}
