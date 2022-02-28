package hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 华为2016研发工程师编程题
 * 3. 数独 :输入9行，每行为空格隔开的9个数字，为0的地方就是需要填充的。
 */
public class Sudoku {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] row = new String[9];
        //接收数独
        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            row[i] = in.nextLine();
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = Integer.parseInt(row[i].split(" ")[j]);
            }
        }
        Sudoku sudoku = new Sudoku();
        sudoku.getSudoku(0,0, matrix);
    }

    public void getSudoku(int rowStart,int colStart, int[][] matrix){
        //当横竖斜都不重复时，，代表数独成立
        if (checkRow(matrix) && checkColumn(matrix) && checkLeftOblique(matrix) && checkRightOblique(matrix)){
            System.out.println(matrix);
            return;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0){

                }

            }
        }
    }

    public void getRestNum(int[] line){
        int[] rest = new int[9- line.length];
        int index = 0;
        //0-9的数字，给出不重复的剩余数字
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < line.length; j++) {
                if (line[j]==i){
                    continue;
                }
                rest[index++] = line[j];
            }
        }
    }

    /**
     * 检查横向是否不重复
     * @param matrix
     * @return
     */
    public boolean checkRow(int[][] matrix){
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                set.add(matrix[i][j]);
            }
            if (set.size()==9){
                flag++;
            }
        }
        if (flag == 9){
            return true;
        }
        return false;
    }

    /**
     * 检查纵向是否不重复
     * @param matrix
     * @return
     */
    public boolean checkColumn(int[][] matrix){
        int flag = 0;
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                set.add(matrix[j][i]);
            }
            if (set.size()==9){
                flag++;
            }
        }
        if (flag == 9){
            return true;
        }
        return false;
    }

    /**
     * 检查左斜向是否不重复
     * @param matrix
     * @return
     */
    public boolean checkLeftOblique(int[][] matrix){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(matrix[i][i]);
        }
        if (set.size()== 9){
            return true;
        }
        return false;
    }


    /**
     * 检查右斜向是否不重复
     * @param matrix
     * @return
     */
    public boolean checkRightOblique(int[][] matrix){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set.add(matrix[i][8-i]);
        }
        if (set.size()== 9){
            return true;
        }
        return false;
    }
}
