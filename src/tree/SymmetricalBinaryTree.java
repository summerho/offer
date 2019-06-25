package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 *
 * 题目要求：
 * 判断一棵二叉树是不是对称的。如果某二叉树与它的镜像一样，称它是对称的。
 * 解题思路：
 * 比较直接的思路是比较原树与它的镜像是否一样。书中就是用的这种方式（比较二叉树的前序遍历和对称前序遍历）。但这种思路下，树的每个节点都要读两次，也就是遍历两遍。
 * 其实可以只遍历一次完成判断：我们可以通过判断待判断二叉树的左子树与右子树是不是对称的来得知该二叉树是否是对称的。
 */
public class SymmetricalBinaryTree {

    /**
     * 利用2个队列queue实现
     * @param root
     * @return
     */
    public static boolean isSymmetrical(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Queue<BinaryTreeNode> leftQueue = new LinkedList<>();
        Queue<BinaryTreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        BinaryTreeNode tempLeft;
        BinaryTreeNode tempRight;
        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            tempLeft = leftQueue.poll();
            tempRight = rightQueue.poll();
            if (tempLeft != null && tempRight != null && tempLeft.data == tempRight.data) {
                if (tempLeft.left != null) {
                    leftQueue.offer(tempLeft.left);
                }
                if (tempLeft.right != null) {
                    leftQueue.offer(tempLeft.right);
                }
                if (tempRight.right != null) {
                    rightQueue.offer(tempRight.right);
                }
                if (tempRight.left != null) {
                    rightQueue.offer(tempRight.left);
                }
            } else {
                return false;
            }
        }
        if (leftQueue.isEmpty() && rightQueue.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        BinaryTreeNode node10=new BinaryTreeNode(10,null,null);
//        BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
//        BinaryTreeNode node9=new BinaryTreeNode(9,null, node10);
//        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
//        BinaryTreeNode node5=new BinaryTreeNode(5, node8, node9);
//        BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
//        BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
//        BinaryTreeNode node2=new BinaryTreeNode(2, node4, node5);
//        BinaryTreeNode node3=new BinaryTreeNode(3, node6, node7);
//        BinaryTreeNode node1=new BinaryTreeNode(1, node2, node3);

        BinaryTreeNode node4=new BinaryTreeNode(5,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(7, null, null);
        BinaryTreeNode node6=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node7=new BinaryTreeNode(5,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(6, node4, node5);
        BinaryTreeNode node3=new BinaryTreeNode(6, node6, node7);
        BinaryTreeNode node1=new BinaryTreeNode(8, node2, node3);

        System.out.print("此二叉树" + (isSymmetrical(node1) ? "是" : "不是") + "对称的二叉树");
    }
}
