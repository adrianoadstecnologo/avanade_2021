package br.com.gama.contacorrente.controllers;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gama.contacorrente.dto.ClienteDto;
import br.com.gama.contacorrente.forms.ClienteForm;
import br.com.gama.contacorrente.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

//	@Autowired
//	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<ClienteDto>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@PostMapping
	@ResponseBody
	@Transactional
	public ResponseEntity<ClienteDto> addCliente(@RequestBody ClienteForm form, UriComponentsBuilder uribuilder){

		var dto = service.add(form);
		
		URI uri = uribuilder.path("/clientes/{id}").buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ClienteDto> findById(@PathVariable UUID id){
	
		var dto = service.findById(id);
		
		if(dto == null) return ResponseEntity.notFound().build();
			
		return ResponseEntity.ok(dto);
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> update(@PathVariable UUID id,  @RequestBody ClienteForm form){
		
		var result = service.update(id, form);
		
		if(result == null) return ResponseEntity.notFound().build();
			
		return ResponseEntity.ok(result); 
	}
	
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable UUID id) {

		if(service.delete(id))
			return ResponseEntity.ok(null);
		
		return ResponseEntity.notFound().build();
		
	}
	
}
