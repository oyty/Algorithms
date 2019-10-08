package sort;

import common.StdIn;
import common.StdOut;

/**
 * Created by oyty on 2019/10/8
 * 选择排序
 * 首先，找到数组中最小的那个元素，其次，将它和数组的第 一个元素交换位置
 * (如果第一个元素就是最小元素那么它就和自己交换)。再次，在剩下的元素中
 * 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 * 这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
 */
public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i=0; i<N; i++) {
            int min = i;
            for(int j=i+1; j<N; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            if(i != min) {
                exch(a, i, min);
            }
        }
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
