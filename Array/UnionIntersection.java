package Array;

/*
Find the Union and Intersection of the two sorted arrays.
 */
public class UnionIntersection {

    /*
    Step1 : Scan both array
    Step2 : Print smaller element and increment respective counter
    Step3 : Print remaining elements

    Only one drawback : we dont check for duplicate elements in the array
     */

    static void printUnion(int a[],int b[],int m,int n) {
        int i=0;
        int j=0;

        while(i<m && j<n) {
            if(a[i]<b[j]) {
                System.out.print(a[i]+" ");
                i++;
            } else if(b[j]<a[i]) {
                System.out.print(b[j]+" ");
                j++;
            } else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }

        //print remaining elements
        while(i<m){
            System.out.print(a[i]+" ");
            i++;
        }
        while(j<n){
            System.out.print(b[j]+" ");
            j++;
        }
        System.out.println();
    }

    static void printIntersection(int a[],int b[],int m,int n) {
        int i=0;
        int j=0;

        while(i<m && j<n) {
            if(a[i]<b[j]) {
                //System.out.print(a[i]+" ");
                i++;
            } else if(b[j]<a[i]) {
                //System.out.print(b[j]+" ");
                j++;
            } else{
                System.out.print(a[i]+" ");
                i++;
                j++;
            }
        }
        System.out.println();
    }

    public static void main(String []args) {
        int a[]={1,2,3,4,5,6,7};
        int b[]={5,6,7,8,9};
        printUnion(a,b,a.length,b.length);
        printIntersection(a,b,a.length,b.length);
    }
}
