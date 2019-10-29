package completed;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//      预处理 邻接表存储图
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        Map<Integer, Integer> unVisited = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new LinkedList<>());
            map.putIfAbsent(prerequisite[0], new LinkedList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
            unVisited.putIfAbsent(prerequisite[0], 0);
            unVisited.putIfAbsent(prerequisite[1], 0);
        }
//      预处理结束
        for (Map.Entry<Integer, Integer> integerIntegerEntry : unVisited.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            if (!dfs(key, map, unVisited)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param start
     * @param map
     * @param unVisited
     * @return
     */
    private boolean dfs(Integer start, Map<Integer, List<Integer>> map, Map<Integer, Integer> unVisited) {
        if (unVisited.get(start) == 1)
            return false;
        if (unVisited.get(start) == -1)
            return true;
        unVisited.put(start, 1);
        for (Integer integer : map.get(start)) {
            if (!dfs(integer, map, unVisited))
                return false;
        }
        unVisited.put(start, -1);
        return true;
    }

    /**
     * 题目 https://leetcode-cn.com/problems/course-schedule-ii/
     * 通过
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] path = new int[numCourses];
        //      预处理 邻接表存储图
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        Map<Integer, Integer> unVisited = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            count.put(i, 0);
            unVisited.put(i, 0);
            map.put(i, new LinkedList<>());
        }
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
            count.put(prerequisite[0], count.get(prerequisite[0]) + 1);

        }
//      预处理结束
        List<Integer> p = new ArrayList<>(numCourses);
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (unVisited.get(entry.getKey()) == 0 && entry.getValue() == 0) {
                topo(map, entry.getKey(), p, unVisited, count);
            }
        }
        if (p.size() < numCourses)
            return new int[0];
        for (int i = 0; i < p.size(); i++) {
            path[i] = p.get(i);
        }
        return path;
    }

    private boolean topo(Map<Integer, List<Integer>> map, Integer key, List<Integer> integers, Map<Integer, Integer> unVisited, Map<Integer, Integer> count) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(key);
        while (!queue.isEmpty()) {
            Integer k = queue.poll();
            integers.add(k);
            unVisited.put(k, 1);
            for (Integer integer : map.get(k)) {
                Integer degree = count.get(integer);
                if (degree == 1)
                    queue.offer(integer);
                count.put(integer, degree - 1);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] order = new CourseSchedule().findOrder(5, new int[][]{{1, 0}, {3, 1}, {2, 3}, {0, 2}, {0, 4}});
        System.out.println(Arrays.toString(order));
    }
}
