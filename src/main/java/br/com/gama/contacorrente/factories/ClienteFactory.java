package br.com.gama.contacorrente.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.gama.contacorrente.entidades.Cliente;
import br.com.gama.contacorrente.entidades.ContaCorrente;
import br.com.gama.contacorrente.entidades.Login;
import br.com.gama.contacorrente.forms.ClienteForm;

public class ClienteFactory {

	public static Cliente Create(ClienteForm form) {

		Login login = new Login(form.getUsuario(), form.getSenha());

		ContaCorrente cc = new ContaCorrente(0.0, null);
		
		List<ContaCorrente> list = new ArrayList<ContaCorrente>();
		
		list.add(cc);
		
		return new Cliente(form.getNome(), form.getSobrenome(), form.getTelefone(), form.getEmail(), login, list);
	}

	public static List<Cliente> Create(List<ClienteForm> forms) {

		return forms.stream().map(ClienteFactory::Create).collect(Collectors.toList());
	}

}
