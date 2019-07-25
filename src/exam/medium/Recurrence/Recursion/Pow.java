package exam.medium.Recurrence.Recursion;

class Pow_solut {
    /**
     * 50. Pow(x, n)
     * 求x的n次幂
     * 注意：1）：首先使用二分递归的思想pow(x,n/2)*pow(x,n/2)，降低时间复杂度
     * 对于n为负数的时候取n的绝对值，然后x=1/x，对于n为奇数 时候，需要多乘一个x;
     *       2）：对于题目中给了数值范围的要特别注意， 当n为最小值的时候，直接取绝对值会产生越界，有两种处理方式，
     *          第一种直接判断n是否为最小值
     *          第二种是提前保留下n/2
     */
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        int temp=n/2;
        if(n<0){
            x=1/x;
            temp = -temp;

        }
        //return (n  % 2 == 0) ? myPow(x,temp)* myPow(x,temp):myPow(x,temp)* myPow(x,temp)*x;
        //todo:注意上写下两段有什么区别？  使用了中间值，如果是mypow*mypow 相当于同样的值计算了两次，会超时，需要有一个中间变量保存
        return (n  % 2 == 0) ? myPow(x*x,temp):myPow(x*x,temp)*x;

    }
    public double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int t = n / 2;
        if (n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if (n % 2 == 0) return res * res;
        return res * res * x;


    }
}
public class Pow{
    public static void main(String[] args) {
        Pow_solut pow=new Pow_solut();
        System.out.println(pow.myPow(0.00001 ,2147483647));
    }
}
