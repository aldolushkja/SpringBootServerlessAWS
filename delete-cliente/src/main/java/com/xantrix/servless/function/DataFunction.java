package com.xantrix.servless.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xantrix.servless.dao.ClienteCrudDao;

import lombok.extern.slf4j.Slf4j;
import java.util.function.Function;
 
@Component
@Slf4j
public class DataFunction implements Function<String,String>
{
	@Autowired
	private ClienteCrudDao clienteRepository;

	@Override
	public String apply(String CodFid) 
	{
		log.info("****** Eliminiamo il cliente con codice " + CodFid +  " *******");
		
		return clienteRepository.DelCliente(CodFid);
	}
}
