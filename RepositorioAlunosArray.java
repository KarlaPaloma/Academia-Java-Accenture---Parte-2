package dados;

import negocio.Aluno;

public class RepositorioAlunosArray {

	private Aluno[] aluno;
	private int indice;
	
	public RepositorioAlunosArray(int tamanho){
		indice = 0;
		aluno = new Aluno[tamanho];
	}
	
	public void inserir(Aluno a) {
		aluno[indice] = a;
		indice = indice + 1;
	}
	
	public Aluno procurar(String numCPF) {
		Aluno procurado = null;
		for(int i=0; i<indice; i++) {
			Aluno aux = this.aluno[i];
			if(aux.getCpf().equals(numCPF)) {
				procurado = aux;
			}
		}
		return procurado;
	}

	public void remover(String numCPF) {
		for(int i=0; i<indice; i++) {
		 Aluno aux = this.aluno[i];
		 if(aux.getCpf().equals(numCPF)) {
			 this.aluno[i] = this.aluno[indice -1];
			 this.aluno[indice - 1] = null;
			 indice = indice - 1;
		 }
			
		}
	}
}
