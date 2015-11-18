package br.com.cwi.crescer;

import br.com.cwi.crescer.interfaces.MinhaLinkedList;

import java.io.IOException;
import java.util.Scanner;

import br.com.cwi.crescer.LinkedList;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import br.com.cwi.crescer.menus.MenuPrincipal;

public class Aplicacao {
	public static final int SIMPLELIST = 1;
	public static final int DUPLAMENTEENCADEADA = 2;
	
	public static final int ADD = 1;
	public static final int REMOVER = 2;
	public static final int LISTAR = 3;
	public static final int EXPORTARTXT = 4;
	
	public static final int SAIR = 0;
	
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	MenuPrincipal menu = new MenuPrincipal();
    	int opcao;
    	boolean rodando = true;
    	
    	while(rodando){
    		menu.mostrarOpcoesDeLista();
        	opcao = scan.nextInt();
        	if(opcao == SIMPLELIST){
        		logicaDoPrograma(SIMPLELIST);
        	}else if(opcao == DUPLAMENTEENCADEADA){
        		logicaDoPrograma(DUPLAMENTEENCADEADA);
        	}else if(opcao == SAIR){
        		rodando = false;
        	}
    	}
    	
    }
    
    private static void logicaDoPrograma(int opcaoLista){
    	MinhaLinkedList<String> linkedList;
    	if(opcaoLista == SIMPLELIST){
    		linkedList = new LinkedList<String>();
    	}else{
    		linkedList = new ListaDuplamenteEncadeada<String>();
    	}
    	
    	MenuPrincipal menu = new MenuPrincipal();
    	Scanner scan = new Scanner(System.in);
    	boolean rodando = true;
    	int opcao;
    	
    	while(rodando){
    		menu.mostrarMenuManter();
    		opcao = scan.nextInt();
    		scan.nextLine();
    		if(opcao == ADD ){
    			menu.pedirValor();
    			String valor = scan.nextLine();
    			if(!valor.isEmpty() && (valor instanceof String)){
    				linkedList.add(1, valor);
    			}else{
    				System.out.println("o valor deve ser do tipo texto");
    			}
    		}else if(opcao == REMOVER){
    			menu.pedirIndice();
    			try{
    				int indice = scan.nextInt();
    				linkedList.remove(indice);
    			}catch(Exception e){
    				System.out.println("o valor deve ser do tipo inteiro");
    			}
    			
    		}else if(opcao == LISTAR){
    			String texto = linkedList.toString();
    			menu.listar(texto);
    			
    		}else if(opcao == EXPORTARTXT){
    			try{
    				linkedList.exportarTxtDaLista();
    			}catch(IOException e){
    				System.out.println("nao deu pra exportar, tente outra vez");
    			}
    			
    		}else if(opcao == SAIR){
    			rodando = false;
    		}
    	}
    	
    }
    
}
