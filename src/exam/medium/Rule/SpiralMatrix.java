package exam.medium.Rule;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
       Solution solution=new Solution();
       int[][] a=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
       solution.spiralOrder(a);
    }
}
class Solution{
    /**
     *     54. Spiral Matrix
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length== 0||matrix[0].length==0){
            return result;
        }
        //螺旋旋转，需要四个变量记录从左到右，从上到下，从右到左，从下到上
        int allLine = matrix.length;
        int allRow = matrix[0].length;

        int line = 0;  //从左到右
        int row = allRow-1; //从上到下
        int top = 0;        //从下到上
        int bottom = allLine-1; //从右到左

        int allSize=allLine * allRow;
        while(result.size()<allSize){
            for(int i=line;i<=row; i++){
                result.add(matrix[line][i]);
            }
            if (result.size()>=allSize) break;
            line++;
            if(bottom>0){
                for(int i=line;i<=bottom;i++){
                    result.add(matrix[i][row]);
                }
                if (result.size()>=allSize) break;

                row--;

                for(int i=row;i>=top;i--){
                    result.add(matrix[bottom][i]);
                }
                if (result.size()>=allSize) break;

                bottom--;
                for(int i =bottom;i>=line;i--){
                    result.add(matrix[i][top]);
                }


                top++;

            }
        }
        return result;
    }
}
