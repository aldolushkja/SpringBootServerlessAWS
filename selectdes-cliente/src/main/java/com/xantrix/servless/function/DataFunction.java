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
public class DataFunction implements Function<String,List<Cliente>>
{
	@Autowired
	private ClienteCrudDao clienteRepository;

	@Override
	public List<Cliente> apply(String Filter) 
	{
		log.info("****** Cerchiamo i clienti con nominativo " + Filter +  "*******");
		
		return clienteRepository.SelClientiByDes(Filter);
	}
}
