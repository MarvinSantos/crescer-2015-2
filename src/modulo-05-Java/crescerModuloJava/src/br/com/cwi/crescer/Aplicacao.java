package br.com.cwi.crescer;

import br.com.cwi.crescer.interfaces.MinhaLinkedList;

import java.util.Scanner;

import br.com.cwi.crescer.LinkedList;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import br.com.cwi.crescer.menus.MenuPrincipal;

public class Aplicacao {
	public static final int OPCAO1 = 1;
	public static final int OPCAO2 = 2;
	public static final int SAIR = 3;
	
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	MenuPrincipal menu = new MenuPrincipal();
    	int opcao;
    	boolean rodando = true;
    	
    	while(rodando){
    		menu.mostrarOpcoesDeLista();
        	opcao = scan.nextInt();
        	if(opcao == OPCAO1){
        		opcao1();
        	}
    	}
    	
    }
    
    private static void opcao1(){
    	//TODO:fazer a logica pra caso o usuario escolha a opcao1
    }
}
