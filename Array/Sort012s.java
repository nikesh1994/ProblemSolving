package Array;

/*Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algo*/

public class Sort012s {

    /* One solution would be count the no of 0s,1s and 2s and fill the array with 0
    with index 0 to count on 0s and so on . TC : 0(n), but it will require two passes
    one to find the count and another to fill the array. Another solution would be
    Dutch National Flag Algo
     */

    /* [0....low-1] will contains 0s
    [high+1...n-1] contains 2s
    [low..mid-1] contains 1s

    step1 : low=0,mid=0,high=n-1
    step2 : if a[mid]=0, swap a[mid],a[low], mid++,low++
    step3 : if a[mid]=1, mid++
    step4 : if a[mid] =2, swap a[mid] , a[hig] , high--
     */

    public void sort(int a[], int n) {

        int low =0;
        int mid=0;
        int high=n-1;
        int temp;

        while(mid<=high) {
            switch(a[mid]) {
                case 0 : {
                    temp = a[mid];
                    a[mid] = a[low];
                    a[low] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1 : {
                    mid++;
                    break;
                }
                case 2 : {
                    temp = a[mid];
                    a[mid] = a[high];
                    a[high] =temp;
                    high--;
                }
            }
        }
        for(int i =0 ;i<n;i++){
            System.out.print(a[i]+" ");
        }
    }

    public static void main(String []args) {
        Sort012s sort1 = new Sort012s();
        int a[] = {1,2,1,2,1,2,0,0,0,1,2,0};
        sort1.sort(a,a.length);
    }
}
