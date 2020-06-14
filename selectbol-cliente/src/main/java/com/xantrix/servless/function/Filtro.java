package com.xantrix.servless.function;

import java.io.Serializable;

import lombok.Data;

@Data
public class Filtro implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	String tipo;
	String bollini;

}
