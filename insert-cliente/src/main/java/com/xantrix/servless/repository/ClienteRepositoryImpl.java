package com.xantrix.servless.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.xantrix.servless.model.Cliente;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository
{
	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	@Override
	public Cliente insCliente(Cliente cliente)
	{
		dynamoDBMapper.save(cliente);
		
		return cliente;
	}

}
