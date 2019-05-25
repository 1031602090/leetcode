package completed;

import org.junit.Assert;

import java.util.LinkedList;
import java.util.List;

public class SimplifyPath {

    public static void main(String[] args) {
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));

        Assert.assertEquals("/home", simplifyPath("/home/"));

        Assert.assertEquals("/", simplifyPath("/../"));

        Assert.assertEquals("/home/foo", simplifyPath("/home//foo/"));

        Assert.assertEquals("/c", simplifyPath("/a/../../b/../c//.//"));

        Assert.assertEquals("/a/b/c", simplifyPath("/a//b////c/d//././/.."));
    }


    public static String simplifyPath(String path) {
        LinkedList<String> res = new LinkedList<>();
        List<String> t = new LinkedList<>();
        for (String s : path.split("/")) if (!s.equals("")) t.add(s);
        for (String e : t) {
            switch (e) {
                case ".":
                    break;
                case "..":
                    if (!res.isEmpty()) res.remove(res.size() - 1);
                    break;
                default:
                    res.add("/" + e);
            }
        }
        if (res.isEmpty()) res.add("/");
        StringBuilder sb = new StringBuilder();
        for (String s : res) {
            sb.append(s);
        }
        return sb.toString();
    }
}