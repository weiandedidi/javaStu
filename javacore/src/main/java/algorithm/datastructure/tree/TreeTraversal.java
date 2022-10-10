package algorithm.datastructure.tree;

import java.util.*;

/**
 * 树的遍历
 *
 * @author qidi
 * @date 2020-01-09 10:54
 */
public class TreeTraversal {

    //递归方式写法 Recursion递归

    /**
     * 先序遍历 根->左->右
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * @param root
     */
    public void preOrderRecursion(TreeNode root) {
        //根节点  Do Something with root
        if (root.left != null) preOrderRecursion(root.left);
        if (root.right != null) preOrderRecursion(root.right);
    }

    /**
     * 中序遍历 左->中->右
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param root
     */
    public void inOrderRecursion(TreeNode root) {
        if (root.left != null) inOrderRecursion(root.left);
        //根节点  Do Something with root
        if (root.right != null) inOrderRecursion(root.right);
    }

    /**
     * 后序遍历 左->中->右
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param root
     */
    public void postOrderRecursion(TreeNode root) {
        if (root.left != null) postOrderRecursion(root.left);
        //根节点  Do Something with root
        if (root.right != null) postOrderRecursion(root.right);
    }

    /**
     * 题目：144. 二叉树的前序遍历
     * 连接：https://leetcode.cn/problems/binary-tree-preorder-traversal/
     * 难度：栈的访问，中
     * 思路：栈，入栈先右后左，取栈顶；保证左->右的访问
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //借用栈，输出list
        List<Integer> list = new ArrayList<>();
        //栈，先进后出，所以前序遍历的 入栈顺序是 先右后左,取栈顶，保证遍历是 左到右侧
        Stack<TreeNode> stack = new Stack<>();
        if (null == root) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
        return list;
    }


    // 中序遍历的非递归的写法，
    // 1.左节点不为null则压入左节点
    // 2.左节点为null时，pop并打印，左节点
    // 3.在往右，右节点为null时，pop并打印
    // 4.右节点不为null时，压入右节点

    /**
     * 中序遍历，想像自己沿着树走，由于是先访问左子树，在访问中，然后右子树，所以需要保存中间的节点才能找到右节点
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
     * <p>
     * 两层while循环处理
     * 内层压栈，外层出站
     * <p>
     * 1. 先左子树，左节点不为null则左节点压栈，
     * 2. 为null，pop弹栈，游标切成右节点。
     * 3. 右节点不为null时，压栈，为null弹栈。
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //游标
        TreeNode node = root;
        while (!stack.isEmpty() || null != node) {
            //存入历史走过的节点，一直找左边的
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
            //当前左节点为null，需要弹出栈顶的左节点
            node = stack.pop();
            //do some thing node, 使用栈顶元素做些东西
            //处理右侧节点的节点
            node = node.right;
        }
    }

    /**
     * 后续遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {

    }

    /**
     * 题目：637. 二叉树的层平均值
     * 难度：简单
     * https://leetcode.cn/problems/average-of-levels-in-binary-tree/
     * 思路：
     * 二叉树的平均值是每层的平均值，每层的操作优选 层序遍历（广度优先bfs），两个队列，一个层序遍历，一个记录平均值，LinkedList<>()  offer poll
     *
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        //队列用于广度层序遍历
        List<Double> averages = new ArrayList<>();
        //list用于存储平均值
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum = sum + node.val;
                TreeNode left = node.left;
                if (null != left) {
                    queue.offer(left);
                }
                TreeNode right = node.right;
                if (null != right) {
                    queue.offer(right);
                }
            }
            Double average = sum / size;
            averages.add(average);
        }
        return averages;
    }

    /**
     * 树的节点
     */
    class TreeNode {
        int val;
        TreeTraversal.TreeNode left;
        TreeTraversal.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
