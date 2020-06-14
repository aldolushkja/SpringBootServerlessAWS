package com.xantrix.servless.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.xantrix.servless.function.InfoMsg;
import com.xantrix.servless.model.Cliente;

public class DataServiceFunctionHandler extends SpringBootRequestHandler<Cliente, InfoMsg>
{

}
