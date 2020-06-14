package com.xantrix.servless.function;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xantrix.servless.model.Cliente;
import com.xantrix.servless.repository.ClienteRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataFunction implements Function<Cliente, InfoMsg> {
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public InfoMsg apply(Cliente cliente) {
		String msg = "";

		InfoMsg retVal = new InfoMsg();

		log.info("****** Inserimento Dati Cliente *******");

		if (cliente.getCodfid() == "") {
			msg = "Errore: Inserire il codice Fidelity";
		} else if (cliente.getNominativo().length() < 5 || cliente.getNominativo().length() > 50) {
			msg = "Errore: Il nominativo deve essere compreso fra 5 e 50 caratteri";
		} else {
			String codFid = clienteRepository.insCliente(cliente).getCodfid();

			if (codFid.length() > 0) {
				msg = "Inserimento dati cliente " + codFid + " eseguita con successo!";
			}
		}

		log.info(msg);

		retVal.setMessage(msg);

		return retVal;
	}

}
