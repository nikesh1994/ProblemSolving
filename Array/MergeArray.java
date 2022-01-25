package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
We are given two sorted arrays, our task is to merge two sorted arrays in a sorted manner.

Examples:

Input: vec1[] = { 1, 3, 4, 5}, vec2[] = {2, 4, 6, 8}
Output: vec3[] = {1, 2, 3, 4, 4, 5, 6, 8}
 */
public class MergeArray {

    /*
    Part 1 : Merge with extra spaces
    Algorithm : step 1 : create vec[m+n], where m=size(vec1) , n=size(vec2)
                step 2 : iterate i<m && j<n
                step 3 : check if (a[i]<b[j] . vec[k]=a[i] , i++,k++
                step 4 : else if (a[i]>b[j]) vac[k]=b[j] ,j++,k++
                step 5 " else vec[k] = a[i], i++,j++,k++
                step 6 : copy remaining elements left in array
     */
    public static void mergeWithSpace(int a[], int b[], int m, int n) {

        int k = 0, i=0, j=0;
        int []vec = new int[m+n];
        while(i<m && j<n) {
            if(a[i]<b[j]) {
                vec[k] = a[i];
                i++;
                k++;
            } else if(a[i]>b[j]) {
                vec[k] = b[j];
                j++;
                k++;
            } else {
                vec[k] = a[i];
                k++;
                vec[k] =b[j];
                i++;
                j++;
                k++;
            }
        }
        while(i<m){
            vec[k] = a[i];
            i++;
            k++;
        }
        while(j<n){
            vec[k] = b[j];
            j++;
            k++;
        }
        for(i=0;i<k;i++)
            System.out.print(vec[i]+" ");
    }

    /*
    Input:
          A[ ] = { 1, 2, 4, 6 }
          B[ ] ={ 3, 5, 7 }

          Output :
          A[ ]= { 1, 2, 3, 4 }
          B[ ]= { 5, 6, 7 }
     */
    public static void mergeWithoutSpace(int a[], int b[], int m, int n) {

        int i=0,j=0;
        while(i<m && j<n) {
            if(a[i]<b[j]) {
                i++;
            } else if(a[i]>b[j]) {
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i++;
            } else {
                i++;
                j++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void main(String []args) {
        int a[]={1, 2, 4, 6};
        int b[]={3, 5, 7};
        mergeWithoutSpace(a,b,a.length,b.length);
    }
}
