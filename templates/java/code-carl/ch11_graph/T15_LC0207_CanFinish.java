/**
 * Practice template for:
 * - LeetCode 207. Course Schedule
 *   https://leetcode.cn/problems/course-schedule/
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 14:22
 * @comment
 */
public class T15_LC0207_CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 准备数据结构
        int[] inDegree = new int[numCourses];
        ArrayList<Integer> result = new ArrayList<>(numCourses);
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 初始化
        for (int i = 0; i < numCourses; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            inDegree[pre[0]]++;
            graph.get(pre[1]).add(pre[0]);
        }

        // 添加启动点
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                result.add(i);
                deque.offer(i);
            }
        }

        // 队列 BFS
        while (!deque.isEmpty()) {
            Integer curr = deque.poll();
            for (Integer next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    result.add(next);
                    deque.offer(next);
                }
            }
        }

        return result.size() == numCourses;
    }
}
