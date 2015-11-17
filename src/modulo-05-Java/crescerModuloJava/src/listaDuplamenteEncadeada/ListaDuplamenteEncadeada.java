package listaDuplamenteEncadeada;

import java.util.ArrayList;
import java.util.List;

import listaDuplamenteEncadeada.NodeDupla;

public class ListaDuplamenteEncadeada<T> {
	
	private NodeDupla<T> last;
    private NodeDupla<T> first;

    public void addFirst(T value) {
        NodeDupla<T> node = new NodeDupla<T>(value, first);
        first = node;
        first.setNext(getNodeDuplaByIndex(1));

    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {

        return this.last.getValue();
    }

    public List<T> list() {
        ArrayList<T> lista = new ArrayList<T>();
        NodeDupla<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public void addLast(T value) {
        NodeDupla<T> node = new NodeDupla<T>(value, last);
        if (first == null) {
            addFirst(value);
        }else{    
        	NodeDupla<T> ultimoNode = getUltimoNodeDupla();
        	ultimoNode.setNext(node);
        	node.setAnterior(ultimoNode);
	        last = node;
	        
        }
    }

    public void removeFirst() {
        first = first.getNext();
    }

    public void add(int index, T value) {
        NodeDupla<T> adicionado = new NodeDupla<T>(value);
        NodeDupla<T> node = getNodeDuplaByIndex(index);
        adicionado.setNext(node);
        NodeDupla<T> anterior = node.getAnterior();
        node.setAnterior(adicionado);     
        adicionado.setAnterior(anterior);
        anterior.setNext(adicionado);
    }

    public void remove(int index) {

        NodeDupla<T> node = getNodeDuplaByIndex(index);
        if(node != null){
	        NodeDupla<T> anterior = node.getAnterior();
	        NodeDupla<T> proximo = node.getNext();
	
	        anterior.setNext(proximo);
	        proximo.setAnterior(anterior);
        }
    }

    public NodeDupla<T> getNodeDuplaByIndex(int index) {
        NodeDupla<T> node = first;
        NodeDupla<T> nodeDoIndice = null;
        int indice = 0;
        while (node != null) {
            if (indice == index) {
                nodeDoIndice = node;
                return nodeDoIndice;
            }
            indice++;
            node = node.getNext();
        }
       
        return  nodeDoIndice;
               
    }
    
    public NodeDupla<T> getUltimoNodeDupla() {
        NodeDupla<T> node = first;
        NodeDupla<T> nodeRetorno;
        while (node != null) {
        	nodeRetorno = node;
            node = node.getNext();
            if(node == null){
            	return nodeRetorno;
            }
        }
       
        return  node;
               
    }

}
