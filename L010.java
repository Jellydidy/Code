import java.util.HashMap;
import java.util.Map;

/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L010.java
 * @Description TODO
 * @createTime 2020年05月19日 23:41:00
 */
public class L010 {
    static Map<Integer, Integer> cache = new HashMap<>();
    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            cache.put(n, fib(n-1) + fib(n - 2));
        }
        return fib(n-1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fib(20));
    }
}
