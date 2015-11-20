package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;


public class LinkeListTest {

    @Test
    public void adicionarUmNodoNalistaVazia() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");

        assertEquals("primeiro", linkedList.getFirst());
        assertEquals("primeiro", linkedList.getLast());
    }

    @Test
    public void adicionarTresNodosNalistaVazia() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");

        assertEquals("terceiro", linkedList.getFirst());
        assertEquals("primeiro", linkedList.getLast());
    }

    @Test
    public void adicionarNodoNoFinal() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addLast("ultimo");

        assertEquals("ultimo", linkedList.getLast());
    }

    @Test
    public void adicionarNodoNoIndice1EOUltimoViraOIndice2() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");

        linkedList.add(1, "segundo");

        assertEquals("ultimo", linkedList.getLast());
        assertEquals("primeiro", linkedList.getFirst());
        assertEquals("segundo", linkedList.getNodeByIndex(1).getValue());
    }

    @Test
    public void adicionarNodoNoIndice2EOUltimoViraOIndice3() {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");

        linkedList.add(1, "segundo");
        linkedList.add(2, "terceiro");

        assertEquals("ultimo", linkedList.getLast());
        assertEquals("primeiro", linkedList.getFirst());
        assertEquals("segundo", linkedList.getNodeByIndex(1).getValue());
        assertEquals("terceiro", linkedList.getNodeByIndex(2).getValue());
    }

}
