package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class BancoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBanco;
	private String nombre;

	public int getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "BancoDTO [idBanco=" + idBanco + ", nombre=" + nombre + "]";
	}
}
