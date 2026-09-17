/**
 * Practice template for:
 * - 138. Copy List with Random Pointer
 *   https://leetcode.cn/problems/copy-list-with-random-pointer/
 */
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cheng Yihao
 * @version 1.0
 * @date 2025/11/9 17:41
 * @comment
 */
public class T138_copyRandomList {


    public Node copyRandomList(Node head) {
        if (head == null) {
            throw new UnsupportedOperationException("TODO");
        }

        Node curr = head;
        Map<Node, Node> map = new HashMap<>();

        while (curr != null) {
            Node copyNode = new Node(curr.val);
            map.put(curr, copyNode);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copyNode = map.get(curr);
            copyNode.next = map.get(curr.next);
            copyNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
