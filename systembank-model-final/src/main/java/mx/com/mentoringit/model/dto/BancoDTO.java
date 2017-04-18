package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class BancoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBanco;
	private String nombre;
	/**
	 * @return the idBanco
	 */
	public int getIdBanco() {
		return idBanco;
	}
	/**
	 * @param idBanco the idBanco to set
	 */
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BancoDTO [idBanco=" + idBanco + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
