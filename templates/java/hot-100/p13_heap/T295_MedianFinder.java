/**
 * Practice template for:
 * - 295. Find Median from Data Stream
 *   https://leetcode.cn/problems/find-median-from-data-stream/
 */
import java.util.PriorityQueue;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/7 18:19
 * @comment
 */
public class T295_MedianFinder {
    class MedianFinder {
        PriorityQueue<Integer> preQueue;
        PriorityQueue<Integer> postQueue;

        public MedianFinder() {
            // preQueue 维持 size>= postQueue
            this.preQueue = new PriorityQueue<>((a, b) -> b - a);
            this.postQueue = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            if (preQueue.size() == postQueue.size()) {
                postQueue.offer(num);
                preQueue.offer(postQueue.poll());
            } else {
                preQueue.offer(num);
                postQueue.offer(preQueue.poll());
            }
        }

        public double findMedian() {
            if (preQueue.size() != postQueue.size()) {
                return preQueue.peek();
            } else {
                return ((double) preQueue.peek() + postQueue.peek()) / 2;
            }
        }
    }
}
