package exam.medium.Recurrence.dp.KnapsackProblem;

public class UniqueBinarySearchTrees {
    /**
     * 96. Unique Binary Search Trees
     * 求1-n个数字能组成的BST
     *
     * 首先需要明确的是BST的中序遍历是一个单调不减的数列
     *
     * 可以用dp 也可以用循环遍历
     * @param n
     * @return
     */

    //方法一dp：G(n)是n个数字的BST个数
    //F(n,i)是n个数字且以第i个数字为根的BST个数。
    // 递推公式：F(i,n)=G(i−1)⋅G(n−i)
    //那么从前往后可以求出G(n): G(n) = sum(G(i-1)*G(n-i))
    public int numTrees(int n) {
        if(n==0||n==1)
            return 1;
        int[] F = new int[n+1];//注意长度
        F[0]=1;
        F[1]=1;//注意初始化
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                F[i] += F[j-1]*F[i-j];
            }
        }
        return F[n];
    }
    //递归，BST中一个节点的唯一BST等于左节点的个数*右节点个数
    public  int numTrees2(int n) {
        if(n<=1)    return 1;
        int sum=0;
        for(int i=1;i<=n;++i)
            sum+=numTrees2(i-1)*numTrees2(n-i);

        return sum;
    }


}
