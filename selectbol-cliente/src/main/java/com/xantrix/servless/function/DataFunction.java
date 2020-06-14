package com.xantrix.servless.function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xantrix.servless.dao.ClienteCrudDao;
import com.xantrix.servless.model.Cliente;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Function;
 
@Component
@Slf4j
public class DataFunction implements Function<Filtro,List<Cliente>>
{
	@Autowired
	private ClienteCrudDao clienteRepository;

	@Override
	public List<Cliente> apply(Filtro filtro) 
	{
		log.info("****** Cerchiamo i clienti con monte bollini di " + filtro.getBollini() +  
					" e tipo " + filtro.getTipo() + " *******");
		
		return clienteRepository.SelClientiByBoll(filtro);
	}
}
