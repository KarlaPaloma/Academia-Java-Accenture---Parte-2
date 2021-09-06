package dados;

import negocio.Pessoa;

public class RepositorioPessoasArray {

	private Pessoa[] pessoa;
	private int indice;
	
	public RepositorioPessoasArray(int tamanho){
		indice = 0;
		pessoa = new Pessoa[tamanho];
	}
	
	public void inserir(Pessoa a) {
		pessoa[indice] = a;
		indice = indice + 1;
	}
	
	public Pessoa procurar(String numCPF) {
		Pessoa procurado = null;
		for(int i=0; i<indice; i++) {
			Pessoa aux = this.pessoa[i];
			if(aux.getCpf().equals(numCPF)) {
				procurado = aux;
			}
		}
		return procurado;
}
	public void remover(String numCPF) {
		for(int i=0; i<indice; i++) {
			Pessoa aux = this.pessoa[i];
		    if(aux.getCpf().equals(numCPF)) {
		    this.pessoa[i] = this.pessoa[indice -1];
		    this.pessoa[indice - 1] = null;
		    indice = indice - 1;
	 }
		
	}
}
}

