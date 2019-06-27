package com.ldb.medium;

import com.ldb.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ldb
 * @date 2019-06-27 17:15
 */
public class Solution102 {

    /**
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 例如: 给定二叉树: [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * <p>
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        List<List<TreeNode>> list = solution102.levelOrder(Solution102.buildTree());
        for (List<TreeNode> treeNodes : list) {
            for (TreeNode treeNode : treeNodes) {
                System.out.print(treeNode.val + " ");
            }
            System.out.println();
        }
    }


    public static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    /**
     * 该问题需要用到队列
     * <p>
     * 建立一个queue
     * 先把根节点放进去，这时候找根节点的左右两个子节点
     * 去掉根节点，此时queue里的元素就是下一层的所有节点
     * 用for循环遍历，将结果存到一个一维向量里
     * 遍历完之后再把这个一维向量存到二维向量里
     * 以此类推，可以完成层序遍历
     *
     * @param root
     * @return
     */
    public List<List<TreeNode>> levelOrder(TreeNode root) {
        List<List<TreeNode>> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes != null && nodes.size() > 0) {
            res.add(nodes);
            List<TreeNode> children = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode node = nodes.get(i);
                if (node.left != null) {
                    children.add(node.left);
                }
                if (node.right != null) {
                    children.add(node.right);
                }
            }
            nodes = children;

        }
        return res;
    }
}
