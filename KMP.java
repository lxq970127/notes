public class KMP {

    public static void main(String[] args) {
        String str = "abcah1cao1ox1wq1abzabz1";
        String match = "abzab";
        int[] nextArr = getNextArr(match.toCharArray());
        int indexOf = matchByKMP(str.toCharArray(), match.toCharArray(), nextArr);
        System.out.println("match在str的所在位置为："+indexOf);
    }

    /**
     * 例：
     * 字符      a b c a b d a b a
     * 索引      1 2 3 4 5 6 7 8 9
     * next[]   0 1 1 1 2 3 1 2 3
     * next值求导：设求字符串数组match第i位的next值
     * 判断：match[i-1]==match[next[i-1]]
     * 若判定成功则第i位的next值为：next[i-1]+1
     * 若判定失败则继续判断:match[i-1]==match[next[next[i-1]]],直到next[i-1]=0
     * <p>
     * next数组求导
     * 1、初始化next数组，索引为0时为0，索引为1为1
     * 2、i为match字符串数组索引(0<i<=match.length)，j为i上一位的索引对应next数组中的数，则有j=next[j-1]
     * 3、当j为0时，不再有对应的next数，则当前对应的next[i]=1
     * 4、当字符串数组第i-1位与字符串数组j-1位相同时，判断字符串数组i和j的下一位
     * 5、j不为0且字符串数组i位和j位不匹配时，找j的上一个next数重新匹配，直到j为0
     *
     * @param match 字符串数组
     * @return match字符串数组对应的next数组
     */
    private static int[] getNextArr(char[] match) {
        if (match.length == 0) {
            throw new RuntimeException("匹配的数组至少含有一个字符");
        }
        int[] next = new int[match.length];
        next[0] = 0;
        int i = 1, j = 0;
        while (i < match.length) {
            if (j == 0 || match[i - 1] == match[j - 1]) {
                next[i] = j + 1;
                i++;
                j++;
            } else {
                j = next[j - 1];
            }
        }
        return next;
    }

    private static int matchByKMP(char[] str, char[] match, int[] matchNext) {
        int i = 0, j = 0;
        while (i < str.length && j < match.length) {
            if (j == -1 || str[i] == match[j]) {
                i++;
                j++;
            } else {
                j = matchNext[j] - 1;
            }
            if (j == match.length - 1) {
                return i - j - 1;
            }
        }
        return -1;
    }
}
