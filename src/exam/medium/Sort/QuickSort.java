package exam.medium.Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a=new int[]{8,5,4,3,7,5,9,9,4,4,4,5,6};

        quickSortInternal3(a,0,a.length-1);
    }

    /**
     * 快排的衍生版本，双路快排和三路快排
     * 75. Sort Colors
     * 给定0,1,2，任意个数位置的数组，在一次遍历的情况下，按顺序0,1,2，
     * 三路快排
     */
    public void sortColors(int[] A) {
        int l = 0, r = A.length-1;
        for (int i = 0; i <= r; i++) {
            if (A[i] == 0) {
                swap(A, i, l);
                l++;
            } else if (A[i] == 2) {
                swap(A, i, r);
                r--;
                i--;
            }
        }
    }
    public static void swap(int[] A, int i, int j){
        int tmp=A[i];
        A[i]=A[j];
        A[j]=tmp;
    }
    /**
     * 传统快排
     */
    public void traditionSort(int[] A) {


    }


    /**
     * 三路快排
     * @param arr
     * @param l
     * @param r
     */
    public static void quickSortInternal3(int[] arr,int l,int r) {
        if(l >= r) return;
        //随机取l-r之间的数
        int randIndex = (int)(Math.random() * (r - l + 1) + l);
        //主要还是以首元素作为基准值，只不过该基准值是每次随机取的，然后将随机所取的值与首元素交换
        //交换l与randIndex
        swap(arr,l,randIndex);
        //基准值为首元素
        int v = arr[l];
        //arr[l+1.....lt] < v
        //lt所处的位置就是arr[i]<v的最大边界
        int lt = l;
        //arr[gt....r] > v
        //gt所处的位置就是末尾元素
        int gt = r + 1;
        //i用来遍历数组，
        int i = l + 1;
        while(i<gt) {
            if(arr[i] < v) {
                //交换两者值,lt和i都自增1
                swap(arr,lt+1,i);
                lt++;
                i++;
            }else if(arr[i] > v) {
                //交换两者值,gt自减1
                swap(arr,gt-1,i);
                gt--;
            }else {
                //等于i自增
                i++;
            }
        }
        //交换l与lt元素,可以确定基准值的位置
        swap(arr,l,lt);
        //基准值前面继续进行上述操作
        quickSortInternal3(arr, l, lt-1);
        //基准值后面数组继续进行上述操作
        quickSortInternal3(arr, gt, r);
    }

}
