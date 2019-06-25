package tree;

/**
 * 二叉树的镜像
 *
 * 解题思路：
 * 二叉树的镜像，即左右子树调换。从上到下，递归完成即可。
 */
public class MirrorOfBinaryTree {

    public static void mirrorRecursively(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorRecursively(root.left);
        mirrorRecursively(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode node10=new BinaryTreeNode(10,null,null);
        BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
        BinaryTreeNode node9=new BinaryTreeNode(9,null, node10);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(5, node8, node9);
        BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
        BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3=new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1=new BinaryTreeNode(1, node2, node3);

        BinaryTreeOrder treeOrder = new BinaryTreeOrder();

        treeOrder.levelOrder(node1);
        System.out.print("\n");
        mirrorRecursively(node1);
        treeOrder.levelOrder(node1);
    }
}
