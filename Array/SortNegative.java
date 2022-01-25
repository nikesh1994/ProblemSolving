package Array;

public class SortNegative {

    /* Move all negative numbers to beginning and positive to end with constant extra space
    Algo : Use the Dutch National Flag algo

    Time Complexity - O(n)
    Space Complexuty - O(1)

    -1,2,-3,4,5,-5,6
    1)-1,6,-3,4,5,-5,2
    -1,-5,-3,4,5,6,2
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
        int a[] = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        sortNegative(a,a.length);
    }
}
