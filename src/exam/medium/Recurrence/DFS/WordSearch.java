package exam.medium.Recurrence.DFS;

public class WordSearch {
    public static void main(String[] args) {
        Solution_WordSearch solution=new Solution_WordSearch();
        char[][] board =new char[][]{{'A'}};
       System.out.print( solution.exist(board,"AB"));

    }
}
/**
 *79. Word Search
 * 给定一个二维数组，和一个单词，判断从二维数组中的一点能够遍历出单词，每个位置只能用一次
 */
class Solution_WordSearch {
    //普通递归，耗时较长
    public boolean exist(char[][] board, String word) {
        char[] wordChar=word.toCharArray();

        int index=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==wordChar[0]){
                    //还可以不使用额外空间，使用数组自身的空间做标记
                    boolean[][] used=new boolean[board.length][board[0].length];
                    used[i][j]=true;

                    if(DFS(board,wordChar,i,j,used,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean DFS(char[][] board,char[] wordChar,int i,int j,boolean[][] used,int index){
        //判断上下左右
        if(index<wordChar.length){
            if(i-1>=0 && board[i-1][j] == wordChar[index] && !used[i-1][j] ){//上
                used[i-1][j]=true;
                if(DFS(board,wordChar,i-1,j,used,index+1))
                    return true;
                used[i-1][j]=false;
            }
            if(i+1<board.length && board[i+1][j] == wordChar[index] && !used[i+1][j]){//下
                used[i+1][j]=true;
                if(DFS(board,wordChar,i+1,j,used,index+1))
                    return true;
                used[i+1][j]=false;
            }
            if (j-1>=0 && board[i][j-1] == wordChar[index] && !used[i][j-1]) {//左
                used[i][j-1]=true;
                if(DFS(board,wordChar,i,j-1,used,index+1))
                    return true;
                used[i][j-1]=false;
            }
            if(j+1<board[0].length && board[i][j+1] == wordChar[index] && !used[i][j+1]){
                used[i][j+1]=true;
                if(DFS(board,wordChar,i,j+1,used,index+1))
                    return true;
                used[i][j+1]=false;
            }
        }else{
            return true;
        }
        return false;
    }
    /**
     * 优化方案
     */
    public boolean exist2(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, 0, word,board) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, int index, String word, char[][] board) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';

        boolean rst = helper(i + 1, j, index + 1, word, board)
                || helper(i, j + 1, index + 1, word, board)
                || helper(i, j - 1, index + 1, word, board)
                || helper(i - 1, j, index + 1, word, board);

        board[i][j] = tmp;
        return rst;
    }
}



