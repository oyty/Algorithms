package sort;

import common.StdIn;
import common.StdOut;

/**
 * Created by oyty on 2019/10/8
 * 希尔排序
 */
public class Shell {

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) {
            h = 3*h + 1;
        }

        while(h >= 1) {
            for(int i=h; i<N; i++) {
                for(int j=i; j>=h; j-=h) {
                    if(less(a[j], a[j-h])) {
                        exch(a, j, j-h);
                    }
                }
            }
            h = h/3;
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
