package org.learn2024winter.graph;

import java.util.*;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2024/12/4 14:22
 * @comment
 */
public class T15_canFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // step1 准备数据结构
        List<List<Integer>> graph = new ArrayList<>(numCourses);  // 存储图
        int[] inDegree = new int[numCourses];       // 存储节点入度
        Deque<Integer> deque = new ArrayDeque<>();  // 排序辅助队列
        List<Integer> result = new ArrayList<>();   // 存储结果

        // step2 初始化数据结构
        for (int i = 0; i < numCourses; i++) {
            // 初始化图
            graph.add(new LinkedList<Integer>());
        }
        for (int[] pre : prerequisites) {
            // 初始化 图 与 入度列数组
            graph.get(pre[1]).add(pre[0]);  // 先修课 -> 后修课
            inDegree[pre[0]]++;             // 后修课入度 +1
        }
        for (int i = 0; i < numCourses; i++) {
            // 初始化队列 加入启动节点
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }

        // step3 BFS执行拓扑排序
        while (!deque.isEmpty()) {
            // 获得先修课 curr 指向的后修课 next 课程
            Integer curr = deque.poll();
            result.add(curr);
            for (Integer next : graph.get(curr)) {
                inDegree[next]--;  // next 入度 - 1
                if (inDegree[next] == 0)
                    deque.add(next);
            }
        }

        return result.size() == numCourses;
    }
}
