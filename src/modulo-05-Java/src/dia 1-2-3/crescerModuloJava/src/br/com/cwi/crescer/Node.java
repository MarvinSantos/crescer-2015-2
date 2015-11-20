package br.com.cwi.crescer;


public class Node<T> {

    private T value;

    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
