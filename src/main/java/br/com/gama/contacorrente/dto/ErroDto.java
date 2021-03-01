package br.com.gama.contacorrente.dto;

public class ErroDto {

	private String messagem;

	public ErroDto(String messagem) {
		super();
		this.messagem = messagem;
	}

	public String getMessagem() {
		return messagem;
	}

	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
}
