package Array;/*
Given an array, the task is to reverse the given array in Java.
        Input : 1, 2, 3, 4, 5
        Output :5, 4, 3, 2, 1

        Input :  10, 20, 30, 40
        Output : 40, 30, 20, 10

*/
import java.util.*;

public class ReverseArray {

    public static void swapApproach(int a[]) {
        int n = a.length;
        int t;
        for(int i=0 ; i<n/2 ; i++) {
            t = a[i];
            a[i] = a[n-i-1];
            a[n-i-1] = t;
        }
        //Reversed Array
        for(int k=0;k<n;k++){
            System.out.print(a[k]+" ");
        }
    }

    public static void main(String []args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        //Collections.reverse(Arrays.asList(a));
        swapApproach(a);
    }
}
