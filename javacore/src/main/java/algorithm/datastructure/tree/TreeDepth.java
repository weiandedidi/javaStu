package algorithm.datastructure.tree;

/**
 * 树的深度，查找树的深度，因为左右需要进行比对，所以需要左右比对
 *
 * @author qidima
 * @date 10/3/22 11:48 AM
 */
public class TreeDepth {

    /**
     * 树的节点
     */

    class TreeNode {
        int val;
        TreeDepth.TreeNode left;
        TreeDepth.TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(TreeDepth.TreeNode left, TreeDepth.TreeNode right, int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 题目：104. 二叉树的最大深度
     * 方法：递归
     * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
     * 找树的深度
     * 思路：左右子树判断大小后(递归)+1
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //左右不能断掉，需要找到后继续判断左右 so左右有比较判断
        if (null == root) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * 题目：110. 平衡二叉树
     * 方法：递归
     * https://leetcode.cn/problems/balanced-binary-tree/
     * 思路：辅助函数，查找左右字数的深度，判断差值的绝对值>1(不是平衡树), 返回-1作为查找深度函数的终止信号
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        //判断左右字数的深度，并比较，如果 子树的左右深度绝对值大于1，那么不是平衡的
        //辅助函数，找树的深度和绝对值
        return helper(root) != -1;
    }

    /**
     * 辅助函数，找树的深度比较函数
     */
    public int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        //子树的深度不平衡，返回-1
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        //返回树的深度
        return 1 + Math.max(left, right);
    }

    /**
     * 题目：543. 二叉树的直径
     * https://leetcode.cn/problems/diameter-of-binary-tree/
     * 方法：递归
     * 思路：两节点的直径拆解(根到左节点的距离+根到右节点距离)，查找左右节点的深度并相加，需要全局变量保存找到的最大直径
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        findDepthAndCalDiameter(root);
        return diameter;
    }

    /**
     * 全局变量的长度
     */
    int diameter;

    public int findDepthAndCalDiameter(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(left + right, diameter);
        return Math.max(left, right) + 1;
    }

    /**
     * 题目：437. 路径总和 III
     * https://leetcode.cn/problems/path-sum-iii/
     * 思路：路径求和的查找从根节点出发，数量个数=根单个节点(根节点自身和目标值相等的情况)+左子树的个数+右子树的个数
     * 算自身root的查找，左子树查找(递归)，右子树查找(递归)。
     * 方法：递归
     * 注意：
     * 测试用例[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
     * 官方代码会溢出,故使用long作为入参。
     *
     * @param root
     * @param targetSum
     * @return
     */
    int wayCount = 0;

    public void pathSum(TreeNode root, int targetSum) {
        //辅助函数，计算该子树下的满足 目标数字的路径个数
        pathSumStartWithRoot(root, targetSum);
        //左节点开始找
        pathSum(root.left, targetSum);
        //右节点开始找
        pathSum(root.right, targetSum);
    }

    /**
     * 数量个数=左子树的个数+右子树的个数+根节点(根节点自身和目标值相等的情况)
     * 返回满足节点的个数
     */
    public void pathSumStartWithRoot(TreeNode root, long sum) {
        if (null == root) {
            return;
        }
        if (root.val == sum) {
            //查找当前节点满足 +1
            wayCount++;
        }
        pathSumStartWithRoot(root.left, sum - root.val);
        pathSumStartWithRoot(root.right, sum - root.val);
    }

    /**
     * 题目：101. 对称二叉树
     * https://leetcode.cn/problems/symmetric-tree/
     * 思路：
     *  对称要素:
     * 1 两子树都空，即相等
     * 2 单子树非空，不等
     * 3 两子树根节点值不等，不等
     * 4 递归：轴对称，左子树的左根节点，右子树的右根节点
     * 方法：递归
     */
    public boolean isSymmetric(TreeNode root) {
        if(null==root){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    /**
     1. 两子树都空，对称 true
     2. 两子树单一空，不对称 false
     3. 两子树根节点不相等，不对称 false
     4. 继续向下递归判断各自下面的节点
     */
    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(null==left&& null==right){
            return true;
        }
        if(null==left||null==right){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        //轴对称，左子树的左根节点，右子树的由根节点
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }


    public static void main(String[] args) {

    }
}
