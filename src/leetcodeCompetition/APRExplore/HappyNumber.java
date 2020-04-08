package leetcodeCompetition.APRExplore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HappyNumber {
    /**
     * 判断一个数是否是是happy数，从任意正整数开始，将数字替换为其位数的平方和，并重复此过程，直到数字等于1(将保持不变)
     Input: 19
     Output: true
     Explanation:
     12 + 92 = 82
     82 + 22 = 68
     62 + 82 = 100
     12 + 02 + 02 = 1
     */
    public static boolean isHappy(int n) {
        List<String> list=new ArrayList<>();
        return solution(n,list);
    }
    public static boolean solution(int n, List<String> list) {
        if(n==1){
            return true;
        }
        String newInt=String.valueOf(n);
        if(list.contains(newInt)){
            return false;
        }else {
            list.add(newInt);
        }
        char[] chararray=newInt.toCharArray();
        int count=0;
        for(int i=0;i<chararray.length;i++){
            int temp=chararray[i]-'0';
            count+=Math.pow(temp,2);
        }
        return solution(count,list);
    }


    //方法二：
    public boolean isHappy2(int n) {
        int slow = sumOfSquares(n);
        int fast = sumOfSquares(sumOfSquares(n));

        while(slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }

        return slow == 1;
    }

    public int sumOfSquares(int num) {
        int sum = 0;

        while(num > 0) {
            int remainder = num % 10;

            sum += (remainder * remainder);

            num /= 10;
        }

        return sum;
    }
}