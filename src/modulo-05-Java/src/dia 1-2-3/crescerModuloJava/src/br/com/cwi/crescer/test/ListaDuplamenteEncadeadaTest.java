package br.com.cwi.crescer.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;

import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import listaDuplamenteEncadeada.NodeDupla;

public class ListaDuplamenteEncadeadaTest {


	    @Test
	    public void adicionarNodoNoIndice2EOUltimoViraOIndice3() {
	        ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

	        linkedList.addFirst("primeiro");
	        linkedList.addLast("ultimo");
	        linkedList.add(1, "segundo");
	        linkedList.add(2, "terceiro");
	        
	        
	        NodeDupla<String> nodeSegundo = linkedList.getNodeDuplaByIndex(1);
	        
	        assertEquals("ultimo", linkedList.getLast());
	        assertEquals("segundo", nodeSegundo.getValue());
	        assertEquals("terceiro", nodeSegundo.getNext().getValue());
	    }
	    
	    @Test
	    public void adicionarNodosERemoverOIndice1EntaoOTerceiroTomaOLugarDeIndice1() {
	        ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

	        linkedList.addFirst("primeiro");
	        linkedList.addLast("ultimo");
	        linkedList.add(1, "segundo");
	        linkedList.add(2, "terceiro");
	        
	        linkedList.remove(1);
	        
	        assertEquals("ultimo", linkedList.getLast());
	        assertEquals("terceiro", linkedList.getNodeDuplaByIndex(1).getValue());
	    }
	    
	    @Test
	    public void adicionarNodoNoInicio() {
	        ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

	        linkedList.addFirst("primeiro");
	        
	        
	        assertEquals("primeiro", linkedList.getFirst());
	    }
	    
	    @Test
	    public void adicionarNodoNoInicioENoFim() {
	        ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

	        linkedList.addFirst("primeiro");
	        linkedList.addLast("ultimo");
	        
	        assertEquals("primeiro", linkedList.getFirst());
	        assertEquals("ultimo", linkedList.getLast());
	    }
	    
	    @Test
	    public void adicionarNodosEListar() {
	        ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

	        linkedList.addFirst("primeiro");
	        linkedList.addLast("ultimo");
	        linkedList.add(1, "segundo");
	        linkedList.add(2, "terceiro");
	        
	        List<String> listaEsperada = new ArrayList<String>();
	        listaEsperada.add("primeiro");
	        listaEsperada.add("segundo");
	        listaEsperada.add("terceiro");
	        listaEsperada.add("ultimo");
	        
	        List<String> listaObtida = linkedList.list();
	        
	        assertEquals(listaEsperada,listaObtida);
	        
	    }
}
