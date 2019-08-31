package exam.NiuKe.阿里;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 编辑距离 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//阈值
        int min = in.nextInt();
        int max = in.nextInt();
        String a = in.nextLine();
        String b = in.nextLine();

        String[] aString = a.split(",");
        String[] bString = b.split(",");
//        int[][] dp = minDistance(aString,bString);
        int zz=0;
        int tt=0;
        int count=0;
        for (int i=min;i<max+1;i++) {
            if(aString.length>i){
                for(int j=i;j<aString.length;j++){
                    if(bString.length>i){
                        for(int x=i;x<bString.length;x++){
                            int temp=minDistance(Arrays.copyOfRange(aString,zz,j),Arrays.copyOfRange(bString,tt,x));
                            if(temp<=n){
                                count++;
                            }
                            zz++;

                        }
                        tt++;
                    }

                }

            }

        }
        System.out.println(count);


    }

    public static int minDistance(String[] word1, String[] word2) {
        int len1 = word1.length;
        int len2 = word2.length;

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            dp[i][0] = i;

        for (int j = 0; j <= len2; j++)
            dp[0][j] = j;


        //iterate though, and check last char
        for (int i = 1; i <= len1; i++) {
            String c1 = word1[i - 1];
            for (int j = 1; j <= len2; j++) {
                String c2 = word2[j - 1];
                //if last two chars equal
                if (c1.equals(c2)) {
                    //update dp value for +1 length
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1] + 1;
                    int insert = dp[i - 1][j] + 1;
                    int delete = dp[i][j - 1] + 1;

                    int min = Math.min(replace, insert);
                    min = Math.min(min, delete);
                    dp[i][j] = min;
                }
            }
        }

        return dp[len1 + 1][len2 + 1];
    }
}
