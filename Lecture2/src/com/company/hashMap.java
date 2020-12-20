package com.company;

import java.util.*;

public class hashMap {

    public static void main(String[] args) {
//
//        TreeMap<Integer,Integer> map = new TreeMap<>();   // AVL trees
//        map.put(1000,7);
//        map.put(445616415,28);
//        map.put(2000,14);
//        map.put(3354684,21);
//
//        for(int i : map.keySet()){
//            System.out.println("Key: "+i +" value: "+map.get(i));
//        }

        System.out.println(minimumDiffernce(new ArrayList<>(Arrays.asList(3,2,3,2,4,5,6,8)),5));
//        System.out.println(map.containsKey(1000));
    }



    public static int minimumDiffernce(ArrayList<Integer> A,int B){

        HashMap<Integer,Integer> map = new HashMap<>(); // val of A, Frequency
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // 3,2,3,2,4,5,6,7 ==> {3->2,2->2,4->1,5->1,6->1,7->1}
        for(int val : A){
            min = Math.min(val,min);
            max = Math.max(val,max);

            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else{
                map.put(val,1);
            }
        }
        System.out.println(map);

        while(B > 0){
            int minValCount = map.get(min);
            int maxValCount = map.get(max);


            if(minValCount > maxValCount){
                if(B < maxValCount) return max - min;
                B -= maxValCount;
                map.remove(max);
                max--;
                if(map.containsKey(max)){
                    map.put(max,map.get(max)+maxValCount);
                }else{
                    map.put(max,maxValCount);
                }
            }else{
                if(B < minValCount) return max - min;
                B -= minValCount;
                map.remove(min);
                min++;
                if(map.containsKey(min)){
                    map.put(min,map.get(min)+maxValCount);
                }else{
                    map.put(min,maxValCount);
                }
            }
            System.out.println(map +" max value: "+max+" min value: "+min);
        }
        return -1;
    }
}
