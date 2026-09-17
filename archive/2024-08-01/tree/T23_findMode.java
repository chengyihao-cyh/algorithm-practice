package org.rereview2024summer.tree;

import java.util.ArrayList;
import java.util.List;

public class T23_findMode {
    TreeNode preNode = null;
    int count = 1;
    int maxCount = 1;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
    public void traversal(TreeNode root) {
        if (root == null)
            return;
        traversal(root.left);
        if (preNode != null && root.val == preNode.val) {
            count++;
        } else {
            count = 1;
        }
        if (count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        } else if (count == maxCount) {
            list.add(root.val);
        }
        preNode = root;
        traversal(root.right);
    }
}
