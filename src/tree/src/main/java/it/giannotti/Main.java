package it.giannotti;

public class Main {
    public static void main(String[] args) {

        Node<String> a = new Node<>("r");
        a.addChild(0, new Node<>("A"));
        a.addChild(0, new Node<>("B"));
        a.addChild(1, new Node<>("C"));
        a.addChild(1, new Node<>("D"));
        a.addChild(4, new Node<>("E"));

        System.out.println(a.getDepth());
        System.out.println(a.countLeaves());
        System.out.println(a.countNodes());

        System.out.println("DFS:");
        a.depthFistSearch();
        System.out.println("\nBFS:");
        a.breadthFirstSearch();
    }
}