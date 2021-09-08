package com.linxz.letcode.Sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Linxz
 * 创建日期：2021年07月20日 5:14 PM
 * version：
 * 描述：
 */
public class S_3_无重复字符的最长子串 {

    public static void main(String[] args) {
        String s=" ";
        S_3_无重复字符的最长子串 solution=new S_3_无重复字符的最长子串();
        int maxLength=solution.lengthOfLongestSubstring2(s);
        System.out.println(maxLength);
    }

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)){
            return 0;
        }
       char[] chars=s.toCharArray();
        List<StringBuilder> list = new ArrayList<>();
        for (int i=0;i<chars.length;i++){
            StringBuilder sb= new StringBuilder();
            HashMap<String,Character> checkMap=new HashMap<>();
            for (int j=i;j<chars.length;j++) {
                if (checkMap.get("" + chars[j]) != null) {
                    list.add(sb);
                    break;
                } else {
                    sb.append(chars[j]);
                    checkMap.put(""+chars[j],chars[j]);
                    if (j==chars.length-1){
                        list.add(sb);
                    }
                }
            }
        }

        int maxLength = 0;
        for (StringBuilder sb2:list){
            if (sb2.toString().length()>maxLength){
                maxLength=sb2.toString().length();
            }
        }
        return maxLength;

        ////执行结果：
        //    //通过
        //    //显示详情
        //    //添加备注
        //    //
        //    //执行用时：
        //    //226 ms
        //    //, 在所有 Java 提交中击败了
        //    //5.90%
        //    //的用户
        //    //内存消耗：
        //    //45 MB
        //    //, 在所有 Java 提交中击败了
        //    //5.10%
        //    //的用户
    }


    public int lengthOfLongestSubstring2(String s) {
        if ("".equals(s)){
            return 0;
        }
        int maxLength = 0;
        char[] chars=s.toCharArray();
        for (int i=0;i<chars.length;i++){
            HashMap<String,Character> checkMap=new HashMap<>();
            int currentSLength = 0;
            for (int j=i;j<chars.length;j++) {
                if (checkMap.get("" + chars[j]) != null) {
                    break;
                } else {
                    checkMap.put(""+chars[j],chars[j]);
                    currentSLength++;
                    if (currentSLength>maxLength){
                        maxLength = currentSLength;
                    }
                }
            }
        }
        return maxLength;

        //执行结果：
        //通过
        //显示详情
        //添加备注
        //
        //执行用时：
        //202 ms
        //, 在所有 Java 提交中击败了
        //6.24%
        //的用户
        //内存消耗：
        //39.1 MB
        //, 在所有 Java 提交中击败了
        //9.94%
        //的用户
    }





} 