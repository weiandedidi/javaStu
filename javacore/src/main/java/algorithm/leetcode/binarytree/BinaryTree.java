package algorithm.leetcode.binarytree;

/**
 * @author maqidi
 * @date 2023/7/18 11:41 AM
 */
public class BinaryTree {
    Node root;

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    int preIndex = 0;

    Node constructTree(int in[], int pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) {
            return null;
        }

        Node tNode = new Node(pre[preIndex++]);

        if (inStrt == inEnd) {
            return tNode;
        }

        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = constructTree(in, pre, inStrt, inIndex - 1);
        tNode.right = constructTree(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return i;
    }

    void printPostorder(Node node) {
        if (node == null) {
            return;
        }
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        int in[] = new int[]{4, 2, 5, 1, 6, 3};
        int pre[] = new int[]{1, 2, 4, 5, 3, 6};
        int len = in.length;
        Node root = tree.constructTree(in, pre, 0, len - 1);

        tree.printPostorder(root);
    }
}
