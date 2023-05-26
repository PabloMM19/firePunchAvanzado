package com.hibernate.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "entrenador")
public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idEntrenador")
	private int idEntrenador;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "edad")
	private int edad;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "email")
	private String email;
	@Column(name = "contraseña")
	private String contrasenya;
	@Column(name = "fotoPerfil")
	private String fotoPerfil;

	@OneToMany
	private List<Cliente> clientes;

	public Entrenador() {
		super();
	}

	
	/**
	 * Constructor de la clase Entrenador.
	 *
	 * @param nombre        El nombre del entrenador.
	 * @param apellidos     Los apellidos del entrenador.
	 * @param edad          La edad del entrenador.
	 * @param usuario       El nombre de usuario del entrenador.
	 * @param email         El correo electrónico del entrenador.
	 * @param contraseña    La contraseña del entrenador.
	 * @param fotoPerfil    La ruta de la foto de perfil del entrenador.
	 */
	public Entrenador(String nombre, String apellidos, int edad, String usuario, String email, String contrasenya, String fotoPerfil) {
	    super();  // Llama al constructor de la clase base (posiblemente la clase padre)
	    this.nombre = nombre;  // Asigna el nombre del entrenador al atributo correspondiente
	    this.apellidos = apellidos;  // Asigna los apellidos del entrenador al atributo correspondiente
	    this.edad = edad;  // Asigna la edad del entrenador al atributo correspondiente
	    this.usuario = usuario;  // Asigna el nombre de usuario del entrenador al atributo correspondiente
	    this.email = email;  // Asigna el correo electrónico del entrenador al atributo correspondiente
	    this.contrasenya = contrasenya;  // Asigna la contra del entrenador al atributo correspondiente
	    this.fotoPerfil = fotoPerfil;  // Asigna la ruta de la foto de perfil del entrenador al atributo correspondiente
	}

	/**
	 * Obtiene el ID del entrenador.
	 * 
	 * @return el ID del entrenador
	 */
	public int getIdEntrenador() {
		return idEntrenador;
	}

	/**
	 * Establece un nuevo ID para el entrenador.
	 * 
	 * @param idEntrenador el nuevo ID a establecer
	 */
	public void setIdEntrenador(int idEntrenador) {
		this.idEntrenador = idEntrenador;
	}

	/**
	 * Obtiene el nombre del entrenador.
	 * 
	 * @return el nombre del entrenador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece un nuevo nombre para el entrenador.
	 * 
	 * @param nombre el nuevo nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene los apellidos del entrenador.
	 * 
	 * @return los apellidos del entrenador
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece unos nuevos apellidos para el entrenador.
	 * 
	 * @param apellidos los nuevos apellidos a establecer
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Obtiene la edad del entrenador.
	 * 
	 * @return la edad del entrenador
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Establece una nueva edad para el entrenador.
	 * 
	 * @param edad la nueva edad a establecer
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene el usuario del entrenador.
	 * 
	 * @return el usuario del entrenador
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece un nuevo usuario para el entrenador.
	 * 
	 * @param usuario el nuevo usuario a establecer
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene el correo electrónico del entrenador.
	 * 
	 * @return el correo electrónico del entrenador
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece un nuevo correo electrónico para el entrenador.
	 * 
	 * @param email el nuevo correo electrónico a establecer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la contra del entrenador.
	 * 
	 * @return la contra del entrenador
	 */
	public String getContrasenya() {
		return contrasenya;
	}

	/**
	 * Establece una nueva contraseña para el entrenador.
	 * 
	 * @param contraseña la nueva contraseña a establecer
	 */
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	/**
	 * Obtiene la foto de perfil del entrenador.
	 * 
	 * @return la foto de perfil del entrenador
	 */
	public String getFotoPerfil() {
		return fotoPerfil;
	}

	/**
	 * Establece una nueva foto de perfil para el entrenador.
	 * 
	 * @param fotoPerfil la nueva foto de perfil a establecer
	 */
	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

}
