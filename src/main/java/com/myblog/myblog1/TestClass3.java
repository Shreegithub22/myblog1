package com.myblog.myblog1;

import java.util.HashMap;
import java.util.Map;

public class TestClass3 {
    public static void main(String[] args) {
        String s="abcabcbb";
        int count=0;
        int result=0;
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(mp.containsKey(s.charAt(i))) {
                result= Math.min(count, result);
                mp.clear();
            }
            else {
                mp.put(s.charAt(i), 1);
                count++;
            }
        }
        System.out.println(count);


    }
}
