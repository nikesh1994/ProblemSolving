package Array;

//Find the maximum and minimum element in an array


public class MaxMinValue {

    public static String maxMin(int a[]) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for(int i = 0 ; i<a.length; i++) {
            if(a[i]<minimum) {
                minimum = a[i];
            }
            if(a[i]>maximum) {
                maximum = a[i];
            }
        }
        String value = "";
        value = value.concat(String.valueOf(minimum)).concat(",").concat(String.valueOf(maximum));
        return value;
    }

    public static void main(String []args) {
        int  a[] = {-1,4,6,37,8,-9,34};
        String value = maxMin(a);
        String []value1=value.split(",");
        System.out.println("Min Value : "+value1[0]+" Max Value : "+value1[1]);
    }
}
