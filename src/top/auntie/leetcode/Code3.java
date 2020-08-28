package top.auntie.leetcode;

import java.util.*;

public class Code3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        if (chars.length<2) {
            return chars.length;
        }
        int start=0;
        int end=1;
        int max=0;
        char[] sub = null;
        for (;end<chars.length; end++) {
            sub = Arrays.copyOfRange(chars, start, end);
            int dup = searchDup(sub, chars[end]);
            if (dup>=0) {
                if (sub.length>max) {
                    max = sub.length;
                }
                start += dup+1;
            }
        }
        return Math.max(max, end - start);
    }

    private int searchDup(char[] chars, char target) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==target) {
                return i;
            }
        }
        return -1;
    }

    public int lengthOfLongestSubstring2(String s) {
        // fixme 无法处理中文
        // 记录字符上一次出现的位置 ASCII码
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().lengthOfLongestSubstring("au"));
    }

}
