package com.ldb.structure;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        Node treeNode = buildTree();
        printTree(treeNode);
    }

    public static void printTree(Node node) {
        if (node == null) return;
        List<Node[]> nodeList = new ArrayList<Node[]>();
        Node[] nodes = new Node[]{node};
        System.out.print(node.name);
        while (nodes != null && nodes.length > 0) {
            nodeList.add(nodes);
            nodes = getChildNodes(nodes);
            for (int i = 0; i < nodes.length; i++) {
                Node n = nodes[i];
                if (n != null) {
                    System.out.print("-->" + n.name);
                }
            }
        }
    }

    public static Node[] getChildNodes(Node[] nodes) {
        if (nodes == null) return null;
        List<Node> lst = new ArrayList<Node>();
        for (int i = 0; i < nodes.length; i++) {
            Node node = nodes[i];
            if (node.left != null) {
                lst.add(node.left);
            }
            if (node.right != null) {
                lst.add(node.right);
            }
        }
        Node[] nodeChildren = new Node[lst.size()];
        lst.toArray(nodeChildren);
        return nodeChildren;
    }

    public static Node buildTree() {
        Node root = new Node("A");
        root.left = new Node("B");
        root.right = new Node("C");
        root.left.left = new Node("D");
        root.right.left = new Node("E");
        root.right.right = new Node("F");
        return root;
    }

    int treeDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int nLeft = treeDepth(root.left);
        int nRight = treeDepth(root.right);

        return nLeft > nRight ? nLeft + 1 : nRight + 1;
    }

    public static void printTree2(Node node) {
        if (node == null) ;
        List<Node[]> nodeList = new ArrayList<Node[]>();
        Node[] nodes = new Node[]{node};
        System.out.print(node.name);
        while (nodes != null && nodes.length > 0) {
            nodeList.add(nodes);
            nodes = getChildNodes(nodes);
            for (int i = 0; i < nodes.length; i++) {
                Node n = nodes[i];
                if (n != null) {
                    System.out.print("-->" + n.name);
                }
            }
        }

        System.out.println("二叉树的深度 : " + nodeList.size());
    }


}

class Node {
    public Node left;
    public Node right;
    public String name;

    public Node(String name) {
        this.name = name;
    }
}