package br.com.gama.contacorrente.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ResponseDto {
	
	private LocalDateTime dataHora = LocalDateTime.now();
	private HttpStatus httpStatus;
	private String mensagem;
	private Object dados;
	
	public ResponseDto(HttpStatus httpStatus, String mensagem, Object dados) {
		this.httpStatus = httpStatus;
		this.mensagem = mensagem;
		this.dados = dados;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Object getDados() {
		return dados;
	}
	
	
}
