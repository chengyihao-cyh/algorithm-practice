package org.review2024summer.tree;

import java.util.ArrayList;
import java.util.List;

public class T23_findMode {
    int maxCount = -1;
    List<Integer> res = new ArrayList<>();
    TreeNode preNode = null;
    int count = -1;

    public int[] findMode(TreeNode root) {
        traversal(root);
        int[] resArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            resArray[i] = res.get(i);
        return resArray;
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
            res.clear();
            maxCount = count;
            res.add(root.val);
        } else if (count == maxCount) {
            res.add(root.val);
        }
        preNode = root;
        traversal(root.right);
    }
}
