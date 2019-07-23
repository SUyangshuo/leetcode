package exam.medium.Rule;

import java.util.HashSet;

public class ValidSudoku {
    //36. Valid Sudoku
    /**
     * 判断给定的9*9数独图是否可以满足要求
     * 每行，每列没有重复的数字
     * 9个格子内没有重复的数字
     */
    public boolean isValidSudoku(char[][] board) {
        //该题的重点在于判断每个坐标的位置，用三个list来保存 行 列 子域的数字
        /**
         * 重点在于判断九宫格每个格子的坐标
         */

        for(int i=0;i<9;i++){
            HashSet<Character> row=new HashSet<>();
            HashSet<Character> column=new HashSet<>();
            HashSet<Character> cube=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]!='.' && !row.add(board[i][j])){
                    return false;
                }
                //这里用到了一个技巧，同时遍历行和列 行号和列好对称
                if(board[j][i]!='.' && !column.add(board[j][i])){
                    return false;
                }
                //根据i和j来求出第i个九宫格的每个格子坐标
                int cubeRow = 3*(i/3)+(j/3);
                int cubColumn = 3*(i%3)+(j%3);

                if (board[cubeRow][cubColumn] != '.'
                        && !cube.add(board[cubeRow][cubColumn]))
                    return false;

            }


        }

        return true;
    }
}
