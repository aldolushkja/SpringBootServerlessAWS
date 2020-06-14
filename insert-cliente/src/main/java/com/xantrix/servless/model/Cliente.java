package com.xantrix.servless.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "clienti")
public class Cliente  implements Serializable
{
	private static final long serialVersionUID = -5218830053574102575L;
	
	/*
	@DynamoDBHashKey(attributeName = "Id")
	@DynamoDBAutoGeneratedKey
	private String id;
	*/
	
	//@DynamoDBRangeKey(attributeName = "userId")
	@DynamoDBHashKey(attributeName = "userId")
	private String codfid;
	
	@DynamoDBAttribute(attributeName = "nominativo")
	private String nominativo;
	
	@DynamoDBAttribute(attributeName = "indirizzo")
	private String indirizzo;
	
	@DynamoDBAttribute(attributeName = "comune")
	private String comune;
	
	@DynamoDBAttribute(attributeName = "cap")
	private String cap;
	
	@DynamoDBAttribute(attributeName = "prov")
	private String prov;
	
	@DynamoDBAttribute(attributeName = "telefono")
	private String telefono;
	
	@DynamoDBAttribute(attributeName = "mail")
	private String mail;
	
	@DynamoDBAttribute(attributeName = "attivo")
	private boolean attivo;
	
	@DynamoDBAttribute(attributeName = "datacreazione")
	private String datacreazione;
	
	@DynamoDBAttribute(attributeName = "cards")
	private Cards cards;

}
