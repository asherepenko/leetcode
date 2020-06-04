package com.sherepenko.leetcode.solutions;

public class AVLTree {
    enum Traversal {
        PRE_ORDER,
        IN_ORDER,
        POST_ORDER,
        LEVEL_ORDER
    }

    static class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private static final int TREE_INDENTATION = 5;

    private Node root;

    public void insert(int value) {
        root = insert(root, value);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    public Node find(int value) {
        Node current = root;

        while (current != null) {
            if (current.value == value) {
                break;
            }
            current = current.value < value ? current.right : current.left;
        }

        return current;
    }

    public void prettifyPrint() {
        prettifyPrint(root, 0);
    }

    public String joinToString() {
        return joinToString(Traversal.PRE_ORDER);
    }

    public String joinToString(Traversal traversal) {
        return joinToString(", ", "[", "]", traversal);
    }

    public String joinToString(String separator, String prefix, String postfix, Traversal traversal) {
        final StringBuilder builder = new StringBuilder();

        builder.append(prefix);

        switch (traversal) {
            case PRE_ORDER:
                preOrderTraversal(root, builder, separator);
                break;
            case IN_ORDER:
                inOrderTraversal(root, builder, separator);
                break;
            case POST_ORDER:
                postOrderTraversal(root, builder, separator);
                break;
            case LEVEL_ORDER:
                for (int i = 1; i <= getHeight(root); i++) {
                    levelOrderTraversal(root, i, builder, separator);
                }
                break;
        }

        builder.setLength(builder.length() - separator.length());
        builder.append(postfix);

        return builder.toString();
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (node.value > value) {
            node.left = insert(node.left, value);
        } else if (node.value < value) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        return rebalance(node);
    }

    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.value > value) {
            node.left = delete(node.left, value);
        } else if (node.value < value) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                final Node minNode = getMinNode(node.right);
                node.value = minNode.value;
                node.right = delete(node.right, node.value);
            }
        }

        return node == null ? null : rebalance(node);
    }

    private Node getMinNode(Node node) {
        Node current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    private Node getMaxNode(Node node) {
        Node current = node;

        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    private Node rebalance(Node z) {
        updateHeight(z);
        final int balance = getBalance(z);

        if (balance > 1) {
            if (getBalance(z.right) < 0) {
                z.right = rotateRight(z.right);
            }
            z = rotateLeft(z);
        } else if (balance < -1) {
            if (getBalance(z.left) > 0) {
                z.left = rotateLeft(z.left);
            }
            z = rotateRight(z);
        }

        return z;
    }

    private Node rotateRight(Node y) {
        final Node x = y.left;
        final Node z = x.right;

        x.right = y;
        y.left = z;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node y) {
        final Node x = y.right;
        final Node z = x.left;

        x.left = y;
        y.right = z;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private int getHeight(Node node) {
        return node == null ? 0 : node.height;
    }

    private void updateHeight(Node node) {
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : getHeight(node.right) - getHeight(node.left);
    }

    private static void preOrderTraversal(Node node, StringBuilder builder, String separator) {
        if (node == null) {
            return;
        }

        builder.append(node.value).append(separator);

        preOrderTraversal(node.left, builder, separator);
        preOrderTraversal(node.right, builder, separator);
    }

    private static void inOrderTraversal(Node node, StringBuilder builder, String separator) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, builder, separator);
        builder.append(node.value).append(separator);
        inOrderTraversal(node.right, builder, separator);
    }

    private static void postOrderTraversal(Node node, StringBuilder builder, String separator) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left, builder, separator);
        postOrderTraversal(node.right, builder, separator);
        builder.append(node.value).append(separator);
    }

    private static void levelOrderTraversal(Node node, int level, StringBuilder builder, String separator) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            builder.append(node.value).append(separator);
        } else if (level > 1) {
            levelOrderTraversal(node.left, level - 1, builder, separator);
            levelOrderTraversal(node.right, level - 1, builder, separator);
        }
    }

    private static void prettifyPrint(Node node, int space) {
        if (node == null) {
            return;
        }

        final int indentation = space + TREE_INDENTATION;

        prettifyPrint(node.right, indentation);

        for (int i = TREE_INDENTATION; i < indentation; i++) {
            System.out.print(" ");
        }
        System.out.println(node.value);

        prettifyPrint(node.left, indentation);
    }
}
