package com.xantrix.servless.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xantrix.servless.dao.ClienteCrudDao;
import com.xantrix.servless.model.Cliente;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;
  
@Component
@Slf4j
public class DataFunction implements Function<String,Cliente>
{
	@Autowired
	private ClienteCrudDao clienteRepository;

	@Override
	public Cliente apply(String CodFid) 
	{
		log.info("****** Cerchiamo l'Utente " + CodFid +  "*******");
		
		return clienteRepository.SelClienteByCode(CodFid);
	}
}
