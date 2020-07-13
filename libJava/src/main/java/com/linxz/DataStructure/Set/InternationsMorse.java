package com.linxz.DataStructure.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Linxz
 * 创建日期：2020年07月13日 08:31
 * version：v4.5.4
 * 描述：
 */
public class InternationsMorse {

    //国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
    //
    //为了方便，所有26个英文字母对应摩尔斯密码表如下：
    //
    //[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    //给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
    //
    //返回我们可以获得所有词不同单词翻译的数量。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/unique-morse-code-words
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //例如:
    //输入: words = ["gin", "zen", "gig", "msg"]
    //输出: 2
    //解释:
    //各单词翻译如下:
    //"gin" -> "--...-."
    //"zen" -> "--...-."
    //"gig" -> "--...--."
    //"msg" -> "--...--."
    //
    //共有 2 种不同翻译, "--...-." 和 "--...--.".
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/unique-morse-code-words
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

   static String[] pwdArray=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
   static char[] letterArray=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};


    public static int uniqueMorseRepresentations(String[] words) {
        BSTSet<String> hashSet=new BSTSet<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char letter : letters) {
                sb.append(translate(letter));
            }
            hashSet.add(sb.toString());
            System.out.println(sb.toString());
        }
        return hashSet.getSize();
    }

    public static void main(String[] args) {
        String[] words =new String[]{"gin", "zen", "gig", "msg"};
        int size=uniqueMorseRepresentations(words);
        System.out.println(size);
//        for (String word : words) {
//            char[] letters = word.toCharArray();
//            StringBuilder sb = new StringBuilder();
//            for (char letter : letters) {
//                sb.append(translate(letter));
//            }
//            System.out.println(sb.toString());
//        }
    }

    private static String translate(char letter){
        for (int i=0;i<letterArray.length;i++){
            if (letter==letterArray[i]){
                return pwdArray[i];
            }
        }
        return "";
    }


    //注：char相加减，直接是ASCII相加减，所以不需要另外再加一个['a','b','c'...]对照表
    public int uniqueMorseRepresentations2(String[] words) {
        String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet();
        for (String word: words) {
            StringBuilder code = new StringBuilder();
            for (char c: word.toCharArray())
                code.append(MORSE[c - 'a']);
            seen.add(code.toString());
        }

        return seen.size();
    }


}
