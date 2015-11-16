package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> {

    private Node<T> last;
    private Node<T> first;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (first == null) {
            last = node;
        }
        first = node;

    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {

        return this.last.getValue();
    }

    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
        }
        return lista;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value, last);
        if (first == null) {
            first = node;
        }
        first.setNext(node);
        last = node;

    }

    public void removeFirst() {
        first = first.getNext();
    }

    public void add(int index, T value) {
        Node<T> adicionado = new Node<T>(value);
        Node<T> node = getNodeByIndex(index);
        adicionado.setNext(node);
        Node<T> anterior = getNodeByIndex(index - 1);

        anterior.setNext(adicionado);
    }

    public void remove(int index) {

        Node<T> node = getNodeByIndex(index);
        Node<T> anterior = getNodeByIndex(index - 1);
        Node<T> proximo = node.getNext();

        anterior.setNext(proximo);

    }

    public Node<T> getNodeByIndex(int index) {
        Node<T> node = first;
        Node<T> nodeDoIndice = null;
        int indice = 0;
        while (node != null) {
            if (indice == index) {
                nodeDoIndice = node;
                return nodeDoIndice;
            }
            indice++;
            node = node.getNext();
        }
        return nodeDoIndice;
    }
}
