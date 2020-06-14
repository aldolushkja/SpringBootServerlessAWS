package com.xantrix.servless.dao;

import java.util.List;

import com.xantrix.servless.function.Filtro;
import com.xantrix.servless.model.Cliente;


public interface ClienteCrudDao 
{
	public List<Cliente> SelClientiByBoll(Filtro filtro);
	
}
