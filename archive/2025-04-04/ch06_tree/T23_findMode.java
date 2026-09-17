package org.review2025spring.ch06_tree;

import java.util.ArrayList;

public class T23_findMode {

    Integer preVal = null;
    int count = 1;
    int maxCount = -1;
    ArrayList<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;

        traversal(root.left);

        if (preVal != null && preVal == root.val) {
            count++;
        } else {
            count = 1;
        }
        preVal = root.val;
        if (count == maxCount) {
            list.add(root.val);
        } else if (count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        }

        traversal(root.right);
    }

}
