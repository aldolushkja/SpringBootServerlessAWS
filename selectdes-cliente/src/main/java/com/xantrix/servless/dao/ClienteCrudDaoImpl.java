package com.xantrix.servless.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.xantrix.servless.model.Cliente;
 

@Repository
public class ClienteCrudDaoImpl implements ClienteCrudDao
{
	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	@Override
	public List<Cliente> SelClientiByDes(String Filter) 
	{
		 
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		
        eav.put(":par1", new AttributeValue().withS(Filter));
       
        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                //.withFilterExpression("begins_with(nominativo, :par1)")
                .withFilterExpression("contains(nominativo, :par1)")
                .withExpressionAttributeValues(eav);
        
        List<Cliente> clienti = dynamoDBMapper.scan(Cliente.class, scanExpression);
        
		return clienti;
	}

	
	

}
