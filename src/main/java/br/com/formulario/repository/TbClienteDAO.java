package br.com.formulario.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.formulario.model.dto.TbClienteDTO;
import br.com.formulario.repository.impl.ItbClienteDAO;



@Transactional
@Repository
public class TbClienteDAO implements ItbClienteDAO {
	
	@Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

	
	/**
	 * INCLUI CLIENTE PESSOA FISICA 
	 */
	@Override
	public void addTbClienteDTO(TbClienteDTO tbClienteDTO) throws Exception, Throwable {
		
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(	"  INSERT INTO ");
		sql.append( "  tb_cliente (");
		sql.append( "  id, ");		
		sql.append( "  tb_cliente_limite_credito, ");
		sql.append( "  tb_cliente_nome, ");
		sql.append( "  tb_cliente_risco, ");
		sql.append( "  tb_cliente_taxa_juro) ");
		sql.append( "  values (:id, :tbClienteLimiteCredito, :tbClienteNome, :tbClienteRisco, :tbClienteTaxaJuro)");

		SqlParameterSource params = new MapSqlParameterSource()
				.addValue("id", tbClienteDTO.getId())				
				.addValue("tbClienteLimiteCredito", tbClienteDTO.getClienteLimiteCredito())
				.addValue("tbClienteNome", tbClienteDTO.getClienteNome())
				.addValue("tbClienteRisco", tbClienteDTO.getClienteRisco())
				.addValue("tbTaxaJuro", tbClienteDTO.getClienteTaxaJuro());
		
		try{
	    	 jdbcTemplate.update(sql.toString(), params);	         
	     }catch (Exception e){
	    	
	    	 System.out.println("----------------- ERRO NO INSERT DO CLIENTE -------------------------------" + e.toString());
	        
	     }
	}

	
	/**
	 * UPDATE DO CLIENTE
	 */
	@Override
	public void updateTbClienteDTO(TbClienteDTO tbClienteDTO) throws Exception, Throwable {
		

		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" UPDATE tb_cliente ");
		sql.append(" SET  ");
		sql.append(" tb_cliente_limite_credito = :tbClienteLimiteCredito, ");
		sql.append(" tb_cliente_nome = :tbClienteNome, ");
		sql.append(" tb_cliente_risco = :tbClienteRisco, ");
		sql.append(" tb_taxa_juro_id = :tbTaxaJuro ");
		sql.append(" WHERE id = :id");
		
		SqlParameterSource params = new MapSqlParameterSource()
							
				.addValue("tbClienteLimiteCredito", tbClienteDTO.getClienteLimiteCredito())
				.addValue("tbClienteNome", tbClienteDTO.getClienteNome())
				.addValue("tbClienteRisco", tbClienteDTO.getClienteRisco())
				.addValue("tbTaxaJuro", tbClienteDTO.getClienteTaxaJuro());	
		
		try{
	    	 jdbcTemplate.update(sql.toString(), params);
	         
	     }catch (Exception e){
	    	 System.out.println("----------------- ERRO NO UPDATE DO CLIENTE -------------------------------" + e.toString());
	        
	     }	
	}

	
	/**
	 *  PREPARANDO REGISTRO DO CLIENTE
	 */
	final static StringBuilder sqlSelectPrincipal = new StringBuilder().append(
			"  SELECT DISTINCT ")
			.append("  id")
			.append("  ,tb_cliente_limite_credito")
			.append("  ,tb_cliente_nome")
			.append("  ,tb_cliente_risco")
			.append("  ,tb_cliente_taxa_juro")
			.append("  FROM tb_cliente ");
	
	
	
	
	/**
	 * LISTAR CLIENTE
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	private List<TbClienteDTO> devolveListaObjetos(StringBuilder sql, SqlParameterSource params)  throws Exception, Throwable  {
		return jdbcTemplate.query(sql.toString(), params, (rs, i) -> {
		
			TbClienteDTO tbClienteDTO = new TbClienteDTO();

			tbClienteDTO.setId(rs.getInt("id"));
			tbClienteDTO.setClienteLimiteCredito(rs.getBigDecimal("tb_cliente_limite_credito"));
			tbClienteDTO.setClienteNome(rs.getString("tb_cliente_nome"));
			tbClienteDTO.setClienteRisco(rs.getString("tb_cliente_risco"));
			tbClienteDTO.setClienteTaxaJuro(rs.getString("tb_cliente_taxa_juro"));
				
	return tbClienteDTO;
	 
		});
	}
		
	
	/**
	 * LISTAR CLIENTES
	 */
	@Override
	public List<TbClienteDTO> getAllTbClientes() throws Exception, Throwable {
		
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal)		
		.append(" order by tb_cliente_nome ");
		
		return devolveListaObjetos(sql, null);
	}
	
	
	
	
	
	
	
	/**
	 * CONSULTA POR ID CLIENTE
	 * @param sql
	 * @param params
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	private TbClienteDTO devolveObjeto(StringBuilder sql, SqlParameterSource params)  throws Exception, Throwable  {
		return jdbcTemplate.queryForObject(sql.toString(), params, (rs, i) -> {
			
			
			TbClienteDTO tbClienteDTO = new TbClienteDTO();

			tbClienteDTO.setId(rs.getInt("id"));
			tbClienteDTO.setClienteLimiteCredito(rs.getBigDecimal("tb_cliente_limite_credito"));
			tbClienteDTO.setClienteNome(rs.getString("tb_cliente_nome"));
			tbClienteDTO.setClienteRisco(rs.getString("tb_cliente_risco"));
			tbClienteDTO.setClienteTaxaJuro(rs.getString("tb_cliente_taxa_juro"));
						
			return tbClienteDTO;

		});
	}
			
	/**
	 * CONSULTAR CLIENTE
	 */
	@Override
	public TbClienteDTO getTbClienteById(int id) throws Exception, Throwable {
		
		StringBuilder sql = new StringBuilder(sqlSelectPrincipal);		
		sql.append(" WHERE id = :id ");
		SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);
		
		return devolveObjeto(sql, params);
	}

	
	
	
	
	/**
	 * DELETA CLIENTE POR ID
	 */
	@Override
	public void deleteTbCliente(int id) throws Exception, Throwable {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" DELETE FROM ");
	    sql.append(" tb_cliente "); 
	    sql.append(" WHERE id = :id");	        

	     SqlParameterSource params = new MapSqlParameterSource().addValue("id", id);

			try{
		    	 jdbcTemplate.update(sql.toString(), params);		         
		     }catch (Exception e){
		    	 System.out.println("----------------- ERRO NO DELETE DO CLIENTE -------------------------------" + e.toString());
		        
		     }		
	}
	
	

}
