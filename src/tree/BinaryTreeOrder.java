package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class BinaryTreeOrder {

    /**
     * 递归前序遍历
     * @param root
     */
    public void preOrderByRecursion(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + "\t");
            preOrderByRecursion(root.left);
            preOrderByRecursion(root.right);
        }
    }

    /**
     * 循环前序遍历
     * @param root
     */
    public void preOrderByCirculation(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.print(treeNode.data + "\t");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

//        if (root == null) {
//            return;
//        }
//        Stack<BinaryTreeNode> stack = new Stack<>();
//        while (true) {
//            while (root != null) {
//                System.out.print(root.data + "\t");
//                stack.push(root);
//                root = root.left;
//            }
//            if (stack.isEmpty()) {
//                break;
//            }
//            root = stack.pop();
//            root = root.right;
//        }
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void inOrderByRecursion(BinaryTreeNode root) {
        if (root != null) {
            inOrderByRecursion(root.left);
            System.out.print(root.data + "\t");
            inOrderByRecursion(root.right);
        }
    }

    /**
     * 循环中序遍历
     * @param root
     */
    public void inOrderByCirculation(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.print(treeNode.data + "\t");
                treeNode = treeNode.right;
            }
        }

//        if (root == null) {
//            return;
//        }
//        Stack<BinaryTreeNode> stack = new Stack<>();
//        while (true) {
//            while (root != null) {
//                stack.push(root);
//                root = root.left;
//            }
//            if (stack.isEmpty()) {
//                break;
//            }
//            root = stack.pop();
//            System.out.print(root.data + "\t");
//            root = root.right;
//        }
    }

    /**
     * 递归后序遍历
     * @param root
     */
    public void postOrderByRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        postOrderByRecursion(root.left);
        postOrderByRecursion(root.right);
        System.out.print(root.data + "\t");
    }

    /**
     * 循环后序遍历
     * @param root
     */
    public void postOrderByCirculation(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) return;
                if (null == stack.lastElement().right) {
                    root = stack.pop();
                    System.out.print(root.data + "\t");
                    while (root == stack.lastElement().right) {
                        System.out.print(stack.lastElement().data + "\t");
                        root = stack.pop();
                        if (stack.isEmpty()) {
                            break;
                        }
                    }
                }

                if (!stack.isEmpty())
                    root = stack.lastElement().right;
                else
                    root = null;
            }
        }
    }

    /**
     * 不分行层序遍历 利用队列queue实现
     * @param root
     */
    public void levelOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.data + "\t");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    /**
     * 分行层序遍历
     * @param root
     */
    public void levelOrder1(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 下一层节点的数量
        int nextLevel = 0;
        // 当前层中还没有打印的节点数
        int toBePrinted = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null) {
                queue.offer(tempNode.left);
                nextLevel++;
            }
            if (tempNode.right != null) {
                queue.offer(tempNode.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
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
//        System.out.println("-----递归前序遍历------");
//        treeOrder.preOrderByRecursion(node1);
//        System.out.println("-----循环前序遍历------");
//        treeOrder.preOrderByCirculation(node1);
//        System.out.println("-----递归中序遍历------");
//        treeOrder.inOrderByRecursion(node1);
//        System.out.println("-----循环中序遍历------");
//        treeOrder.inOrderByCirculation(node1);
//        System.out.println("-----递归后序遍历------");
//        treeOrder.postOrderByRecursion(node1);
//        System.out.println("-----循环后序遍历------");
//        treeOrder.postOrderByCirculation(node1);
        System.out.println("-----不分层层序遍历------");
        treeOrder.levelOrder(node1);
        System.out.println();
        System.out.println("-----分层层序遍历------");
        treeOrder.levelOrder1(node1);
    }
}
