package com.xantrix.servless.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.xantrix.servless.model.Cliente;
  

@Repository
public class ClienteCrudDaoImpl implements ClienteCrudDao
{
	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	

	@Override
	public String DelCliente(String CodFid) 
	{
		String retVal = "";
		
		Cliente cliente = dynamoDBMapper.load(Cliente.class, CodFid);
		
		if (cliente != null)
		{
			dynamoDBMapper.delete(cliente);
			retVal = "Eliminazione eseguita con successo!";
		}
		else
		{
			retVal = "Errore: il cliente con codice " + CodFid + " non è presente in anagrafica!";
		}
		
		return retVal;
	}

	
	

}
