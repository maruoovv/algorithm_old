package week4;

import java.util.*;
//leetcode #48
public class RotateImage {
    public void rotate(int[][] matrix) {
        int size=matrix.length;
        Queue<Integer> numList=new LinkedList<Integer>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                numList.add(matrix[i][j]);
            }
        }
        for(int j=size-1;0<=j;j--){
            for(int i=0;i<size;i++){
                matrix[i][j]=numList.poll();
            }
        }
    }
}
