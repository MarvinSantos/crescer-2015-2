package listaDuplamenteEncadeada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.Node;
import br.com.cwi.crescer.interfaces.MinhaLinkedList;
import listaDuplamenteEncadeada.NodeDupla;

public class ListaDuplamenteEncadeada<T> implements MinhaLinkedList<T>{
	
	private NodeDupla<T> last;
    private NodeDupla<T> first;

    public void addFirst(T value) {
        NodeDupla<T> node = new NodeDupla<T>(value, first);
        if( first == null){
        	last = node;
        }else{
        	first.setAnterior(node);
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
        NodeDupla<T> node = first;
        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }
        return lista;
    }

    public void addLast(T value) {
        NodeDupla<T> node = new NodeDupla<T>(value);
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
        if(node != null){
        	adicionado.setNext(node);
        	NodeDupla<T> anterior = node.getAnterior();
        	node.setAnterior(adicionado);   
            if(anterior != null){         	     
                adicionado.setAnterior(anterior);
                anterior.setNext(adicionado);
            }else{
            	addFirst(value);
            }
            
        }else{
        	addFirst(value);
        }
        
    }

    public void remove(int index) {

        NodeDupla<T> node = getNodeDuplaByIndex(index);
        if(node != null){
	        NodeDupla<T> anterior = node.getAnterior();
	        NodeDupla<T> proximo = node.getNext();
	        if(anterior != null){
	        	anterior.setNext(proximo);
		        proximo.setAnterior(anterior);
	        }else{
	        	removeFirst();
	        }
	        
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
    
    
    
    public void exportarTxtDaLista() throws IOException{
    	File file = new File("C:\\Users\\marvi\\Documents\\crescer-2015-2\\src\\modulo-05-Java\\arquivosIO\\listaDuplamenteEncadeada.txt");
    	
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
