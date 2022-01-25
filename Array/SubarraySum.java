package Array;

/*
Write an efficient program to find the sum of contiguous subarray
 within a one-dimensional array of numbers that has the largest sum.
 Eg : {-2, -3, 4, -1, -2, 1, 5, -3}
 Sum =7 {4,-1,-2,1,5}
 */
public class SubarraySum {

    /*
    Algorithm :
    Step1 : initialise min and max to 0
    Step2 : loop till n-1
    Step3 : if(min+a[i]<0) ,then min =0 ,else min = min+a[i]
    Step4 : max = min; return max
     */

    /* This is implementation of kadane's Agorithm
    The simple idea of Kadane’s algorithm is to look for all positive
     contiguous segments of the array (min is used for this).
      And keep track of maximum sum contiguous segment among all positive
       segments (max is used for this). Each time we get a positive-sum
        compare it with max and update max if it is less than min
     */
    public static int largestSum(int a[], int n) {

        int min = 0;
        int max = 0;

        for(int i=0;i<n;i++) {
            if(min+a[i] <0) {
                min =0 ;
            } else {
                min = min +a[i];
            }
            if(max<min) {
                max =min;
            }
        }
        return max;
    }

    public static void main(String []args) {

        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println(largestSum(a,a.length));

    }
}
