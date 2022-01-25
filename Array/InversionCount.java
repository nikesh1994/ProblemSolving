package Array;

/*
For an array, inversion count indicates how far (or close) the array
is from being sorted. If array is already sorted then the inversion count is 0.
 If an array is sorted in the reverse order then the inversion count is the maximum.
Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Input: N = 5, arr[] = {2, 4, 1, 3, 5}
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5
has three inversions (2, 1), (4, 1), (4, 3).
 */
public class InversionCount {

    /*
    Algorithm :
    Step 1 : Traverse through the array from start to end
             For every element, find the count of elements
              smaller than the current number up to that index using another loop.
             Sum up the count of inversion for every index.
             Print the count of inversions.
     */
    public static int inversionCount(int a[], int n) {

        int inv_count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] > a[j])
                    inv_count++;

        return inv_count;
    }

    /*Merge sort Approach
    Algorithm :
    Step 1 : pass low =0 , high=n-1 , to split the array and merge
             Split the array , with base condition low < high ,set mid = low+high /2
    Step 2 : count + = mergesort(a,low,mid) , count + = mergeSort(a,mid+1,high)
    Step 3 : count + = merge(a,low,mid,high)
    Step 4 : while sorting and merging to temp array , if(a[i]>a[j] , count + = mid-i
     */

    public static int merge(int a[],int low,int mid,int high,int temp[]) {
        int count = 0;
        int i =low;
        int j= mid+1;
        int k =low;
        while(i<=mid && j<=high) {
            if(a[i]<=a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                count += mid-i+1;
            }
        }
        //copy remaining array
        while(i<=mid){
            temp[k++] = a[i++];
        }
        while(j<=high){
            temp[k++] = a[j++];
        }
        for(i=low;i<=high;i++) {
            a[i] = temp[i];
        }
        return count;
    }

    public static int mergeSort(int a[], int low , int high , int temp[]) {
        int count = 0, mid;
        if(low<high) {
            mid = (low+high)/2;
            count += mergeSort(a,low,mid,temp);
            count += mergeSort(a,mid+1,high,temp);

            count += merge(a,low,mid,high,temp);
        }
        return count;
    }



    public static void main(String []args) {
        //int a[] = {2, 4, 1, 3, 5};
        int a[] = {8,4,2,1};
        System.out.println(mergeSort(a,0,a.length-1,new int[4]));
    }
}
