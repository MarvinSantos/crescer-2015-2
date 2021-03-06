package listaDuplamenteEncadeada;

import listaDuplamenteEncadeada.NodeDupla;


public class NodeDupla<T> {
	
	private T value;

	private NodeDupla<T> anterior;
	
    private NodeDupla<T> next;

    public NodeDupla(T value, NodeDupla<T> next) {
        this.value = value;
        this.next = next;
    }

    public NodeDupla(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(NodeDupla<T> node) {
        this.next = node;
    }

    public NodeDupla<T> getNext() {
        return this.next;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeDupla<T> getAnterior(){
    	return this.anterior;
    }
    
    public void setAnterior(NodeDupla<T> node){
    	this.anterior = node;
    }
}
