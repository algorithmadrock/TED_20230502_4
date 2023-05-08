/*
 RESUMO		 : Lista de inteiros que não se repetem
 PROGRAMADORA: Luiza Felix
 DATA		 : 08/05/2023
 */

package br.edu.fateczl.setint;

public class IntSet {
	
	IntNo zero;
	
	public IntSet() {
		zero = null;
	}
	
	public boolean vazia() {
		if (zero == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addfirst(int valor) throws Exception{
		if(!repeat(valor)) {
			IntNo novo = new IntNo();
			novo.dado = valor;
			novo.proximo = zero;
			zero = novo;
		} else {
			throw new Exception("Valor já existe na lista.");
		}
		
	}
	
	public void addlast(int valor) throws Exception{
		
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		 if(!repeat(valor)) {
			int size = (size() - 1);
			
			IntNo novo = new IntNo();
			novo.dado = valor;
			novo.proximo = null;
			IntNo n = getno(size); 
			n.proximo = novo;
		 }
	}
	
	public void add (int valor, int indice) throws Exception{
//		adiciono um dado em qualquer lugar, sabendo a posição desejada
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = size();	
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		
		if (indice == 0) {
			addfirst(valor);
		} else if(indice == size) {
			addlast(valor);
		} else if(!repeat(valor)){
			IntNo novo = new IntNo();
			novo.dado = valor;
			
			IntNo anterior = getno(indice - 1); 
			novo.proximo = anterior.proximo; 
			anterior.proximo = novo; 
		}
	}
	
	private boolean repeat(int valor) {
		int size = size();
		IntNo pet = zero; //horando os animais "pet" e "repete"
		
		for(int i = 0; i < size; i++ ) {
			if(pet.dado == valor) {
				return true;
			} else {
				pet = pet.proximo;
			}
		}
		return false;
		
	}
	
	public void removefirst() throws Exception {
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		zero = zero.proximo;
	}
	
	public void removelast() throws Exception {
//		apago o nó sem o usuário conseguir pegar nesse dado
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		IntNo penultimo = getno(size()-2);
		penultimo.proximo = null;
	}

	public void remove(int indice) throws Exception {
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		
		int size = size();
		if (indice < 0 || indice > size) {
			throw new Exception("Posição inválida.");
		}
		if (indice == 0) {
			removefirst();
		} else {
//			não preciso adicionar nada para o último pois o esquema é o mesmo
			
			IntNo anterior = getno(indice-1); //posição anterior a mencinada;
			IntNo atual = getno(indice);
			anterior.proximo = atual.proximo; //copio o caminho e o no atual se perde para todo o sempre	
		}
	}

	private IntNo getno(int indice) throws Exception {
		if (indice < 0) {
			throw new Exception("Posição Inválida");
		}
		
		IntNo aux = zero;
		int i = 0;
		while (i < indice) {
			aux = aux.proximo;
			i++;
		}
		return aux;
	}
	
	public int size() {
		int i = 0;
		if (!vazia()) {
			IntNo aux = zero;
			while(aux!= null) {
				i++;
				aux = aux.proximo;
			}
		}
		return i;
	}

	public int get(int indice) throws Exception{
		
		if (vazia()) {
			throw new Exception("Lista vazia.");
		}
		int size = (size() - 1);
		if (indice < 0 || indice > size) {
			throw new Exception("Posição Inválida");
		}
		
		IntNo aux = zero;
		int i = 0;
		while(i < indice) {
			aux = aux.proximo;
			i++;
		}
		return aux.dado;
		
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		try {
			int size = size();
			for (int i = 0 ; i < size ; i++) {
				buffer.append( get(i)+ "	");
				if (i == size - 1) {
					buffer.append("NULL");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	
}
