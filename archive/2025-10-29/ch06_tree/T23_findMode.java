package org.review2025autumn.ch06_tree;

import java.util.ArrayList;
import java.util.List;

public class T23_findMode {
    List<Integer> modeList = new ArrayList<>();
    Integer preVal;
    int maxFreq = 1;
    int currFreq = 1;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        traversal(root);
        return modeList.stream().mapToInt(i -> i).toArray();
    }

    public void traversal(TreeNode root) {
        if (root == null) {
            return;
        }

        traversal(root.left);

        // 更新 currFreq
        if (preVal != null && preVal == root.val) {
            currFreq++;
        } else {
            currFreq = 1;
        }

        // 更新 maxFreq 和 modeList
        if (currFreq == maxFreq) {
            modeList.add(root.val);
        } else if (currFreq > maxFreq) {
            modeList.clear();
            modeList.add(root.val);
            maxFreq = currFreq;

        }

        // 更新 preVal
        preVal = root.val;

        traversal(root.right);
    }
}
