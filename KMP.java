import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;

public class KMP {

    public static void main(String[] args) {
        int[] nextArr = getNextArr("abcabdaba");
    }

    /**
     * next数组求导
     * 1、next数组默认0位是0，1位是1
     * 2、索引都是从1开始，因为串的特性是0位存储长度
     * 3、遍历索引：i默认从3开始，活动索引：j
     * 4、字符串数组第i-1位和j相同时，next[i]
     *
     * @param match
     * @return
     */
    private static int[] getNextArr(String match) {
        int[] next = new int[match.length()];
        next[0] = 0;
        next[1] = 1;
        int i = 2, j = i - 1;
        byte[] matchArr = match.getBytes();
        while (i < match.length()) {
            if (j == 0 || matchArr[i] == matchArr[j]) {
                next[i] = j + 1;
                i++;
                j = i - 1;
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }

    /**
     * 索引     0 1 2 3 4 5 6 7 8 9
     * 字符     a b c a b d a b a
     * next[]  0 1 1 1 2 3 1 2 3
     */
}
