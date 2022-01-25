package Array;

/*
Given an array, cyclically rotate the array clockwise by one.

        Examples:

        Input:  arr[] = {1, 2, 3, 4, 5}
        Output: arr[] = {5, 1, 2, 3, 4}

 */
public class CyclicallyRotate {

    /*
    Algorithm:
    Step1 : set i=0, loop j=1...n-1
    Step2 : swap a[i],a[j] , increment j
    Step3 : wheen loop exists, print
     */
    public static void rotate(int a[], int n) {

        int i=0;
        for(int j=1;j<n;j++) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

        }

        for(i=0;i<n;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String []args) {

        int a[] = {1,2,3,4,5};
        rotate(a,a.length);
    }
}
