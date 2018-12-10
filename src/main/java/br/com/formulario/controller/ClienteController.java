package br.com.formulario.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.formulario.model.dto.TbClienteDTO;
import br.com.formulario.response.ResponseModel;
import br.com.formulario.service.impl.ITbClienteService;




@CrossOrigin(origins  = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ClienteController {
	
	
	
	@Autowired
	private ITbClienteService clienteService;


	/**
	 * 
	 * @param tbClienteDTO
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody TbClienteDTO tbClienteDTO)  throws Exception, Throwable {      

		try {			 
			if (tbClienteDTO.getClienteLimiteCredito() != null && tbClienteDTO.getClienteNome().isEmpty() && tbClienteDTO.getClienteRisco().isEmpty() && tbClienteDTO.getClienteTaxaJuro().isEmpty()) {
				if (tbClienteDTO.getClienteRisco().contains("B")) {
					tbClienteDTO.setClienteTaxaJuro("10%");					
				}
				if (tbClienteDTO.getClienteRisco().contains("C")) {
					tbClienteDTO.setClienteTaxaJuro("20%");					
				}
				this.clienteService.addTbClienteDTO(tbClienteDTO); 
				return new ResponseModel(1,"Cliente salvo com sucesso!");
			} else {
				return new ResponseModel(0,"ATENÇÃO!!! TODOS OC CAMPOS PRECISAM ESTAR PREENCHIDOS");
			}
			 
		}catch(Exception e) {
			return new ResponseModel(0,e.getMessage());			
		}
		
	}
 
	
	/**
	 * 
	 * @param tbClienteDTO
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody TbClienteDTO tbClienteDTO)  throws Exception, Throwable {


		
		try {			 
			if (tbClienteDTO.getClienteLimiteCredito() != null && tbClienteDTO.getClienteNome().isEmpty() && tbClienteDTO.getClienteRisco().isEmpty() && tbClienteDTO.getClienteTaxaJuro().isEmpty()) {
				if (tbClienteDTO.getClienteRisco().contains("B")) {
					tbClienteDTO.setClienteTaxaJuro("10%");					
				}
				if (tbClienteDTO.getClienteRisco().contains("C")) {
					tbClienteDTO.setClienteTaxaJuro("20%");					
				}
				this.clienteService.updateTbClienteDTO(tbClienteDTO);		
				return new ResponseModel(1,"Cliente atualizado com sucesso!"); 
			} else {
				return new ResponseModel(0,"ATENÇÃO!!! TODOS OC CAMPOS PRECISAM ESTAR PREENCHIDOS");
			}
			 
			
		}catch(Exception e) { 
			return new ResponseModel(0,e.getMessage());
		}
		
	}
	

	
	/**
	 * 
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/cliente", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<TbClienteDTO> consultar()  throws Exception, Throwable {
				
		return this.clienteService.consultar();			
	}
	
	
	

	/**
	 * 
	 * @param idCliente
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/cliente/{idCliente}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody TbClienteDTO buscar(@PathVariable("idCliente") String idCliente)  throws Exception, Throwable {
		
		int id = Integer.parseInt(idCliente);
		return this.clienteService.getTbClienteById(id);
		
	}
	
	 
	 
	/**
	 * 
	 * @param idCliente
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	@RequestMapping(value="/cliente/{idCliente}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("idCliente") String idCliente)  throws Exception, Throwable {
		
		int id = Integer.parseInt(idCliente);
		 
		try { 
			clienteService.deleteTbCliente(id); 
			return new ResponseModel(1, "Cliente excluido com sucesso!"); 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}	
		 
} 
