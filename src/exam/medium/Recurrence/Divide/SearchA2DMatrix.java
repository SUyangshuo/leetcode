package exam.medium.Recurrence.Divide;

public class SearchA2DMatrix {
    /**
     * 240. Search a 2D Matrix II
     *给定一个数组，按照从左到右递增，从上到下递增求k值是否存在数组中
     *
     * 方法一：使用分治法，右上角的点在某种程度上说是中心点
     *          每次判断右上角的点和k值的大小关系，可以对应的是行前进还是列前进
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0][0]>target){
            return false;
        }
        int l=0;
        int r=matrix[0].length-1;
        //行加列减  可以起到缩小范围的功能
        while(l<matrix.length-1 && r>=0  ){
            if(matrix[l][r]==target){
                return true;
            }
            if(matrix[l][r]>target){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}
