package br.com.gama.contacorrente.controllers;

import java.net.URI;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gama.contacorrente.dto.ResponseDto;
import br.com.gama.contacorrente.factories.ResponseEntityFactory;
import br.com.gama.contacorrente.forms.ExtratoContaCorrenteForm;
import br.com.gama.contacorrente.forms.OperacaoForm;
import br.com.gama.contacorrente.services.OperacaoService;

@RestController
@RequestMapping("/operacao")
public class OperacaoController {

	@Autowired
	private OperacaoService service;
	
	//TODO: fazer o deposito
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> add(@RequestBody OperacaoForm form, UriComponentsBuilder uribuilder) {
		
		try {
			
			var dto = service.add(form);
			
			URI uri = uribuilder.path("/operacao/{id}").buildAndExpand(dto.getId()).toUri();
			
			return ResponseEntity.created(uri).body(dto);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return ResponseEntityFactory.Create(e);
		}
	}
	
	
	//TODO: retornar todas histórico de operações da conta corrente
	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findExtradoPorContaCorrente(@RequestBody ExtratoContaCorrenteForm form){
		var result = service.findExtratoByContaCorrenteId(form.getContaCorrenteId());
		
		return ResponseEntityFactory.Create(result);
	}
	
	
	//TODO: retornar a operação por id
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity findById(@PathVariable UUID id){
		
		return ResponseEntityFactory.Create(service.findById(id));
	}
	
}
