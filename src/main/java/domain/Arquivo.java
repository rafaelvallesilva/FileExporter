package domain;

import java.io.Serializable;

public class Arquivo implements Serializable {

	private String fonte;
	private String modulo;
	private String rotina;
	private String data;
	private String obs;

	public Arquivo(String fonte, String modulo, String rotina,
			String data, String obs) {
		this.fonte = fonte;
		this.modulo = modulo;
		this.rotina = rotina;
		this.data = data;
		this.obs = obs;
	}

	public Arquivo() {
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getRotina() {
		return rotina;
	}

	public void setRotina(String rotina) {
		this.rotina = rotina;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public String toString() {
		return "Arquivo [fonte=" + fonte + ", modulo=" + modulo + ", rotina=" + rotina + ", data=" + data + ", obs="
				+ obs + "]";
	}

}
