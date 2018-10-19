package iemev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import iemev.models.FichaDeAtendimento;
import iemev.utils.bd.ConnectionFactory;

public class FichaAtendimentoDAO {
	
	public FichaDeAtendimento selecionarPorId(int id) {
		Connection con = ConnectionFactory.getConnection();
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sqlSelect = "SELECT * FROM T_FICHADEATENDIMENTO WHERE numeroFicha =  ? ;";
		try {
			
			PreparedStatement stm = con.prepareStatement(sqlSelect);
			stm.setInt(1, id);
			ResultSet rs = stm.executeQuery();
			
			int idFicha = Integer.parseInt(rs.getString("numeroFicha"));
			Date dataAbertura = new Date();
			Date dataFechamento = new Date();
			try {
				dataAbertura = dataFormat.parse(rs.getString("dataAbertura"));
			}catch(Exception e){
				e.printStackTrace();
			} 
			try {
				dataFechamento = dataFormat.parse(rs.getString("dataFechamento"));	
			}catch(Exception e){
				e.printStackTrace();
			}
			
			int idAnimal = Integer.parseInt(rs.getString("idAnimal"));
			int idAtendAbriu = Integer.parseInt(rs.getString("idAtendenteAbriuFicha"));
			int idAtendFechou = Integer.parseInt(rs.getString("idAtendenteFechouFicha"));
			String status = rs.getString("statusFicha");
			FichaDeAtendimento ficha = new FichaDeAtendimento(idFicha, dataAbertura, dataFechamento, idAnimal, idAtendAbriu, idAtendFechou, status);
			
			stm.close();
			con.close();
			return ficha;
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<JsonObject> buscar(String palavra) {
		Connection con = ConnectionFactory.getConnection();
		//Criar uma maneira de retornar um json com {nome: , cpf: }
		try { 
			String sqlSelect = "SELECT NOME, CPF FROM T_PESSOA WHERE NOME LIKE '%"+palavra+"%';";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlSelect);
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>(); 
			while(rs.next()) {
				JsonObject usuario = new JsonObject();
				try {
					usuario.addProperty("nome", rs.getString("NOME"));
					usuario.addProperty("cpf", rs.getString("CPF")); 
					retorno.add(usuario);
				} catch (JsonIOException je) {
					je.printStackTrace();
				}
			}
			
			con.close();
			return retorno;
		} catch(SQLException se) {
			se.printStackTrace();
		}
		return null;
	}
	public ArrayList<JsonObject> buscarAnimal(long id){
		Connection con = ConnectionFactory.getConnection();
		try {
			String slqAnimalId = "SELECT * FROM T_ANIMAL A INNER JOIN T_PESSOA P ON A.cpfCliente = P.cpf WHERE P.CPF = "+id+";";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(slqAnimalId);
			ArrayList<JsonObject> retorno = new ArrayList<JsonObject>();
			while(rs.next()) {
				JsonObject animal = new JsonObject();
				try {
					animal.addProperty("id", rs.getString("idAnimal"));
					animal.addProperty("nome", rs.getString("nomeAnimal"));
//					animal.addProperty("sexo", rs.getString("sexo"));
//					animal.addProperty("data", rs.getString("dataDeNascimentoAnimal"));
//					animal.addProperty("especie", rs.getString("especie"));
//					animal.addProperty("porte", rs.getString("porte"));
//					animal.addProperty("raca", rs.getString("raca"));
//					animal.addProperty("pelagem", rs.getString("pelagem"));
//					animal.addProperty("temperamento", rs.getString("temperamento"));
//					animal.addProperty("cpf", rs.getString("cpfCliente"));
//					animal.addProperty("idAtendente", rs.getString("idAtendenteDeCadastramento"));
					retorno.add(animal);
				} catch(JsonIOException je ) {
					je.printStackTrace();
				}
			}
			rs.close();
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int inserir(FichaDeAtendimento ficha) {
		Connection con = ConnectionFactory.getConnection();
		int retorno = 0;
		ResultSet rs = null;
		String sqlFicha = "INSERT INTO T_FICHADEATENDIMENTO ( idAnimal, idAtendenteAbriuFicha, statusFicha) VALUES (?,?,?);";
		try {
			PreparedStatement stm = con.prepareStatement(sqlFicha, Statement.RETURN_GENERATED_KEYS);
			stm.setInt(1, ficha.getIdAnimal());
			stm.setInt(2, ficha.getIdAtendenteAbriuFicha());
			stm.setString(3, ficha.getStatusAtual().stateString());
			int linha = stm.executeUpdate();
			if(linha == 1 ) {
				rs = stm.getGeneratedKeys();
				if(rs.next()) {
					retorno = rs.getInt(1);	
				}
			}	
			stm.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return retorno;
	}
	
	public int deletarFicha(int id_ficha ) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "DELETE FROM T_FICHADEATENDIMENTO WHERE numeroFicha = ?";
		ResultSet rs = null;
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id_ficha);
			retorno = stm.executeUpdate();
			stm.close();
			con.close();
			return retorno;
		} catch (SQLException se ) {
			se.printStackTrace();
		}
		return retorno;
	}
	
	public ArrayList<FichaDeAtendimento> fichasUsuario(long id){
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM ((T_FICHADEATENDIMENTO F INNER JOIN T_ANIMAL A ON F.idAnimal = A.idAnimal) INNER JOIN T_CLIENTE C ON A.cpfCliente = C.cpfUsuario) WHERE C.cpfUsuario = ?";
		ArrayList<FichaDeAtendimento> retorno = new ArrayList<FichaDeAtendimento>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setLong(1, id);
			rs = stm.executeQuery();
			while(rs.next()) {
				Date data = new Date();
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				try {
					data = dateformat.parse(rs.getString("dataAbertura"));
				}catch(Exception e) {
					e.printStackTrace();
				}
				FichaDeAtendimento ficha = new FichaDeAtendimento();
				ficha.setNumeroFicha(rs.getInt("numeroFicha"));
				ficha.setIdAnimal(rs.getInt("idAnimal"));
				ficha.setDataAbertura(data);
				retorno.add(ficha);
			}
			stm.close();
			rs.close();
			con.close();
		} catch(SQLException se) {
			se.printStackTrace();
		};
		return retorno;
	}
	public List<FichaDeAtendimento> todasFichas(){
		Connection con = ConnectionFactory.getConnection();
		ResultSet rs = null;
		String sql = "SELECT * FROM T_FICHADEATENDIMENTO";
		List<FichaDeAtendimento> retorno = new ArrayList<FichaDeAtendimento>();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while(rs.next()) {
				Date data = new Date();
				try {
					data = dateformat.parse(rs.getString("dataAbertura"));
					FichaDeAtendimento ficha = new FichaDeAtendimento();
					ficha.setDataAbertura(dateformat.parse(rs.getString("dataAbertura")));
					ficha.setDataFechamento(dateformat.parse(rs.getString("dataFechamento")));
					ficha.setNumeroFicha(rs.getInt("numeroFicha"));
					ficha.setIdAnimal(rs.getInt("idAnimal"));
					ficha.setIdAtendenteAbriuFicha(rs.getInt("idAtendenteAbriuFicha"));
					ficha.setIdAtendenteAbriuFicha(rs.getInt("idAtendenteAbriuFicha"));
					if(rs.getString("statusFicha").equals("aberta")) {
						ficha.abrirFicha();;	
					} else {
						ficha.fecharFicha();
					}
					
					retorno.add(ficha);
				} catch(Exception e ) {
					e.printStackTrace();
				}
			}
			rs.close();
			stm.close();
			con.close();
			return retorno;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return retorno;
	}
	public int fecharFicha(int id_ficha) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE T_FICHADEATENDIMENTO SET statusFicha = 'fechada' WHERE numeroFicha = ?";
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id_ficha);
			retorno = stm.executeUpdate();
			stm.close();
			con.close();
			return retorno;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return retorno;
	}
	public int abrirFicha(int id_ficha) {
		Connection con = ConnectionFactory.getConnection();
		String sql = "UPDATE T_FICHADEATENDIMENTO SET statusFicha = 'aberta' WHERE numeroFicha = ?";
		int retorno = 0;
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, id_ficha);
			retorno = stm.executeUpdate();
			stm.close();
			con.close();
			return retorno;
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return retorno;
	}
}
