package todo;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//      预处理 邻接表存储图
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        Map<Integer,Integer> unVisited = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], new LinkedList<>());
            map.putIfAbsent(prerequisite[0], new LinkedList<>());
            map.get(prerequisite[1]).add(prerequisite[0]);
            unVisited.putIfAbsent(prerequisite[0],0);
            unVisited.putIfAbsent(prerequisite[1],0);
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

    private boolean dfs(Integer start, Map<Integer, List<Integer>> map, Map<Integer, Integer> unVisited) {
        if(unVisited.get(start) == 1)
            return false;
        if(unVisited.get(start) == -1)
            return true;
        unVisited.put(start,1);
        for (Integer integer : map.get(start)) {
            if (!dfs(integer, map, unVisited))
                return false;
        }
        unVisited.put(start,-1);
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        return null;
    }
    public static void main(String[] args) {
        boolean b = new CourseSchedule().canFinish(3, new int[][]{{1, 0},{2,0}});
        System.out.println(b);
    }
}
