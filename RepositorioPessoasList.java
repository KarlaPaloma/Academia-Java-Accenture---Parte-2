package dados;

import java.util.*;

import negocio.Pessoa;
import negocio.RemoveException;
import negocio.RepositorioPessoas;

public class RepositorioPessoasList implements RepositorioPessoas {
	
	private List<Pessoa>pessoa;
	
	public RepositorioPessoasList() {
		pessoa = new ArrayList<Pessoa>();
	}
	
	public void inserir(Pessoa a) {
		pessoa.add(a);
	}

	public Pessoa procurar(String numCPF) {
		Pessoa procurada = null;
		for(Pessoa pessoa1: pessoa) {
			if(pessoa1.getCpf().equals(numCPF))
				procurada=pessoa1;
			
		}
		return procurada;
	}
	
	public void remover(String numCPF) throws RemoveException {
		int posicao = -1;
		boolean pessoaEncontrada = false;
		for(Pessoa pessoa1: pessoa) {
			if(pessoa1.getCpf().equals(numCPF)) {
				posicao=pessoa.indexOf(pessoa1);
				pessoaEncontrada =  true;
				break;
			}	
		}
		if(posicao != -1)
			pessoa.remove(posicao);
		
		if(pessoaEncontrada == false) {
			throw new RemoveException();
		}
	}
	
	public List<Pessoa> listarPessoas(){
		return this.pessoa;
	}

}
