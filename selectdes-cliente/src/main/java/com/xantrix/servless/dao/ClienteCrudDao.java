package com.xantrix.servless.dao;

import java.util.List;

import com.xantrix.servless.model.Cliente;


public interface ClienteCrudDao 
{
	public List<Cliente> SelClientiByDes(String Filter);
	
}
