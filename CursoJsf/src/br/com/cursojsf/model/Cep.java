package br.com.cursojsf.model;

public class Cep {

	private String regiao;
	private String sufixo;

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	@Override
	public String toString() {
		return regiao + "-" + sufixo;
	}

}