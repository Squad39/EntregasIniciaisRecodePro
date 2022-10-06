package model;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ApoiadorDAO {
	
	/*** CRUD creat, read, update d delete ***/
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Apoiador ap1) {
		// metodo de salvar

		String sql = "INSERT INTO Apoiador(dataNasc,nome, telefone,tipoDoacao,telContato,email)" + "VALUES(?,?,?,?,?,?)";
		// interrogação será substituida pelos parametros inseridos

		// testa se a conexão ainda não existe
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// criar uma conexao com o banco de dados
			conn = ConnectionFactory.creatConnectiontoMySQL();
			// criamos uma PrepareStatement, para executar uma query

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, ap1.getDataNasc());
			pstm.setString(2, ap1.getNome());
			pstm.setString(3, ap1.getTelefone());
			pstm.setString(4, ap1.getTipoDoacao());
			pstm.setString(5, ap1.getTelContato());
			pstm.setString(6, ap1.getEmail());
			

			// executar a inserção de dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void removebyId(int id_Apoiador) {
		String sql = "DELETE FROM Cliente WHERE Id_ = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_Apoiador);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void update(Apoiador ap1) {
		String sql = "UPDATE Apoaidor SET dataNasc = ?, Nome = ?, telefone = ?, tipoDoacao = ?, telContato = ?" + "WHERE Id_Apoiador = ?";
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, ap1.getDataNasc()); 
			// primeiro parametro (datanasc) da tabela (Apoiador) do banco

			// segundo parametro (nome) da tabela (Apoiador) do banco
			pstm.setString(2, ap1.getNome());

			pstm.setString(3, ap1.getTelefone());
			// terceiro parametro (tipoDoacao) da tabela (Apoiador) do banco

			pstm.setString(4, ap1.getTipoDoacao());
			// quatro parametro (tipoDoacao) da tabela (Apoiador) do banco

			pstm.setString(5, ap1.getTelContato());
			// quinto parametro (telContato) da tabela (Apoiador) do banco

			pstm.setString(6, ap1.getEmail());
			// sexto parametro (email) da tabela (Apoiador) do banco
		
			// para que não seja alterado todas as linhas da tabela
			//pstm.setInt(7, ap1.getId_Apoiador());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @return
	 */
	public  List<Apoiador> getApoiador() {

		String sql = "SELECT * FROM Apoiador";

		List<Apoiador> apoiadorLista = new ArrayList<Apoiador>();
		
		// classe que vai recuperar e mostrar os dados do banco Apoiador
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			// enquanto houver dados no banco faça

			while (rset.next()) {
				Apoiador ap1 = new Apoiador();

				// recupera o dataNasc e atribui nesse o objeto
				ap1.setDataNasc(rset.getString("dataNasc"));
				
				// recupera o nome do banco e atribui ao objeto
				ap1.setNome(rset.getString("nome"));
				
				//recupera o telefone e atribui ao objeto 
				ap1.setTelefone(rset.getString("telefone"));
				
				// recupera o Id do banco e atribui ao objeto
				ap1.setTipoDoacao(rset.getString("tipoDoacao"));
				
				// recupera o Id do banco e atribui ao objeto
				ap1.setTipoDoacao(rset.getString("tipoDoacao"));
				
				// recupera o Id do banco e atribui ao objeto
				ap1.setTelContato(rset.getString("telContato"));
				
				//recupera o email e atribui ao objeto 
				ap1.setEmail(rset.getString("email"));

				// recupera o Id do banco e atribui ao objeto
				ap1.setId_Apoiador(rset.getInt("id_Apoiador"));

				
				// Adiciono o Cliente recuperado, a lista de clientes
				apoiadorLista.add(ap1);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fechar as conexoes
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return apoiadorLista;
 
	}
	
	public Apoiador buscaById(int Id_Apoiador) {
		String sql = "SELECT * FROM Apoiador WHERE id IN (?);";
		ResultSet rset = null;
		Apoiador ap1 = new Apoiador();

		try {
			conn = ConnectionFactory.creatConnectiontoMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, Id_Apoiador);

			rset = pstm.executeQuery();

			rset.next();
			ap1.setNome(rset.getString("Nome"));
			ap1.setDataNasc(rset.getString("dataNasc"));
			ap1.setTelContato(rset.getString("telefone"));
			ap1.setTipoDoacao(rset.getString("tipoDoacao"));
			ap1.setEmail(rset.getString("email"));
			ap1.setTelContato(rset.getString("telContato"));



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return ap1;
	}

}

	

