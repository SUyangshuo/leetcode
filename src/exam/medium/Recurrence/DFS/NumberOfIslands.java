package exam.medium.Recurrence.DFS;

public class NumberOfIslands {
    /**
     * 200. Number of Islands
     * 描述：二维数组中，1表示陆地，0表示海洋，求有多少块大陆
     * 使用dfs
     */
    public int numIslands(char[][] grid) {
        int result=0;
        if(grid == null || grid.length==0){
            return 0;
        }
        boolean[][] used=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==(1+'0') && !used[i][j]){
                    result+=DFS(grid,used,i,j);
                }

            }
        }

        return result;
    }
    public static  int DFS(char[][] grid,boolean[][] used,int i,int j){

        used[i][j]=true;
        char one=1+'0';

        if(i-1>=0 && grid[i-1][j] == one && !used[i-1][j]){//上
            DFS(grid,used,i-1,j);
        }
        if(i+1<grid.length && grid[i+1][j]==one && !used[i+1][j]){
            DFS(grid,used,i+1,j);
        }
        if(j-1>=0 &&grid[i][j-1] == one && !used[i][j-1]){
            DFS(grid,used,i,j-1);
        }
        if(j+1<grid[0].length && grid[i][j+1] ==one && !used[i][j+1]){
            DFS(grid,used,i,j+1);
        }
        return 1;

    }
}
