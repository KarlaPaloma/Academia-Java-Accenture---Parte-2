package dados;

import java.sql.*;
import java.util.*;

import negocio.Pessoa;

public class PessoaDAO {
	private Connection con = null;

	public PessoaDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	public void adiciona(Pessoa pessoa) {
		
		String sql = "INSERT INTO pessoa(nome, cpf, idade) VALUES(?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getCpf());
			stmt.setDouble(3, pessoa.getIdade());

			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pessoa> getLista() {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		String sql = "";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Pessoa pessoa = new Pessoa(rs.getString("nome"), rs.getString("cpf"), rs.getInt("idade"));
				
				pessoas.add(pessoa);
			}
			
			rs.close();
			stmt.close();
			return pessoas;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}	
}
