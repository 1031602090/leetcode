package newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> diskList = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            diskList.add(new Node(sc.next()));
        Collections.sort(diskList);
        diskList.forEach(System.out::println);
    }

    static class Node implements Comparable<Node> {
        String val;

        Node(String val) {
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            long a = Integer.parseInt(val.substring(0, val.length() - 1));
            long b = Integer.parseInt(o.val.substring(0, o.val.length() - 1));
            long l = getEx(val);
            a *= l;
            l = getEx(o.val);
            b *= l;
            return b - a > 0 ? -1 : 1;
        }

        private long getEx(String s) {
            long l = 1;
            if (s.contains("G")) {
                l = 1000;
            } else if (s.contains("T")) {
                l = 1000 * 1000;
            }
            return l;
        }

        @Override
        public String toString() {
            return val;
        }
    }
}
