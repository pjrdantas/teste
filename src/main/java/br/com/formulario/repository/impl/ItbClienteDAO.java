package br.com.formulario.repository.impl;


import java.util.List;

import br.com.formulario.model.dto.TbClienteDTO;







public interface ItbClienteDAO {
	
    /**
     * INCLUIR CLIENTE
     * @param tbClienteDTO
     * @throws Exception
     * @throws Throwable
     */
    void addTbClienteDTO(TbClienteDTO tbClienteDTO)  throws Exception, Throwable;
    
    /**
     * EDITAR CLIENTE
     * @param tbClienteDTO
     * @throws Exception
     * @throws Throwable
     */
    void updateTbClienteDTO(TbClienteDTO tbClienteDTO)  throws Exception, Throwable;
    
    /**
     * LISTAR TODOS CLIENTES
     * @return
     * @throws Exception
     * @throws Throwable
     */
    List<TbClienteDTO> getAllTbClientes()  throws Exception, Throwable;
    
    /**
     * PESQUISAR CLIENTE POR ID
     * @param id
     * @return
     * @throws Exception
     * @throws Throwable
     */
    TbClienteDTO getTbClienteById(int id)  throws Exception, Throwable;
    
    /**
     * DELETAR CLIENTE POR ID
     * @param id
     * @throws Exception
     * @throws Throwable
     */
    void deleteTbCliente(int id)  throws Exception, Throwable;
    
    
   
}
 