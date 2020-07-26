package com.linxz.DataStructure.Hash;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author Linxz
 * 创建日期：2020年07月25日 14:23
 * version：v4.5.4
 * 描述：
 */
public class LeetCodeMain {

    //给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    //
    // 
    //
    //示例：
    //
    //s = "leetcode"
    //返回 0
    //
    //s = "loveleetcode"
    //返回 2
    //
    //提示：你可以假定该字符串只包含小写字母。


    public static void main(String[] args) {
        LeetCodeMain leetCodeMain=new LeetCodeMain();
        String s="loveleetcode";
        int index=leetCodeMain.firstUniqChar2(s);
        System.out.println(index);
    }

    //提交记录的时候：TreeMap运行时间：110 ms
    //              HashMap运行时间：42 ms
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        char[] chars=s.toCharArray();
        for (char character:chars){
            if (!hashMap.containsKey(character)){
                hashMap.put(character,1);
            }else{
                hashMap.put(character,hashMap.get(character)+1);
            }
        }
        for (int i=0;i<chars.length;i++){
            if (hashMap.get(chars[i])==1){
                return i;
            }
        }
        return -1;
    }



    //提示：你可以假定该字符串只包含小写字母。
    //使用一个freq[26]数组去存储字符存在的数量
    //                运行时间：10 ms
    public int firstUniqChar2(String s) {
        int[] freq=new int[26];//类似一个哈希表，每一个字符都和一个索引对应

        //a-a   0
        //b-a   1
        //...             ->  index=ch - 'a' (哈希函数)
        //z-a  25

        ///索引查询是O(1)的查询操作

        for (int i=0;i<s.length();i++)
            freq[s.charAt(i)-'a']++;
        for (int i=0;i<s.length();i++)
            if (freq[s.charAt(i)-'a']==1)
                return i;
        return -1;
    }



}
