package mx.com.mentoringit.model.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idUsuario;
    private String nombre;
	private String apaterno;
	private String amaterno;
	private String usuario;
	private String password;
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
