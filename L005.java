/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L005.java
 * @Description TODO
 * @createTime 2020年04月22日 22:56:00
 */
public class L005 {

    public String replaceSpace(String s) {

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if (' ' ==c) {
                sb.append("20%");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
