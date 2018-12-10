package br.com.formulario.service.impl;

import java.util.List;

import br.com.formulario.model.dto.TbClienteDTO;


public interface ITbClienteService {
	
	/**
	 * 
	 * @param tbClienteDTO
	 * @throws Exception
	 * @throws Throwable
	 */
    void addTbClienteDTO(TbClienteDTO tbClienteDTO)   throws Exception, Throwable;
    
    /**
     * 
     * @param tbClienteDTO
     * @throws Exception
     * @throws Throwable
     */
    void updateTbClienteDTO(TbClienteDTO tbClienteDTO)  throws Exception, Throwable;
    
    /**
     * 
     * @return
     * @throws Exception
     * @throws Throwable
     */
    List<TbClienteDTO> consultar()  throws Exception, Throwable;
    
    /**
     * 
     * @param id
     * @return
     * @throws Exception
     * @throws Throwable
     */
    TbClienteDTO getTbClienteById(int id)  throws Exception, Throwable;
    
    /**
     * 
     * @param id
     * @throws Exception
     * @throws Throwable
     */
    void deleteTbCliente(int id)  throws Exception, Throwable;
}
