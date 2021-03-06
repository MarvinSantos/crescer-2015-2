package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.cwi.crescer.interfaces.MinhaLinkedList;

public class LinkedList<T> implements MinhaLinkedList<T>{

    private Node<T> last;
    private Node<T> first;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        node.setNext(first);
        if(first == null){
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
            node = node.getNext();
        }
        return lista;
    }
    
    @Override
    public String toString(){
    	List<T> lista = new ArrayList<T>();
    	lista = list();
    	String listaString = "";
    	for(int i = 0; i < lista.size(); i++){
    		listaString += lista.get(i).toString() + "\r\n";
    	}
    	return listaString;
    }

    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (first == null) {
            addFirst(value);
        }else{
        	last.setNext(node);
        	last = node;
        }
    }

    public void removeFirst() {
        first = first.getNext();
    }
    
   
    public void add(int index, T value) {
        Node<T> adicionado = new Node<T>(value);
        Node<T> node = getNodeByIndex(index);
        adicionado.setNext(node);
        Node<T> anterior = getNodeByIndex(index - 1);
        if(anterior != null){
        	anterior.setNext(adicionado);
        }else{
        	addFirst(value);
        }
        
    }

    public void remove(int index) {
    
        Node<T> node = getNodeByIndex(index);
        if(node != null){
	        Node<T> anterior = getNodeByIndex(index - 1);
	        if(anterior != null){
	        	Node<T> proximo = node.getNext();
		        anterior.setNext(proximo);
	        }else{
	        	removeFirst();
	        }
        }
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
    
    public void exportarTxtDaLista() throws IOException{
    	File file = new File("C:\\Users\\marvi\\Documents\\crescer-2015-2\\src\\modulo-05-Java\\arquivosIO\\lista.txt");
    	
    	if(!file.exists()){  
            file.createNewFile();      
        }
    	
        try(PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (file, false)))){
        	String lista = toString();
        	
        	pw.write(lista);
        	pw.flush();
        	pw.close();
        }catch(IOException e){
        	throw e;
        }
    }
}
