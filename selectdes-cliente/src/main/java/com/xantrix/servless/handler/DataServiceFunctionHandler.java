package com.xantrix.servless.handler;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.xantrix.servless.model.Cliente;
 
public class DataServiceFunctionHandler extends SpringBootRequestHandler<String, List<Cliente>>
{

}
