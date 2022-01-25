package Array;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of n elements that contains elements from 0 to n-1,
 with any of these numbers appearing any number of times. Find these
  repeating numbers in O(n) and using only constant memory space.
  Input : n = 7 and array[] = {1, 2, 3, 6, 3, 3, 6}
Output: 1, 3, 6
 */
public class Duplicates {

    /*
    Algorithm:
    Step 1: iterate through 0..n-1
    Step 2: store in a HashMap with key as index , value as TwoTuple(boolean,count)
    Step 3: if the elements does exist , put is map with value as (true,count)
    step 4: check the count if it is 1 , print it
     */
    static class TwoTuple<A,B> {
        private A objectA;
        private B objectB;

        TwoTuple(A objectA,B objectB) {
            super();
            this.objectA = objectA;
            this.objectB = objectB;
        }

        public A getObjectA(){
            return objectA;
        }
        public B getObjectB(){
            return objectB;
        }

        public void setObjectA(A objectA) {
            this.objectA = objectA;
        }

        public void setObjectB(B objectB) {
            this.objectB = objectB;
        }
    }

    public static void findDuplicates(int a[],int n) {

        Map<Integer,TwoTuple<Boolean,Integer>> map = new HashMap<>();
        int count =0;

        for(int i=0;i<n;i++) {
            if(!map.containsKey(a[i])) {
                if(a[i]==0) {
                map.put(Integer.MAX_VALUE,new TwoTuple<>(true,Integer.MAX_VALUE));
                count++;
                } else {
                    map.put(a[i],new TwoTuple<>(true,a[i]));
                }
            } else {
                if(a[i] == map.get(a[i]).getObjectB() && a[i]!=Integer.MAX_VALUE) {
                    System.out.print(a[i]+ " ");
                    map.get(a[i]).setObjectB(Integer.MIN_VALUE);

                }
            }
        }
        if(count >1) {
            System.out.println(0);
        }

    }

    public static void main(String []args) {
        int a[] = {1, 2, 3, 6, 3, 3, 6,0,2,3,0,6,0};
        findDuplicates(a, a.length);
    }
}
