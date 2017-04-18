package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private String nombre = "";
	private String apaterno = "";
	private String amaterno = "";
	private int edad;
	private int idBanco;
	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}
	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	/**
	 * @return the apaterno
	 */
	public String getApaterno() {
		return apaterno;
	}
	/**
	 * @param apaterno the apaterno to set
	 */
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	/**
	 * @return the amaterno
	 */
	public String getAmaterno() {
		return amaterno;
	}
	/**
	 * @param amaterno the amaterno to set
	 */
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
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

}
