package org.depaul.logic.util;

import java.util.List;
import java.util.stream.Collectors;

public class Operations {


    //No instantiation!
    private Operations(){

    }

    public static boolean intersectMatrix(final int[][] matrix, final int[][] brick, int x, int y) {
        for (int i = 0; i < brick.length; i++) {
            for (int j = 0; j < brick[i].length; j++) {
                int targetX = x + i;
                int targetY = y + j;
                if (brick[j][i] != 0 && (checkOutOfBound(matrix, targetX, targetY) || matrix[targetY][targetX] != 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkOutOfBound(int[][] matrix, int targetX, int targetY) {
        boolean returnValue = targetX < 0 || targetY >= matrix.length || targetX >= matrix[targetY].length;
        return returnValue;
    }

    public static int[][] copyMatrix(int[][] original) {
        int[][] myInt = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            int[] ccMatrix = original[i];
            int ccLength = ccMatrix.length;
            myInt[i] = new int[ccLength];
            System.arraycopy(ccMatrix, 0, myInt[i], 0, ccLength);
        }
        return myInt;
    }

    public static int[][] mergeMatrix(int[][] filledFields, int[][] brick, int x, int y) {
        int[][] copy = copyMatrix(filledFields);
        for (int i = 0; i < brick.length; i++) {
            for (int j = 0; j < brick[i].length; j++) {
                int targetX = x + i;
                int targetY = y + j;
                if (brick[j][i] != 0) {
                    copy[targetY][targetX] = brick[j][i];
                }
            }
        }
        return copy;
    }

    public static List<int[][]> deepCopyList(List<int[][]> list){
        return list.stream().map(Operations::copyMatrix).collect(Collectors.toList());
    }

}
