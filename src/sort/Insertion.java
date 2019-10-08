package sort;

import common.StdIn;
import common.StdOut;

/**
 * Created by oyty on 2019/10/8
 * 插入排序
 * 通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
 * 在计算机的实现中，为了给要插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移
 * 动一位。这种算法叫做插入排序
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        int N = a.length;
        // 最小的到最前面，相邻的交换位置，一直将最小的移位到最前面
        for(int i=1; i<N; i++) {
            for(int j=i; j>0; j--) {
                if(less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }

        /*Comparable[] b = new Comparable[a.length + 1];
        for(int i=0; i<b.length; i++) {
            b[i] = Integer.MAX_VALUE;
        }
        int N = a.length;
        b[0] = a[0];
        for(int i=1; i<N; i++) {
            // 插入位置
            int insertIndex = -1;

            // 从小到大
            // 外层循环每一次插入一条数据
            for(int j=0; j<b.length; j++) {
                //因为是从小到大，所以只要是小于就移位
                if(less(a[i], b[j])) {
                    insertIndex = j;
                    break;
                }
            }
            // 从j 开始 所有值后移一位
            for(int m=b.length-1; m>insertIndex; m--) {
                b[m] = b[m-1];
            }
            b[insertIndex] = a[i];
        }
        for(int i=0; i<N; i++) {
            a[i] = b[i];
        }*/
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for(int i=1; i<a.length; i++) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        Integer[] b = new Integer[a.length];
        for(int i=0; i<a.length; i++) {
            b[i] = Integer.valueOf(a[i]);
        }
        sort(b);
        assert isSorted(b);
        show(b);
    }



}
