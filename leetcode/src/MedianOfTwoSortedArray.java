import java.util.Arrays;

/**
 * Created by Ting on 2/4/2017.
 */
public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 3, }, b = {2,4,5,6,7};
        int k = 6;
        System.out.println(findKth(a, b, k));
//        System.out.println(k);


    }

    public static int findKth(int[] a, int[] b, int k) {
        int lenA = a.length;
        int lenB = b.length;
        if (lenA>lenB){
            return findKth(b, a, k);
        }
        // lenB >= lenA
        if (lenA+lenB<k){
            System.out.println("shorter than k");
            return -1;
        }
        if (lenA == 0){
            return b[k-1];
        }
        if (k == 1){
            return Math.min(a[0], b[0]);
        }
        int pa = Math.min(k/2, lenA), pb = k-pa;
        if (a[pa-1] < b[pb-1]) {
            a = Arrays.copyOfRange(a,pa,lenA);
            b = Arrays.copyOfRange(b,0,pb);
            return findKth(a, b, k-pa);
        }
        else if (a[pa-1] == b[pb-1]) {
            return a[pa-1];
        }
        else{
            a = Arrays.copyOfRange(a, 0, pa);
            b = Arrays.copyOfRange(b, pb, lenB);
            return  findKth(a, b, k-pb);
        }


    }



}
