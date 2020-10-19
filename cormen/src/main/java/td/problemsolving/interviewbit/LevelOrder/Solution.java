package td.problemsolving.interviewbit.LevelOrder;

import java.util.ArrayList;
import java.util.List;
import td.problemsolving.interviewbit.common.TreeNode;

/**
 * Level Order
 * https://www.interviewbit.com/problems/level-order/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (a == null) return result;

        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(a);

        while (!levelNodes.isEmpty()) {
            List<TreeNode> nextLevelNodes = new ArrayList<>();
            ArrayList<Integer> levelOutput = new ArrayList<>();

            for (TreeNode levelNode : levelNodes) {
                levelOutput.add(levelNode.val);

                if (levelNode.left != null) nextLevelNodes.add(levelNode.left);
                if (levelNode.right != null) nextLevelNodes.add(levelNode.right);
            }

            levelNodes = nextLevelNodes;
            result.add(levelOutput);
        }

        return result;
    }
}
