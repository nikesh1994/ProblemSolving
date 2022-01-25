package Array;

import java.util.HashMap;
import java.util.Map;

/*
Input  :  arr[] = {1, 5, 7, -1},
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5},
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
                     (1, 5)
 */
public class CountPairsEqualsSum {

    /*
    Algorithm :
    Step 1 : Use a Map (key->a[i], value->frequency of the no)
    Step 2 : check if the map contains sum - a[i] , count + = map.get(a[i])
    Step 3 : else if map contains a[i] , update map value with 1 , adding frequency
    Step 4 : else add a[i],1 to map
     */
    public static int countPair(int a[],int n, int sum) {

        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            if(map.containsKey(sum-a[i])) {
                count += map.get(sum-a[i]);
            }
            if(map.containsKey(a[i])) {
                map.put(a[i],map.get(a[i])+1);
            } else {
                map.put(a[i],1);
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 5, 7, -1, 5};
        int n = arr.length;
        int sum = 6;
        System.out.print("Count of pairs is "
                + countPair(arr, n, sum));
    }
}
