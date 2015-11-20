package br.com.cwi.crescer.interfaces;

import java.io.IOException;
import java.util.List;
import br.com.cwi.crescer.Node;

public interface MinhaLinkedList<T> {
	
	
	public void addFirst(T value);

    public T getFirst();

    public T getLast();

    public List<T> list();

    public void addLast(T value);

    public void removeFirst();

    public void add(int index, T value);

    public void remove(int index);
    
    public void exportarTxtDaLista()throws IOException;
    
    public String toString();
	
}
