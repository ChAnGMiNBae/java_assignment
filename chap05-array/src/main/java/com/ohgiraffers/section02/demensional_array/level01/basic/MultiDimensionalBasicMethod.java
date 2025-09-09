package com.ohgiraffers.section02.demensional_array.level01.basic;

public class MultiDimensionalBasicMethod {
    public void multiDimensionalAdvancedApplication1() {
        int[][] arr = new int[3][4];
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = count++;
            }
        }

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
