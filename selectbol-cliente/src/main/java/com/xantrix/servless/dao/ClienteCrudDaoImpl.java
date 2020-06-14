package com.xantrix.servless.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.xantrix.servless.function.DataFunction;
import com.xantrix.servless.function.Filtro;
import com.xantrix.servless.model.Cliente;

import lombok.extern.slf4j.Slf4j;

@Repository
//@Slf4j
public class ClienteCrudDaoImpl implements ClienteCrudDao {
	@Autowired
	private DynamoDBMapper dynamoDBMapper;

	@Override
	public List<Cliente> SelClientiByBoll(Filtro filtro) {

		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":par1", new AttributeValue().withN(filtro.getBollini()));

		String Tipo = filtro.getTipo();
		String FilterText = "";

		if (Tipo.equals("gt")) {
			FilterText = "cards.bollini > :par1";
		} else if (Tipo.equals("lt")) {
			FilterText = "cards.bollini < :par1";

		} else if (Tipo.equals("gte")) {
			FilterText = "cards.bollini >= :par1";

		} else if (Tipo.equals("lte")) {
			FilterText = "cards.bollini <= :par1";

		} else {
			FilterText = "cards.bollini = :par1";
		}

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression().withFilterExpression(FilterText)
				.withExpressionAttributeValues(eav);

		List<Cliente> clienti = dynamoDBMapper.scan(Cliente.class, scanExpression);

		return clienti;
	}

}
