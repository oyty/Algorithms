package sort;

/**
 * Created by oyty on 2019/10/9
 */
public class Merge {

    // 归并所需要的辅助数组
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    /**
     * 将a[lo, mid]和a[mid+1, hi]归并
     * 左半边用尽，取右半边元素
     * 右半边用尽，取左半边元素
     * 右半边的当前元素小于左半边的当前元素，取右半边元素
     * 其余的取左半边元素
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for(int k=lo; k<=hi; k++) {
            aux[k] = a[k];
        }
        for(int k=lo; k<=hi; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            } else if(j > hi) {
                a[k] = aux[i++];
            } else if(less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
