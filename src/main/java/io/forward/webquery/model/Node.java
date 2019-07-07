package io.forward.webquery.model;

public class Node {

    Tag tag;

    Node next;

    public Node (Tag tag, Node next) {
        this.tag = tag;
        this.next = next;
    }
}
