package ru.ifmo.backend_2021;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        next = null;
        data = d;
    }

    public void setData(int d) {
        data = d;
    }

    public int getData() {
        return data;
    }
}