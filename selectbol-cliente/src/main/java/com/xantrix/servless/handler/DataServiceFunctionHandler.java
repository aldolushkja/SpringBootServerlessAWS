package com.xantrix.servless.handler;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.xantrix.servless.function.Filtro;
import com.xantrix.servless.model.Cliente;
 
public class DataServiceFunctionHandler extends SpringBootRequestHandler<Filtro, List<Cliente>>
{

}
