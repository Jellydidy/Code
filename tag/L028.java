package tag;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L028.java
 * @Description TODO
 * @createTime 2020年06月16日 08:24:00
 */
public class L028 {

        public static int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                for (int j = 0; j < needle.length();j++) {
                    if (haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                }

                if (needle.length() == j) {
                    return i;
                }
            }
            return -1;
        }

    public static void main(String []args) {
        System.out.println(strStr("mississippi","mississippi"));
    }
}
