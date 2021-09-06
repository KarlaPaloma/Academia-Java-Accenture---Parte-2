package dados;

import java.sql.*;
import java.util.*;

import negocio.Aluno;
import negocio.Curso;

public class AlunoDAO {
	private Connection con = null;

	public AlunoDAO() {	
		this.con = new ConexaoFactory().getConnection();		
	}

	public void adiciona(Aluno aluno) {
		
		String sql = "INSERT INTO aluno(nome, cpf_aluno, idade, cod_curso, nome_curso) VALUES(?,?,?,?,?)";
		System.out.println(sql);

		try {
			PreparedStatement stmt = con.prepareStatement(sql);		
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getCpf());
			stmt.setDouble(3, aluno.getIdade());
			stmt.setString(4, aluno.getCurso().getCodigo());
			stmt.setString(5, aluno.getCurso().getNome());

			stmt.execute();
			stmt.close();

			System.out.println("Gravado!");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Aluno> getLista() {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		String sql = "SELECT * FROM aluno";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Curso curso = new Curso(rs.getString("cod_curso"), rs.getString("nome_curso"));
				Aluno aluno = new Aluno(rs.getString("nome"), rs.getString("cpf_aluno"), rs.getInt("idade"), curso);
				aluno.setCurso(curso);
				alunos.add(aluno);
			}
			
			rs.close();
			stmt.close();
			return alunos;
		} catch (SQLException e) {			
			throw new RuntimeException(e);
		}		
	}	
}
