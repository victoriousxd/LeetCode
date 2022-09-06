package org.example.lists;

import org.example.utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigZag {

    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();

        if (numRows == 1 || s.length() < numRows) {
            return s;
        }

        int window = numRows * 2 - 2;

        for (int i = 0; i < s.length(); i += window) {
            builder.append(s.charAt(i));
        }
        if (numRows > 2) {

            int jump = window - 1;
            for (int row = 1; row < numRows - 1; row++) {
                int index = row;
                while (index < s.length()) {
                    builder.append(s.charAt(index));
                    if (jump > 0 && index + jump - 1 < s.length()) {
                        builder.append(s.charAt(index + jump - 1));
                    }
                    index += window;

                }
                jump -= 2;
            }
        }
        for (int i = numRows - 1; i < s.length(); i += window) {
            builder.append(s.charAt(i));
        }
        return builder.toString();

    }


    public String naive(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        if (numRows == 1 || s.length() < numRows) {
            return s;
        }

        int width = numRows - 1;
        // figure out how many columns are needed
        int columnWidth = (s.length() / width);

        int[][] answer = naiveNumbers(s.length(), numRows);

        builder.append(s.charAt(0));
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < columnWidth; col++) {
                if (answer[row][col] != 0) {
                    builder.append(s.charAt(answer[row][col]));
                }
            }
        }
        //Utility.print2dMatrix(matrix);
        return builder.toString();

    }

    public List<Integer> buildAnswer(int length, int numRows) {
        int[][] answer = naiveNumbers(length, numRows);
        List<Integer> builder = new ArrayList<>(length);
        builder.add(0);
        for (int[] ints : answer) {
            for (int col = 0; col < answer[0].length; ++col) {
                if (ints[col] != 0) {
                    builder.add(ints[col]);
                }
            }
        }
        return builder;
    }

    // build answer by navigating a grid
    public int[][] naiveNumbers(int length, int numRows) {
        if (numRows == 1 || length < numRows) {

            int[][] matrix = new int[length][1];
            IntStream.range(0, length).forEach(x -> matrix[x][0] = x);
            return matrix;
        }
        int width = numRows - 1;
        int columnWidth = Math.ceilDiv(length, ((numRows * 2) - 2)) * width;
        int[][] matrix = new int[numRows][columnWidth];

        // figure out how many columns are needed
        //int columnWidth = (length / width) * width;


        int index = 0;
        int row = 0;
        int col = 0;

        while (index < length) {

            while (row < numRows && index < length) {

                matrix[row++][col] = index++;
            }
            row--;
            col++;
            while (col % width != 0 && row >= 0 && index < length && col < columnWidth) {
                matrix[--row][col++] = index++;
            }
            row = 0;
        }

        Utility.print2dMatrix(matrix);
        return matrix;


    }

    public List<Integer> betterNumbers(int length, int numRows) {
        List<Integer> builder = new ArrayList<>(length);

        if (numRows == 1 || length < numRows) {
            return IntStream.range(0, length).boxed().collect(Collectors.toList());
        }

        int window = numRows * 2 - 2;

        for (int i = 0; i < length; i += window) {
            builder.add(i);
        }
        if (numRows > 2) {

            int jump = window - 1;
            for (int row = 1; row < numRows - 1; row++) {
                int index = row;
                while (index < length) {
                    builder.add(index);
                    if (jump > 0 && index + jump - 1 < length) {
                        builder.add(index + jump - 1);
                    }
                    index += window;

                }
                jump -= 2;
            }
        }
        for (int i = numRows - 1; i < length; i += window) {
            builder.add(i);
        }
        return builder;


    }

}
