package org.example.utility;

import java.util.List;

public class Utility {

    public static int[] integerListToArray(List<Integer> list){
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++) array[i] = list.get(i);
        return array;
    }

    public static String listToString(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (list.size() != 0) {
            for(int i = 1; i < list.size(); i++) sb.append(list.get(i) + ", ");
            sb.delete(sb.length()-2, sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
    public static String intArrayToString(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array.length != 0) {
            for(int i = 0; i < array.length; i++) sb.append(String.format("%2d", array[i]) + ", ");
            sb.delete(sb.length()-2, sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
    public static String charArrayToString(char[] array){

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array.length != 0) {
            for(int i = 0; i < array.length; i++) sb.append(array[i] + ", ");
            sb.delete(sb.length()-2, sb.length()-1);
        }
        sb.append("]");
        return sb.toString();
    }
    public static void printList(List<Integer> list){
        System.out.println(listToString(list));
    }
    public static void printList(int[] array){
        System.out.println(intArrayToString(array));
    }

    public static void print2dMatrix(char[][] matrix){

        for (int row = 0; row < matrix.length; row++){
            System.out.println(charArrayToString(matrix[row]));
        }

    }

    public static void print2dMatrix(int[][] matrix){
        System.out.println();
        for (int row = 0; row < matrix.length; row++){
            System.out.println(intArrayToString(matrix[row]));
        }

    }
}
