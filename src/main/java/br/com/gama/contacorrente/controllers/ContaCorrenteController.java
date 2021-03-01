package br.com.gama.contacorrente.controllers;

import java.net.URI;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gama.contacorrente.dto.ContaCorrenteDto;
import br.com.gama.contacorrente.dto.ErroDto;
import br.com.gama.contacorrente.dto.ResponseDto;
import br.com.gama.contacorrente.forms.ContaCorrenteForm;
import br.com.gama.contacorrente.services.ContaCorrenteService;

@RestController
@RequestMapping("/contas-corrente")
public class ContaCorrenteController {

	@Autowired
	private ContaCorrenteService service;
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<ContaCorrenteDto> add(@RequestBody ContaCorrenteForm form, UriComponentsBuilder uribuilder) {
	
		var dto = service.add(form);
		
		if(dto == null) return ResponseEntity.notFound().build();
		
		URI uri = uribuilder.path("/contas-corrente/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ContaCorrenteDto> findById(@PathVariable UUID id){
		
		var dto = service.findById(id);
		
		if(dto == null) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(dto);
	}
	

	
	@DeleteMapping("/{id}")
	@ResponseBody
	@Transactional
	public ResponseEntity<?> delete(@PathVariable UUID id){
		
		try {
			
			service.delete(id);
			
			return ResponseEntity.ok(null);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			var dto = new ResponseDto(HttpStatus.BAD_REQUEST, e.getMessage(), null);
			
			return new ResponseEntity<>(dto, dto.getHttpStatus());
			
		}
	}
}
