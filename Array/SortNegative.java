package Array;

public class SortNegative {

    /* Move all negative numbers to beginning and positive to end with constant extra space
    Algo : Use the Dutch National Flag algo

    Time Complexity - O(n)
    Space Complexuty - O(1)
     */

    public static void sortNegative(int a[], int n) {
        int low = 0;
        int high = n-1;
        int temp;
        while(low<=high) {
            if(a[low] <0) {
                low++;
            } else {
                temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                high--;
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String []args) {
        int a[] = {-1,3,4,5,6,-2,-5,-9,-11,66,77,-66};
        sortNegative(a,a.length);
    }
}
