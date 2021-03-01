package br.com.gama.contacorrente.factories;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.gama.contacorrente.dto.ResponseDto;

public class ResponseEntityFactory {
	
	public static ResponseEntity<?> Create(ResponseDto dto){
		
		return new ResponseEntity<>(dto, dto.getHttpStatus());
	}
	
	public static ResponseEntity<?> Create(Object obj){
		
		if(obj == null) return ResponseEntity.notFound().build(); 
		
		var dto = new ResponseDto(HttpStatus.OK, null, obj);
		
		return new ResponseEntity<>(dto, dto.getHttpStatus());
	}
	
	public static ResponseEntity<?> Create(Exception e){
		
		var dto = new ResponseDto(HttpStatus.BAD_REQUEST, e.getMessage(), null);
		
		return new ResponseEntity<>(dto, dto.getHttpStatus());
	}


}
