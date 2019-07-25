package exam.medium.Rule;

public class RotateImage {
    /** 48. Rotate Image
     * 不占用额外空间，顺时针旋转二维数组
     * 没有技巧，只要交换位置，先对角线交换，然后按照纵轴翻转
     */

    public void rotate(int[][] matrix) {
        //对角线交换，
        for(int i=0;i<matrix.length;i++){
            for(int j =i+1;j<matrix[0].length;j++){



                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //纵轴交换
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){

                int temp=matrix[i][j];
                matrix[i][j]= matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j]=temp;
            }
        }



    }
}
