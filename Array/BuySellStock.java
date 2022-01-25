package Array;

/*
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
public class BuySellStock {

    public static int buySellStock(int a[], int n) {
        int profit =0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++){
                if(a[j]-a[i] > profit) {
                    profit = a[j]-a[i];
                }
            }
        }
        return profit;
    }

    public static int buySellOptimize(int a[], int n) {
        int min = Integer.MAX_VALUE;
        int profit =0;
        for(int i=0;i<n;i++) {
            if(a[i]<min) {
                min = a[i];
            } else if(profit < (a[i]-min)) {
                profit = a[i]-min;
            }
        }
        return profit;
    }

    public static void main(String []args) {
        //int a[] = {2, 4, 1, 3, 5};
        int a[] = {7,1,5,3,6,4};
        System.out.println(buySellOptimize(a, a.length));
    }
}
