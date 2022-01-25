package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Given an array of intervals where intervals[i] = [starti, endi],
 merge all overlapping intervals, and return an array of the
  non-overlapping intervals that cover all the intervals in the input.

  Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    /*
    Algorithm :
    Step 1 :  Sort the intervals based on starting point of the intervals
    Step 2 :
     */
    public static int[][] merge(int[][] intervals) {

        int n = intervals.length;

        //Sort the arrays based on intial interval time
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        List<int []> list = new ArrayList<>();
        int s = intervals[0][0];
        int e = intervals[0][1];

        for(int i=1;i<n;i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(start<=e) {
                e = Math.max(end,e);
            } else { //if merge not possible, add prev value
                list.add(new int[]{s,e});
                s = start;
                e = end;
            }
        }
        list.add(new int[]{s,e});
        int arr[][] =new int[list.size()][2];
        for(int i=0;i< list.size();i++) {
            arr[i][0] = list.get(i)[0];
            arr[i][1] = list.get(i)[1];
        }
        return arr;

    }

    public static void main(String []args) {

        //int a[][] = {{1,3},{2,6},{8,10},{15,18}};
        int a[][] = {{1,3}};

        System.out.println(Arrays.deepToString(merge(a)));

    }
}
