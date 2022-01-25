package Array;

import java.util.ArrayList;
import java.util.List;

/*
find common elements In 3 sorted arrays
 */
public class Common3Arrays {

    /* find common elements between two array, store in a tempArray/ArrayList
    , then find the common elements between list and third aary
     */

    public static void commonElements(int a[], int b[], int c[]) {

        int m = a.length;
        int n= b.length;
        int o = c.length;

        List<Integer> list = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i <m && j<n) {
            if(a[i]<b[j])
                i++;
            else if(a[i]>b[j])
                j++;
            else {
                list.add(a[i]);
                i++;
                j++;
            }
        }
        int z=0;
        //int d = list.size();
        while(z< list.size() && k<o) {
            if(list.get(z)<c[k])
                z++;
            else if(list.get(z)>c[k])
                k++;
            else {
                System.out.print(c[k]+" ");
                z++;
                k++;
            }
        }
    }

    public static void main(String args[])
    {


        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};

        System.out.print("Common elements are ");
        commonElements(ar1, ar2, ar3);
    }
}
