package it.giannotti.tree;

class Node<T> {
    Node<T> child, sibling;
    T element;

    Node(T element) {
        this.element = element;
    }
    Node() {
    }
}
