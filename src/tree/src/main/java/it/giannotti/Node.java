package it.giannotti;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node<T> {
    private int pos = 0;
    private Node<T> child, sibling;
    private T element;

    Node(T element) {
        this.element = element;
    }

    Node() {
    }

    public Node<T> getChild() {
        return child;
    }

    public void setChild(Node<T> child) {
        this.child = child;
    }

    public Node<T> getSibling() {
        return sibling;
    }

    public void setSibling(Node<T> sibling) {
        this.sibling = sibling;
    }

    public T getElement() {
        return element;
    }

    private Node<T> findNodeByPos(int pos) {
        if (this.pos == pos) {
            return this;
        }
        Node<T> temp = this.child;
        while (temp != null) {
            Node<T> a = temp.findNodeByPos(pos);
            if (a != null) {
                return a;
            }
            temp = temp.sibling;
        }
        return null;
    }

    public void addChild(int pos, Node<T> node) {
        Node<T> parent = findNodeByPos(pos);
        if (parent.child == null) {
            parent.child = node;
        } else {
            parent = parent.child;
            while (parent.sibling != null) {
                parent = parent.sibling;
            }
            parent.sibling = node;
        }
        node.pos = countNodes() - 1;
    }

    public int getDepth() {
        if (this.child == null) {
            return 1;
        }
        int depth = 0;
        Node<T> temp = this.child;
        while (temp != null) {
            depth = Math.max(depth, temp.getDepth());
            temp = temp.sibling;
        }
        return depth + 1;
    }

    public int countNodes() {
        int count = 1;
        if (this.child != null) {
            count += this.child.countNodes();
        }
        if (this.sibling != null) {
            count += this.sibling.countNodes();
        }
        return count;
    }

    public int countLeaves() {
        if (this.child == null) {
            return 1;
        } else {
            int count = 0;
            Node<T> temp = this.child;
            while (temp != null) {
                count += temp.countLeaves();
                temp = temp.sibling;
            }
            return count;
        }
    }

    public void depthFistSearch() {
        System.out.print(this.element + " ");
        if (this.child != null) {
            this.child.depthFistSearch();
        }
        if (this.sibling != null) {
            this.sibling.depthFistSearch();
        }
    }

    public void breadthFirstSearch() {
        ArrayList<Node<T>> list = new ArrayList<>();
        list.add(this); 

        while (!list.isEmpty()) {
            Node<T> currentNode = list.remove(0); 
            System.out.print(currentNode.element + " "); 
            Node<T> node = currentNode.child;
            while (node != null) {
                list.add(node); 
                node = node.sibling;
            }
        }
    }
}
