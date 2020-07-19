/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L010_1.java
 * @Description TODO
 * @createTime 2020年05月20日 00:51:00
 */
public class L010_1 {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        int pre = 1;
        int cur = 2;
        for (int i=3;i<=n;i++) {
            int temp = (pre + cur)%1000000007;
            pre = cur;
            cur = temp;
        }

        return cur;
    }
}
