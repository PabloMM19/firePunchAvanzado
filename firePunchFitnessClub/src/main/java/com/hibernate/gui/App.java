package com.hibernate.gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.formdev.flatlaf.IntelliJTheme;
import com.hibernate.dao.CategoriaDAO;
import com.hibernate.dao.ClienteDAO;
import com.hibernate.dao.EjercicioDAO;
import com.hibernate.dao.EntrenadorDAO;
import com.hibernate.model.Categoria;
import com.hibernate.model.Cliente;
import com.hibernate.model.Ejercicio;
import com.hibernate.model.Entrenador;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;

public class App {

	private JFrame frmFirePunch;
	private JLabel lblHomePage;
	private JTextField tfUsuarioEntrenador;
	private JPasswordField tfContraEntrenador;
	private JTextField tfApellidosRegister;
	private JTextField tfNombreRegister;
	private JTextField tfEdadRegister;
	private JTextField tfUsuarioRegistro;
	private JTextField tfEmailRegister;
	private JTextField tfContraRegistro;
	private JComboBox<String> cbCategorias;
	private JLabel lblFotoSubidaClientes;
	private JLabel lblFotoSubidaEjercicios;
	private JTable tableClientes;
	private JScrollPane scrollPane;
	private JButton btnEligeFotoEjercicio;
	private JTable tableEjercicios;
	private JScrollPane scrollPane2;
	private JButton btnEligeFoto;
	private JButton btnInsertarCliente;
	private JButton btnInsertarEjercicio;
	private JButton btnActualizarEjercicio;
	private JButton btnActualizarCliente;
	private JButton btnBorrarCliente;
	private JButton btnBorrarEjercicio;
	private JTextField tfIDCliente;
	private JTextField tfNombreCliente;
	private JTextField tfEdadCliente;
	private JTextField tfAlturaCliente;
	private JTextField tfPesoCliente;
	private JTextField tfIDEjercicio;
	private JTextField tfNombreEjercicio;
	private JTextField tfSeriesEjercicio;
	private JTextField tfRepeticionesEjercicio;
	private JTextField tfCargaEjercicio;
	private JTextField tfApellidosCliente;
	private JLabel lblIDCliente;
	private JLabel lblNombreCliente;
	private JLabel lblApellidosCliente;
	private JLabel lblEdadCliente;
	private JLabel lblAlturaCliente;
	private JLabel lblPesoCliente;
	private JLabel lblCargakg;
	private JLabel lblRepeticiones;
	private JLabel lblSeries;
	private JLabel lblNombreEjercicio;
	private JLabel lblIDEjercicio;
	private JLabel lblFotoCliente;
	private JLabel lblFotoEjercicio;
	private JLabel lblMenu;
	private JLabel lblHome;
	private JLabel lblPerfil;
	private JLabel lblOpciones;
	private JLabel lblEntrenar;
	private JLabel lblFondoMenu;
	private JLabel lblLogoApp;
	private JLabel lblCategoria;
	private JButton btnLimpiar;
	private JButton btnAsignarmeCliente;
	private JButton btnDesasignarmeCliente;
	private JLabel lblPerfilUsuario;
	private JLabel lblFotoPerfil;
	private JLabel lblEntrenadorPerfil;
	private JTextField tfNombrePerfil;
	private JLabel lblApellidosPerfil;
	private JTextField tfApellidosPerfil;
	private JLabel lblContraPerfil;
	private JLabel lblEdadPerfil;
	private JTextField tfEdadPerfil;
	private JTextField tfUsuarioPerfil;
	private JLabel lblUsuarioPerfil;
	private JLabel lblEmailPerfil;
	private JTextField tfEmailPerfil;
	private JTextField tfContraPerfil;
	private JLabel lblSubirFotoPerfil;
	private JButton btnActualizarEntrenador;
	private JButton btnBorrarEntrenador;
	private JButton btnCerrarSesion;
	private JLabel lblFotoTioRandom;
	private JLabel lblMostrarNombrePerfil;
	private JButton btnEligeFotoPerfil;
	private JLabel lblPersonalizacionApp;
	private JLabel lblVentanaEntrenar;
	private JLabel lblNombreRegister;
	private JLabel lblApellidosRegister;
	private JComboBox<String> cbCategoriasEntrenar;
	private JLabel lblCategoriasEntrenar;
	private JButton btnLimpiarEntrenar;
	private JLabel lblFotoSubidaClientesEntrenar;
	private JLabel lblFotoSubidaEjerciciosEntrenar;
	private JLabel lblFotoSubidaRutinaEntrenar;
	private JTable tableClientesEntrenar;
	private JScrollPane scrollPaneEntrenarEntrenar;
	private JButton btnMostrarEntrenar;
	private JTable tableEjerciciosEntrenar;
	private JScrollPane scrollPane2Entrenar;
	private JTable tableRealizaEntrenar;
	private JScrollPane scrollPane3EntrenarEntrenar;
	private JLabel lblIDClienteEntrenar;
	private JLabel lblNombreClienteEntrenar;
	private JLabel lblApellidosClienteEntrenar;
	private JLabel lblEdadClienteEntrenar;
	private JLabel lblAlturaClienteEntrenar;
	private JLabel lblPesoClienteEntrenar;
	private JLabel lblCargakgEntrenar;
	private JLabel lblRepeticionesEntrenar;
	private JLabel lblSeriesEntrenar;
	private JLabel lblNombreEjercicioEntrenar;
	private JLabel lblIDEjercicioEntrenar;
	private JButton btnEntrenarEntrenar;
	private JButton btnDejarDeEntrenar;
	private JButton btnAcabarSesionEntrenar;
	private JTextField tfIDClienteEntrenar;
	private JTextField tfNombreClienteEntrenar;
	private JTextField tfEdadClienteEntrenar;
	private JTextField tfAlturaClienteEntrenar;
	private JTextField tfPesoClienteEntrenar;
	private JTextField tfIDEjercicioEntrenar;
	private JTextField tfNombreEjercicioEntrenar;
	private JTextField tfSeriesEjercicioEntrenar;
	private JTextField tfRepeticionesEjercicioEntrenar;
	private JTextField tfCargaEjercicioEntrenar;
	private JTextField tfApellidosClienteEntrenar;
	private JLabel lblContraRegistro;
	private JLabel lblEdadRegister;
	private JLabel lblUsuarioRegistro;
	private JLabel lblEmailRegister;
	private JLabel lblFondoRegistro;
	private JLabel lblTituloRegister;
	private JLabel lblTituloRegister2;
	private JLabel lblDivisionRegister;
	private JButton btnVerLogin;
	private JButton btnRegistro;
	private JLabel lblContraLogin;
	private JLabel lblUsuarioLogin;
	private JLabel lblFondoLogin;
	private JLabel lblTituloLogin;
	private JLabel lblTituloLogin2;
	private JLabel lblOlvideContra;
	private JLabel lblDivisionLogin;
	private JButton btnVerRegistro;
	private JButton btnInicioSesion;
	private JLabel lblFP;
	private JLabel lblFR;
	private JLabel lblAM;
	private JLabel lblEM;
	private JLabel lblAZ;
	private JLabel lblMM;
	private JLabel lblLM;
	private JLabel lblN2;

	private String rutaFoto;
	private String rutaFoto2;
	private String rutaFoto3;
	private String rutaFoto4;
	private String usuarioLogeado = "NoAsignado";

	/**
	 * Muestra la página de inicio con todos los componentes de la interfaz de
	 * usuario.
	 *
	 * @param lblHomePage             Etiqueta que muestra la página de inicio.
	 * @param cbCategorias            Cuadro de lista desplegable para categorías.
	 * @param lblCategoria            Etiqueta para mostrar la categoría.
	 * @param lblFotoSubidaClientes   Etiqueta para mostrar la foto subida de
	 *                                clientes.
	 * @param lblFotoSubidaEjercicios Etiqueta para mostrar la foto subida de
	 *                                ejercicios.
	 * @param tableClientes           Tabla que muestra los clientes.
	 * @param scrollPane              Panel de desplazamiento para la tabla de
	 *                                clientes.
	 * @param btnElijeFotoEjercicio   Botón para elegir foto del ejercicio.
	 * @param tableEjercicios         Tabla que muestra los ejercicios.
	 * @param scrollPane2             Panel de desplazamiento para la tabla de
	 *                                ejercicios.
	 * @param btnElijeFoto            Botón para elegir foto.
	 * @param btnInsertarCliente      Botón para insertar un nuevo cliente.
	 * @param btnInsertarEjercicio    Botón para insertar un nuevo ejercicio.
	 * @param btnActualizarEjercicio  Botón para actualizar un ejercicio.
	 * @param btnActualizarCliente    Botón para actualizar un cliente.
	 * @param btnBorrarCliente        Botón para borrar un cliente.
	 * @param btnBorrarEjercicio      Botón para borrar un ejercicio.
	 * @param tfIDCliente             Campo de texto para el ID del cliente.
	 * @param tfNombreCliente         Campo de texto para el nombre del cliente.
	 * @param tfEdadCliente           Campo de texto para la edad del cliente.
	 * @param tfAlturaCliente         Campo de texto para la altura del cliente.
	 * @param tfPesoCliente           Campo de texto para el peso del cliente.
	 * @param tfIDEjercicio           Campo de texto para el ID del ejercicio.
	 * @param tfNombreEjercicio       Campo de texto para el nombre del ejercicio.
	 * @param tfSeriesEjercicio       Campo de texto para las series del ejercicio.
	 * @param tfRepeticionesEjercicio Campo de texto para las repeticiones del
	 *                                ejercicio.
	 * @param tfCargaEjercicio        Campo de texto para la carga del ejercicio.
	 * @param tfApellidosCliente      Campo de texto para los apellidos del cliente.
	 * @param lblIDCliente            Etiqueta para mostrar el ID del cliente.
	 * @param lblNombreCliente        Etiqueta para mostrar el nombre del cliente.
	 * @param lblApellidosCliente     Etiqueta para mostrar los apellidos del
	 *                                cliente.
	 * @param lblEdadCliente          Etiqueta para mostrar la edad del cliente.
	 * @param lblAlturaCliente        Etiqueta para mostrar la altura del cliente.
	 * @param lblPesoCliente          Etiqueta para mostrar el peso del cliente.
	 * @param lblCargakg              Etiqueta para mostrar la carga en kg.
	 * @param lblRepeticiones         Etiqueta para mostrar las repeticiones.
	 * @param lblSeries               Etiqueta para mostrar las series.
	 * @param lblNombreEjercicio      Etiqueta para mostrar el nombre del ejercicio.
	 * @param lblIDEjercicio          Etiqueta para mostrar el ID del ejercicio.
	 * @param lblFotoCliente          Etiqueta para mostrar la foto del cliente.
	 * @param lblFotoEjercicio        Etiqueta para mostrar la foto del ejercicio.
	 * @param btnAsignarmeCliente     Botón para asignarse a un cliente al
	 *                                entrenador logueado.
	 */
	public void verHome(JLabel lblHomePage, JComboBox<String> cbCategorias, JLabel lblCategoria,
			JLabel lblFotoSubidaClientes, JLabel lblFotoSubidaEjercicios, JTable tableClientes, JScrollPane scrollPane,
			JButton btnElijeFotoEjercicio, JTable tableEjercicios, JScrollPane scrollPane2, JButton btnElijeFoto,
			JButton btnInsertarCliente, JButton btnInsertarEjercicio, JButton btnActualizarEjercicio,
			JButton btnActualizarCliente, JButton btnBorrarCliente, JButton btnBorrarEjercicio, JTextField tfIDCliente,
			JTextField tfNombreCliente, JTextField tfEdadCliente, JTextField tfAlturaCliente, JTextField tfPesoCliente,
			JTextField tfIDEjercicio, JTextField tfNombreEjercicio, JTextField tfSeriesEjercicio,
			JTextField tfRepeticionesEjercicio, JTextField tfCargaEjercicio, JTextField tfApellidosCliente,
			JLabel lblIDCliente, JLabel lblNombreCliente, JLabel lblApellidosCliente, JLabel lblEdadCliente,
			JLabel lblAlturaCliente, JLabel lblPesoCliente, JLabel lblCargakg, JLabel lblRepeticiones, JLabel lblSeries,
			JLabel lblNombreEjercicio, JLabel lblIDEjercicio, JLabel lblFotoCliente, JLabel lblFotoEjercicio,
			JButton btnAsignarmeCliente) {
		lblHomePage.setVisible(true);
		cbCategorias.setVisible(true);
		lblCategoria.setVisible(true);
		lblFotoSubidaClientes.setVisible(true);
		lblFotoSubidaEjercicios.setVisible(true);
		tableClientes.setVisible(true);
		scrollPane.setVisible(true);
		btnElijeFotoEjercicio.setVisible(true);
		tableEjercicios.setVisible(true);
		scrollPane2.setVisible(true);
		btnElijeFoto.setVisible(true);
		btnInsertarCliente.setVisible(true);
		btnInsertarEjercicio.setVisible(true);
		btnActualizarEjercicio.setVisible(true);
		btnActualizarCliente.setVisible(true);
		btnBorrarCliente.setVisible(true);
		btnBorrarEjercicio.setVisible(true);
		tfIDCliente.setVisible(true);
		tfNombreCliente.setVisible(true);
		tfEdadCliente.setVisible(true);
		tfAlturaCliente.setVisible(true);
		tfPesoCliente.setVisible(true);
		tfIDEjercicio.setVisible(true);
		tfNombreEjercicio.setVisible(true);
		tfSeriesEjercicio.setVisible(true);
		tfRepeticionesEjercicio.setVisible(true);
		tfCargaEjercicio.setVisible(true);
		tfApellidosCliente.setVisible(true);
		lblIDCliente.setVisible(true);
		lblNombreCliente.setVisible(true);
		lblApellidosCliente.setVisible(true);
		lblEdadCliente.setVisible(true);
		lblAlturaCliente.setVisible(true);
		lblPesoCliente.setVisible(true);
		lblCargakg.setVisible(true);
		lblRepeticiones.setVisible(true);
		lblSeries.setVisible(true);
		lblNombreEjercicio.setVisible(true);
		lblIDEjercicio.setVisible(true);
		lblFotoCliente.setVisible(true);
		lblFotoEjercicio.setVisible(true);
		btnAsignarmeCliente.setVisible(true);
	}

	/**
	 * Oculta la página de inicio con todos los componentes de la interfaz de
	 * usuario.
	 *
	 * @param lblHomePage             Etiqueta que muestra la página de inicio.
	 * @param cbCategorias            Cuadro de lista desplegable para categorías.
	 * @param lblCategoria            Etiqueta para mostrar la categoría.
	 * @param lblFotoSubidaClientes   Etiqueta para mostrar la foto subida de
	 *                                clientes.
	 * @param lblFotoSubidaEjercicios Etiqueta para mostrar la foto subida de
	 *                                ejercicios.
	 * @param tableClientes           Tabla que muestra los clientes.
	 * @param scrollPane              Panel de desplazamiento para la tabla de
	 *                                clientes.
	 * @param btnElijeFotoEjercicio   Botón para elegir foto del ejercicio.
	 * @param tableEjercicios         Tabla que muestra los ejercicios.
	 * @param scrollPane2             Panel de desplazamiento para la tabla de
	 *                                ejercicios.
	 * @param btnElijeFoto            Botón para elegir foto.
	 * @param btnInsertarCliente      Botón para insertar un nuevo cliente.
	 * @param btnInsertarEjercicio    Botón para insertar un nuevo ejercicio.
	 * @param btnActualizarEjercicio  Botón para actualizar un ejercicio.
	 * @param btnActualizarCliente    Botón para actualizar un cliente.
	 * @param btnBorrarCliente        Botón para borrar un cliente.
	 * @param btnBorrarEjercicio      Botón para borrar un ejercicio.
	 * @param tfIDCliente             Campo de texto para el ID del cliente.
	 * @param tfNombreCliente         Campo de texto para el nombre del cliente.
	 * @param tfEdadCliente           Campo de texto para la edad del cliente.
	 * @param tfAlturaCliente         Campo de texto para la altura del cliente.
	 * @param tfPesoCliente           Campo de texto para el peso del cliente.
	 * @param tfIDEjercicio           Campo de texto para el ID del ejercicio.
	 * @param tfNombreEjercicio       Campo de texto para el nombre del ejercicio.
	 * @param tfSeriesEjercicio       Campo de texto para las series del ejercicio.
	 * @param tfRepeticionesEjercicio Campo de texto para las repeticiones del
	 *                                ejercicio.
	 * @param tfCargaEjercicio        Campo de texto para la carga del ejercicio.
	 * @param tfApellidosCliente      Campo de texto para los apellidos del cliente.
	 * @param lblIDCliente            Etiqueta para mostrar el ID del cliente.
	 * @param lblNombreCliente        Etiqueta para mostrar el nombre del cliente.
	 * @param lblApellidosCliente     Etiqueta para mostrar los apellidos del
	 *                                cliente.
	 * @param lblEdadCliente          Etiqueta para mostrar la edad del cliente.
	 * @param lblAlturaCliente        Etiqueta para mostrar la altura del cliente.
	 * @param lblPesoCliente          Etiqueta para mostrar el peso del cliente.
	 * @param lblCargakg              Etiqueta para mostrar la carga en kg.
	 * @param lblRepeticiones         Etiqueta para mostrar las repeticiones.
	 * @param lblSeries               Etiqueta para mostrar las series.
	 * @param lblNombreEjercicio      Etiqueta para mostrar el nombre del ejercicio.
	 * @param lblIDEjercicio          Etiqueta para mostrar el ID del ejercicio.
	 * @param lblFotoCliente          Etiqueta para mostrar la foto del cliente.
	 * @param lblFotoEjercicio        Etiqueta para mostrar la foto del ejercicio.
	 * @param btnAsignarmeCliente     Botón para asignarse a un cliente al
	 *                                entrenador logueado.
	 */
	public void ocultarHome(JLabel lblHomePage, JComboBox<String> cbCategorias, JLabel lblCategoria,
			JLabel lblFotoSubidaClientes, JLabel lblFotoSubidaEjercicios, JTable tableClientes, JScrollPane scrollPane,
			JButton btnElijeFotoEjercicio, JTable tableEjercicios, JScrollPane scrollPane2, JButton btnElijeFoto,
			JButton btnInsertarCliente, JButton btnInsertarEjercicio, JButton btnActualizarEjercicio,
			JButton btnActualizarCliente, JButton btnBorrarCliente, JButton btnBorrarEjercicio, JTextField tfIDCliente,
			JTextField tfNombreCliente, JTextField tfEdadCliente, JTextField tfAlturaCliente, JTextField tfPesoCliente,
			JTextField tfIDEjercicio, JTextField tfNombreEjercicio, JTextField tfSeriesEjercicio,
			JTextField tfRepeticionesEjercicio, JTextField tfCargaEjercicio, JTextField tfApellidosCliente,
			JLabel lblIDCliente, JLabel lblNombreCliente, JLabel lblApellidosCliente, JLabel lblEdadCliente,
			JLabel lblAlturaCliente, JLabel lblPesoCliente, JLabel lblCargakg, JLabel lblRepeticiones, JLabel lblSeries,
			JLabel lblNombreEjercicio, JLabel lblIDEjercicio, JLabel lblFotoCliente, JLabel lblFotoEjercicio,
			JButton btnAsignarmeCliente) {
		lblHomePage.setVisible(false);
		cbCategorias.setVisible(false);
		lblCategoria.setVisible(false);
		lblFotoSubidaClientes.setVisible(false);
		lblFotoSubidaEjercicios.setVisible(false);
		tableClientes.setVisible(false);
		scrollPane.setVisible(false);
		btnElijeFotoEjercicio.setVisible(false);
		tableEjercicios.setVisible(false);
		scrollPane2.setVisible(false);
		btnElijeFoto.setVisible(false);
		btnInsertarCliente.setVisible(false);
		btnInsertarEjercicio.setVisible(false);
		btnActualizarEjercicio.setVisible(false);
		btnActualizarCliente.setVisible(false);
		btnBorrarCliente.setVisible(false);
		btnBorrarEjercicio.setVisible(false);
		tfIDCliente.setVisible(false);
		tfNombreCliente.setVisible(false);
		tfEdadCliente.setVisible(false);
		tfAlturaCliente.setVisible(false);
		tfPesoCliente.setVisible(false);
		tfIDEjercicio.setVisible(false);
		tfNombreEjercicio.setVisible(false);
		tfSeriesEjercicio.setVisible(false);
		tfRepeticionesEjercicio.setVisible(false);
		tfCargaEjercicio.setVisible(false);
		tfApellidosCliente.setVisible(false);
		lblIDCliente.setVisible(false);
		lblNombreCliente.setVisible(false);
		lblApellidosCliente.setVisible(false);
		lblEdadCliente.setVisible(false);
		lblAlturaCliente.setVisible(false);
		lblPesoCliente.setVisible(false);
		lblCargakg.setVisible(false);
		lblRepeticiones.setVisible(false);
		lblSeries.setVisible(false);
		lblNombreEjercicio.setVisible(false);
		lblIDEjercicio.setVisible(false);
		lblFotoCliente.setVisible(false);
		lblFotoEjercicio.setVisible(false);
		btnAsignarmeCliente.setVisible(false);
	}

	/**
	 * Limpia los campos relacionados con la página de inicio.
	 *
	 * @param tableClientes           Tabla de clientes.
	 * @param tableEjercicios         Tabla de ejercicios.
	 * @param tfIDCliente             Campo de texto para el ID del cliente.
	 * @param tfNombreCliente         Campo de texto para el nombre del cliente.
	 * @param tfEdadCliente           Campo de texto para la edad del cliente.
	 * @param tfAlturaCliente         Campo de texto para la altura del cliente.
	 * @param tfPesoCliente           Campo de texto para el peso del cliente.
	 * @param tfIDEjercicio           Campo de texto para el ID del ejercicio.
	 * @param tfNombreEjercicio       Campo de texto para el nombre del ejercicio.
	 * @param tfSeriesEjercicio       Campo de texto para las series del ejercicio.
	 * @param tfRepeticionesEjercicio Campo de texto para las repeticiones del
	 *                                ejercicio.
	 * @param tfCargaEjercicio        Campo de texto para la carga del ejercicio.
	 * @param tfApellidosCliente      Campo de texto para los apellidos del cliente.
	 * @param lblFotoCliente          Etiqueta para la foto del cliente.
	 * @param lblFotoEjercicio        Etiqueta para la foto del ejercicio.
	 */
	public void limpiarCamposHome(JTable tableClientes, JTable tableEjercicios, JTextField tfIDCliente,
			JTextField tfNombreCliente, JTextField tfEdadCliente, JTextField tfAlturaCliente, JTextField tfPesoCliente,
			JTextField tfIDEjercicio, JTextField tfNombreEjercicio, JTextField tfSeriesEjercicio,
			JTextField tfRepeticionesEjercicio, JTextField tfCargaEjercicio, JTextField tfApellidosCliente,
			JLabel lblFotoCliente, JLabel lblFotoEjercicio) {

		// Limpiar el contenido de los JTextField
		tfIDCliente.setText("");
		tfNombreCliente.setText("");
		tfEdadCliente.setText("");
		tfAlturaCliente.setText("");
		tfPesoCliente.setText("");
		tfIDEjercicio.setText("");
		tfNombreEjercicio.setText("");
		tfSeriesEjercicio.setText("");
		tfRepeticionesEjercicio.setText("");
		tfCargaEjercicio.setText("");
		tfApellidosCliente.setText("");

		// Restablecer la selección de las JTables
		tableClientes.clearSelection();
		tableEjercicios.clearSelection();

		// ocultar fotos de cliente y ejercicio
		lblFotoCliente.setVisible(false);
		lblFotoEjercicio.setVisible(false);
	}

	/**
	 * Oculta el menú y sus componentes relacionados.
	 *
	 * @param lblMenu      Etiqueta del menú.
	 * @param lblHome      Etiqueta de la opción "Home".
	 * @param lblPerfil    Etiqueta de la opción "Perfil".
	 * @param lblOpciones  Etiqueta de la opción "Opciones".
	 * @param lblEntrenar  Etiqueta de la opción "Entrenar".
	 * @param lblFondoMenu Etiqueta del fondo del menú.
	 * @param lblLogoApp   Etiqueta del logo de la aplicación.
	 */
	public void ocultarMenu(JLabel lblMenu, JLabel lblHome, JLabel lblPerfil, JLabel lblOpciones, JLabel lblEntrenar,
			JLabel lblFondoMenu, JLabel lblLogoApp) {
		lblMenu.setVisible(false);
		lblHome.setVisible(false);
		lblPerfil.setVisible(false);
		lblOpciones.setVisible(false);
		lblEntrenar.setVisible(false);
		lblFondoMenu.setVisible(false);
		lblLogoApp.setVisible(false);
	}

	/**
	 * Muestra el menú y sus componentes relacionados.
	 *
	 * @param lblMenu      Etiqueta del menú.
	 * @param lblHome      Etiqueta de la opción "Home".
	 * @param lblPerfil    Etiqueta de la opción "Perfil".
	 * @param lblOpciones  Etiqueta de la opción "Opciones".
	 * @param lblEntrenar  Etiqueta de la opción "Entrenar".
	 * @param lblFondoMenu Etiqueta del fondo del menú.
	 * @param lblLogoApp   Etiqueta del logo de la aplicación.
	 */
	public void mostrarMenu(JLabel lblMenu, JLabel lblHome, JLabel lblPerfil, JLabel lblOpciones, JLabel lblEntrenar,
			JLabel lblFondoMenu, JLabel lblLogoApp) {
		lblMenu.setVisible(true);
		lblHome.setVisible(true);
		lblPerfil.setVisible(true);
		lblOpciones.setVisible(true);
		lblEntrenar.setVisible(true);
		lblFondoMenu.setVisible(true);
		lblLogoApp.setVisible(true);
	}

	/**
	 * Muestra los componentes relacionados con el registro en la interfaz de
	 * usuario.
	 *
	 * @param lblNombreEntrenador Etiqueta para el nombre del entrenador.
	 * @param tfNombre            Campo de texto para el nombre.
	 * @param lblApellidos        Etiqueta para los apellidos.
	 * @param tfApellidos         Campo de texto para los apellidos.
	 * @param lblContraRegistro   Etiqueta para la contra de registro.
	 * @param lblEdad             Etiqueta para la edad.
	 * @param tfEdad              Campo de texto para la edad.
	 * @param tfUsuarioRegistro   Campo de texto para el usuario de registro.
	 * @param lblUsuarioRegistro  Etiqueta para el usuario de registro.
	 * @param lblEmail            Etiqueta para el correo electrónico.
	 * @param tfEmail             Campo de texto para el correo electrónico.
	 * @param tfContraRegistro    Campo de texto para la contra de registro.
	 * @param lblFondoRegistro    Etiqueta para el fondo del registro.
	 * @param lblTituloRegister   Etiqueta para el título de registro.
	 * @param lblTituloRegister2  Etiqueta para el segundo título de registro.
	 * @param lblDivisionRegister Etiqueta para la división de registro.
	 * @param btnRegistro         Botón de registro.
	 * @param btnVerLogin         Botón para ver el inicio de sesión.
	 */
	public void verRegistro(JLabel lblNombreEntrenador, JTextField tfNombre, JLabel lblApellidos,
			JTextField tfApellidos, JLabel lblContraRegistro, JLabel lblEdad, JTextField tfEdad,
			JTextField tfUsuarioRegistro, JLabel lblUsuarioRegistro, JLabel lblEmail, JTextField tfEmail,
			JTextField tfContraRegistro, JLabel lblFondoRegistro, JLabel lblTituloRegister, JLabel lblTituloRegister2,
			JLabel lblDivisionRegister, JButton btnRegistro, JButton btnVerLogin) {

		lblNombreEntrenador.setVisible(true);
		tfNombre.setVisible(true);
		lblApellidos.setVisible(true);
		tfApellidos.setVisible(true);
		tfUsuarioRegistro.setVisible(true);
		lblContraRegistro.setVisible(true);
		lblEdad.setVisible(true);
		tfEdad.setVisible(true);
		lblUsuarioRegistro.setVisible(true);
		lblEmail.setVisible(true);
		tfEmail.setVisible(true);
		tfContraRegistro.setVisible(true);
		lblFondoRegistro.setVisible(true);
		lblTituloRegister.setVisible(true);
		lblTituloRegister2.setVisible(true);
		lblDivisionRegister.setVisible(true);
		btnRegistro.setVisible(true);
		btnVerLogin.setVisible(true);
	}

	/**
	 * Oculta los componentes relacionados con el registro en la interfaz de
	 * usuario.
	 *
	 * @param lblNombreEntrenador Etiqueta para el nombre del entrenador.
	 * @param tfNombre            Campo de texto para el nombre.
	 * @param lblApellidos        Etiqueta para los apellidos.
	 * @param tfApellidos         Campo de texto para los apellidos.
	 * @param lblContraRegistro   Etiqueta para la contra de registro.
	 * @param lblEdad             Etiqueta para la edad.
	 * @param tfEdad              Campo de texto para la edad.
	 * @param tfUsuarioRegistro   Campo de texto para el usuario de registro.
	 * @param lblUsuarioRegistro  Etiqueta para el usuario de registro.
	 * @param lblEmail            Etiqueta para el correo electrónico.
	 * @param tfEmail             Campo de texto para el correo electrónico.
	 * @param tfContraRegistro    Campo de texto para la contra de registro.
	 * @param lblFondoRegistro    Etiqueta para el fondo del registro.
	 * @param lblTituloRegister   Etiqueta para el título de registro.
	 * @param lblTituloRegister2  Etiqueta para el segundo título de registro.
	 * @param lblDivisionRegister Etiqueta para la división de registro.
	 * @param btnRegistro         Botón de registro.
	 * @param btnVerLogin         Botón para ver el inicio de sesión.
	 */
	public void ocultarRegistro(JLabel lblNombreEntrenador, JTextField tfNombre, JLabel lblApellidos,
			JTextField tfApellidos, JLabel lblContraRegistro, JLabel lblEdad, JTextField tfEdad,
			JTextField tfUsuarioRegistro, JLabel lblUsuarioRegistro, JLabel lblEmail, JTextField tfEmail,
			JTextField tfContraRegistro, JLabel lblFondoRegistro, JLabel lblTituloRegister, JLabel lblTituloRegister2,
			JLabel lblDivisionRegister, JButton btnRegistro, JButton btnVerLogin) {

		lblNombreEntrenador.setVisible(false);
		tfNombre.setVisible(false);
		lblApellidos.setVisible(false);
		tfApellidos.setVisible(false);
		tfUsuarioRegistro.setVisible(false);
		lblContraRegistro.setVisible(false);
		lblEdad.setVisible(false);
		tfEdad.setVisible(false);
		lblUsuarioRegistro.setVisible(false);
		lblEmail.setVisible(false);
		tfEmail.setVisible(false);
		tfContraRegistro.setVisible(false);
		lblFondoRegistro.setVisible(false);
		lblTituloRegister.setVisible(false);
		lblTituloRegister2.setVisible(false);
		lblDivisionRegister.setVisible(false);
		btnRegistro.setVisible(false);
		btnVerLogin.setVisible(false);
	}

	/**
	 * Muestra los componentes relacionados con el inicio de sesión en la interfaz
	 * de usuario.
	 *
	 * @param lblUsuario          Etiqueta para el usuario.
	 * @param lblContra           Etiqueta para la contra.
	 * @param tfUsuarioEntrenador Campo de texto para el usuario del entrenador.
	 * @param tfContraEntrenador  Campo de texto para la contra del entrenador.
	 * @param lblFondoLogin       Etiqueta para el fondo del inicio de sesión.
	 * @param lblTituloLogin      Etiqueta para el título del inicio de sesión.
	 * @param lblTituloLogin2     Etiqueta para el segundo título del inicio de
	 *                            sesión.
	 * @param lblOlvideContra     Etiqueta para el enlace de "Olvidé mi contra".
	 * @param lblDivisionLogin    Etiqueta para la división del inicio de sesión.
	 * @param btnVerRegistro      Botón para ver el registro.
	 * @param btnInicioSesion     Botón para iniciar sesión.
	 */
	public void verLogin(JLabel lblUsuario, JLabel lblContra, JTextField tfUsuarioEntrenador,
			JPasswordField tfContraEntrenador, JLabel lblFondoLogin, JLabel lblTituloLogin, JLabel lblTituloLogin2,
			JLabel lblOlvideContra, JLabel lblDivisionLogin, JButton btnVerRegistro, JButton btnInicioSesion) {
		lblUsuario.setVisible(true);
		lblContra.setVisible(true);
		tfUsuarioEntrenador.setVisible(true);
		tfContraEntrenador.setVisible(true);
		lblFondoLogin.setVisible(true);
		lblTituloLogin.setVisible(true);
		lblTituloLogin2.setVisible(true);
		lblOlvideContra.setVisible(true);
		lblDivisionLogin.setVisible(true);
		btnVerRegistro.setVisible(true);
		btnInicioSesion.setVisible(true);
	}

	/**
	 * Oculta los componentes relacionados con el inicio de sesión en la interfaz de
	 * usuario.
	 *
	 * @param lblUsuario          Etiqueta para el usuario.
	 * @param lblContra           Etiqueta para la contra.
	 * @param tfUsuarioEntrenador Campo de texto para el usuario del entrenador.
	 * @param tfContraEntrenador  Campo de texto para la contra del entrenador.
	 * @param lblFondoLogin       Etiqueta para el fondo del inicio de sesión.
	 * @param lblTituloLogin      Etiqueta para el título del inicio de sesión.
	 * @param lblTituloLogin2     Etiqueta para el segundo título del inicio de
	 *                            sesión.
	 * @param lblOlvideContra     Etiqueta para el enlace de "Olvidé mi contra".
	 * @param lblDivisionLogin    Etiqueta para la división del inicio de sesión.
	 * @param btnVerRegistro      Botón para ver el registro.
	 * @param btnInicioSesion     Botón para iniciar sesión.
	 */
	public void ocultarLogin(JLabel lblUsuario, JLabel lblContra, JTextField tfUsuarioEntrenador,
			JPasswordField tfContraEntrenador, JLabel lblFondoLogin, JLabel lblTituloLogin, JLabel lblTituloLogin2,
			JLabel lblOlvideContra, JLabel lblDivisionLogin, JButton btnVerRegistro, JButton btnInicioSesion) {
		lblUsuario.setVisible(false);
		lblContra.setVisible(false);
		tfUsuarioEntrenador.setVisible(false);
		tfContraEntrenador.setVisible(false);
		lblFondoLogin.setVisible(false);
		lblTituloLogin.setVisible(false);
		lblTituloLogin2.setVisible(false);
		lblOlvideContra.setVisible(false);
		lblDivisionLogin.setVisible(false);
		btnVerRegistro.setVisible(false);
		btnInicioSesion.setVisible(false);
	}

	/**
	 * Muestra los componentes relacionados con el perfil en la interfaz de usuario.
	 *
	 * @param lblPerfilUsuario        Etiqueta para el perfil de usuario.
	 * @param lblFotoPerfil           Etiqueta para la foto de perfil.
	 * @param lblEntrenadorPerfil     Etiqueta para el perfil del entrenador.
	 * @param tfNombrePerfil          Campo de texto para el nombre del perfil.
	 * @param lblApellidosPerfil      Etiqueta para los apellidos del perfil.
	 * @param tfApellidosPerfil       Campo de texto para los apellidos del perfil.
	 * @param lblContraPerfil         Etiqueta para la contra del perfil.
	 * @param lblEdadPerfil           Etiqueta para la edad del perfil.
	 * @param tfEdadPerfil            Campo de texto para la edad del perfil.
	 * @param tfUsuarioPerfil         Campo de texto para el usuario del perfil.
	 * @param lblUsuarioPerfil        Etiqueta para el usuario del perfil.
	 * @param lblEmailPerfil          Etiqueta para el correo electrónico del
	 *                                perfil.
	 * @param tfEmailPerfil           Campo de texto para el correo electrónico del
	 *                                perfil.
	 * @param tfContraPerfil          Campo de texto para la contra del perfil.
	 * @param lblSubirFotoPerfil      Etiqueta para subir foto de perfil.
	 * @param btnActualizarEntrenador Botón para actualizar el perfil del
	 *                                entrenador.
	 * @param btnBorrarEntrenador     Botón para borrar el perfil del entrenador.
	 * @param btnCerrarSesion         Botón para cerrar sesión.
	 * @param lblFotoTioRandom        Etiqueta para la foto de un tío al azar.
	 * @param lblMostrarNombrePerfil  Etiqueta para mostrar el nombre del perfil.
	 * @param btnElijeFotoPerfil      Botón para elegir foto de perfil.
	 */
	public void verPerfil(JLabel lblPerfilUsuario, JLabel lblFotoPerfil, JLabel lblEntrenadorPerfil,
			JTextField tfNombrePerfil, JLabel lblApellidosPerfil, JTextField tfApellidosPerfil, JLabel lblContraPerfil,
			JLabel lblEdadPerfil, JTextField tfEdadPerfil, JTextField tfUsuarioPerfil, JLabel lblUsuarioPerfil,
			JLabel lblEmailPerfil, JTextField tfEmailPerfil, JTextField tfContraPerfil, JLabel lblSubirFotoPerfil,
			JButton btnActualizarEntrenador, JButton btnBorrarEntrenador, JButton btnCerrarSesion,
			JLabel lblFotoTioRandom, JLabel lblMostrarNombrePerfil, JButton btnElijeFotoPerfil) {
		lblPerfilUsuario.setVisible(true);
		lblFotoPerfil.setVisible(true);
		lblEntrenadorPerfil.setVisible(true);
		tfNombrePerfil.setVisible(true);
		lblApellidosPerfil.setVisible(true);
		tfApellidosPerfil.setVisible(true);
		lblContraPerfil.setVisible(true);
		lblEdadPerfil.setVisible(true);
		tfEdadPerfil.setVisible(true);
		tfUsuarioPerfil.setVisible(true);
		lblUsuarioPerfil.setVisible(true);
		lblEmailPerfil.setVisible(true);
		tfEmailPerfil.setVisible(true);
		tfContraPerfil.setVisible(true);
		lblSubirFotoPerfil.setVisible(true);
		btnActualizarEntrenador.setVisible(true);
		btnBorrarEntrenador.setVisible(true);
		btnCerrarSesion.setVisible(true);
		lblFotoTioRandom.setVisible(true);
		lblMostrarNombrePerfil.setVisible(true);
		btnElijeFotoPerfil.setVisible(true);
	}

	/**
	 * Oculta los componentes relacionados con el perfil en la interfaz de usuario.
	 *
	 * @param lblPerfilUsuario        Etiqueta para el perfil de usuario.
	 * @param lblFotoPerfil           Etiqueta para la foto de perfil.
	 * @param lblEntrenadorPerfil     Etiqueta para el perfil del entrenador.
	 * @param tfNombrePerfil          Campo de texto para el nombre del perfil.
	 * @param lblApellidosPerfil      Etiqueta para los apellidos del perfil.
	 * @param tfApellidosPerfil       Campo de texto para los apellidos del perfil.
	 * @param lblContraPerfil         Etiqueta para la contra del perfil.
	 * @param lblEdadPerfil           Etiqueta para la edad del perfil.
	 * @param tfEdadPerfil            Campo de texto para la edad del perfil.
	 * @param tfUsuarioPerfil         Campo de texto para el usuario del perfil.
	 * @param lblUsuarioPerfil        Etiqueta para el usuario del perfil.
	 * @param lblEmailPerfil          Etiqueta para el correo electrónico del
	 *                                perfil.
	 * @param tfEmailPerfil           Campo de texto para el correo electrónico del
	 *                                perfil.
	 * @param tfContraPerfil          Campo de texto para la contra del perfil.
	 * @param lblSubirFotoPerfil      Etiqueta para subir foto de perfil.
	 * @param btnActualizarEntrenador Botón para actualizar el perfil del
	 *                                entrenador.
	 * @param btnBorrarEntrenador     Botón para borrar el perfil del entrenador.
	 * @param btnCerrarSesion         Botón para cerrar sesión.
	 * @param lblFotoTioRandom        Etiqueta para la foto de un tío al azar.
	 * @param lblMostrarNombrePerfil  Etiqueta para mostrar el nombre del perfil.
	 * @param btnElijeFotoPerfil      Botón para elegir foto de perfil.
	 */
	public void ocultarPerfil(JLabel lblPerfilUsuario, JLabel lblFotoPerfil, JLabel lblEntrenadorPerfil,
			JTextField tfNombrePerfil, JLabel lblApellidosPerfil, JTextField tfApellidosPerfil, JLabel lblContraPerfil,
			JLabel lblEdadPerfil, JTextField tfEdadPerfil, JTextField tfUsuarioPerfil, JLabel lblUsuarioPerfil,
			JLabel lblEmailPerfil, JTextField tfEmailPerfil, JTextField tfContraPerfil, JLabel lblSubirFotoPerfil,
			JButton btnActualizarEntrenador, JButton btnBorrarEntrenador, JButton btnCerrarSesion,
			JLabel lblFotoTioRandom, JLabel lblMostrarNombrePerfil, JButton btnElijeFotoPerfil) {
		lblPerfilUsuario.setVisible(false);
		lblFotoPerfil.setVisible(false);
		lblEntrenadorPerfil.setVisible(false);
		tfNombrePerfil.setVisible(false);
		lblApellidosPerfil.setVisible(false);
		tfApellidosPerfil.setVisible(false);
		lblContraPerfil.setVisible(false);
		lblEdadPerfil.setVisible(false);
		tfEdadPerfil.setVisible(false);
		tfUsuarioPerfil.setVisible(false);
		lblUsuarioPerfil.setVisible(false);
		lblEmailPerfil.setVisible(false);
		tfEmailPerfil.setVisible(false);
		tfContraPerfil.setVisible(false);
		lblSubirFotoPerfil.setVisible(false);
		btnActualizarEntrenador.setVisible(false);
		btnBorrarEntrenador.setVisible(false);
		btnCerrarSesion.setVisible(false);
		lblFotoTioRandom.setVisible(false);
		lblMostrarNombrePerfil.setVisible(false);
		btnElijeFotoPerfil.setVisible(false);

	}

	/**
	 * Muestra los componentes relacionados con las opciones en la interfaz de
	 * usuario.
	 *
	 * @param lblFP                 Etiqueta para la opción FP.
	 * @param lblFR                 Etiqueta para la opción FR.
	 * @param lblAM                 Etiqueta para la opción AM.
	 * @param lblEM                 Etiqueta para la opción EM.
	 * @param lblAZ                 Etiqueta para la opción AZ.
	 * @param lblLM                 Etiqueta para la opción LM.
	 * @param lblMM                 Etiqueta para la opción MM.
	 * @param lblN2                 Etiqueta para el N2.
	 * @param lblPersonalizacionApp Etiqueta para la personalización de la
	 *                              aplicación.
	 */
	public void verOpciones(JLabel lblFP, JLabel lblFR, JLabel lblAM, JLabel lblEM, JLabel lblAZ, JLabel lblLM,
			JLabel lblMM, JLabel lblN2, JLabel lblPersonalizacionApp) {
		lblFP.setVisible(true);
		lblFR.setVisible(true);
		lblAM.setVisible(true);
		lblEM.setVisible(true);
		lblAZ.setVisible(true);
		lblLM.setVisible(true);
		lblMM.setVisible(true);
		lblN2.setVisible(true);
		lblPersonalizacionApp.setVisible(true);
	}

	/**
	 * Oculta los componentes relacionados con las opciones en la interfaz de
	 * usuario.
	 *
	 * @param lblFP                 Etiqueta para la opción FP.
	 * @param lblFR                 Etiqueta para la opción FR.
	 * @param lblAM                 Etiqueta para la opción AM.
	 * @param lblEM                 Etiqueta para la opción EM.
	 * @param lblAZ                 Etiqueta para la opción AZ.
	 * @param lblLM                 Etiqueta para la opción LM.
	 * @param lblMM                 Etiqueta para la opción MM.
	 * @param lblN2                 Etiqueta para el N2.
	 * @param lblPersonalizacionApp Etiqueta para la personalización de la
	 *                              aplicación.
	 */
	public void ocultarOpciones(JLabel lblFP, JLabel lblFR, JLabel lblAM, JLabel lblEM, JLabel lblAZ, JLabel lblLM,
			JLabel lblMM, JLabel lblN2, JLabel lblPersonalizacionApp) {
		lblFP.setVisible(false);
		lblFR.setVisible(false);
		lblAM.setVisible(false);
		lblEM.setVisible(false);
		lblAZ.setVisible(false);
		lblLM.setVisible(false);
		lblMM.setVisible(false);
		lblN2.setVisible(false);
		lblPersonalizacionApp.setVisible(false);
	}

	/**
	 * Oculta los componentes relacionados con la función de entrenar en la interfaz
	 * de usuario.
	 *
	 * @param lblVentanaEntrenar              Etiqueta de la ventana de
	 *                                        entrenamiento.
	 * @param cbCategoriasEntrenar            Cuadro de selección de categorías de
	 *                                        entrenamiento.
	 * @param lblCategoriasEntrenar           Etiqueta de categorías de
	 *                                        entrenamiento.
	 * @param btnLimpiarEntrenar              Botón de limpiar entrenamiento.
	 * @param tableClientesEntrenar           Tabla de clientes en el entrenamiento.
	 * @param scrollPaneEntrenarEntrenar      Panel de desplazamiento para la tabla
	 *                                        de clientes en el entrenamiento.
	 * @param btnMostrarEntrenar              Botón de mostrar entrenamiento.
	 * @param tableEjerciciosEntrenar         Tabla de ejercicios en el
	 *                                        entrenamiento.
	 * @param scrollPane2Entrenar             Panel de desplazamiento para la tabla
	 *                                        de ejercicios en el entrenamiento.
	 * @param tableRealizaEntrenar            Tabla de registros de entrenamiento.
	 * @param scrollPane3EntrenarEntrenar     Panel de desplazamiento para la tabla
	 *                                        de registros de entrenamiento.
	 * @param lblIDClienteEntrenar            Etiqueta de ID de cliente en el
	 *                                        entrenamiento.
	 * @param lblNombreClienteEntrenar        Etiqueta de nombre de cliente en el
	 *                                        entrenamiento.
	 * @param lblApellidosClienteEntrenar     Etiqueta de apellidos de cliente en el
	 *                                        entrenamiento.
	 * @param lblEdadClienteEntrenar          Etiqueta de edad de cliente en el
	 *                                        entrenamiento.
	 * @param lblAlturaClienteEntrenar        Etiqueta de altura de cliente en el
	 *                                        entrenamiento.
	 * @param lblPesoClienteEntrenar          Etiqueta de peso de cliente en el
	 *                                        entrenamiento.
	 * @param lblCargakgEntrenar              Etiqueta de carga en kilogramos en el
	 *                                        entrenamiento.
	 * @param lblRepeticionesEntrenar         Etiqueta de repeticiones en el
	 *                                        entrenamiento.
	 * @param lblSeriesEntrenar               Etiqueta de series en el
	 *                                        entrenamiento.
	 * @param lblNombreEjercicioEntrenar      Etiqueta de nombre de ejercicio en el
	 *                                        entrenamiento.
	 * @param lblIDEjercicioEntrenar          Etiqueta de ID de ejercicio en el
	 *                                        entrenamiento.
	 * @param btnEntrenarEntrenar             Botón de empezar entrenamiento.
	 * @param btnDejarDeEntrenar              Botón de dejar de entrenar.
	 * @param btnAcabarSesionEntrenar         Botón de finalizar sesión de
	 *                                        entrenamiento.
	 * @param tfIDClienteEntrenar             Campo de texto para el ID de cliente
	 *                                        en el entrenamiento.
	 * @param tfNombreClienteEntrenar         Campo de texto para el nombre de
	 *                                        cliente en el entrenamiento.
	 * @param tfEdadClienteEntrenar           Campo de texto para la edad de cliente
	 *                                        en el entrenamiento.
	 * @param tfAlturaClienteEntrenar         Campo de texto para la altura de
	 *                                        cliente en el entrenamiento.
	 * @param tfPesoClienteEntrenar           Campo de texto para el peso de cliente
	 *                                        en el entrenamiento.
	 * @param tfIDEjercicioEntrenar           Campo de texto para el ID de ejercicio
	 *                                        en el entrenamiento.
	 * @param tfNombreEjercicioEntrenar       Campo de texto para el nombre de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfSeriesEjercicioEntrenar       Campo de texto para las series de
	 *                                        ejercicio en el entrenamiento
	 * @param tfRepeticionesEjercicioEntrenar Campo de texto para las repeticiones
	 *                                        de ejercicio en el entrenamiento.
	 * @param tfCargaEjercicioEntrenar        Campo de texto para la carga de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfApellidosClienteEntrenar      Campo de texto para los apellidos de
	 *                                        cliente en el entrenamiento.
	 * @param lblFotoSubidaClientesEntrenar   Etiqueta de la foto subida del cliente
	 *                                        en el entrenamiento.
	 * @param lblFotoSubidaEjerciciosEntrenar Etiqueta de la foto subida del
	 *                                        ejercicio en el entrenamiento.
	 * @param lblFotoSubidaRutinaEntrenar     Etiqueta de la foto subida de la
	 *                                        rutina en el entrenamiento.
	 */

	public void ocultarEntrenar(JLabel lblVentanaEntrenar, JComboBox<String> cbCategoriasEntrenar,
			JLabel lblCategoriasEntrenar, JButton btnLimpiarEntrenar, JTable tableClientesEntrenar,
			JScrollPane scrollPaneEntrenarEntrenar, JButton btnMostrarEntrenar, JTable tableEjerciciosEntrenar,
			JScrollPane scrollPane2Entrenar, JTable tableRealizaEntrenar, JScrollPane scrollPane3EntrenarEntrenar,
			JLabel lblIDClienteEntrenar, JLabel lblNombreClienteEntrenar, JLabel lblApellidosClienteEntrenar,
			JLabel lblEdadClienteEntrenar, JLabel lblAlturaClienteEntrenar, JLabel lblPesoClienteEntrenar,
			JLabel lblCargakgEntrenar, JLabel lblRepeticionesEntrenar, JLabel lblSeriesEntrenar,
			JLabel lblNombreEjercicioEntrenar, JLabel lblIDEjercicioEntrenar, JButton btnEntrenarEntrenar,
			JButton btnDejarDeEntrenar, JButton btnAcabarSesionEntrenar, JTextField tfIDClienteEntrenar,
			JTextField tfNombreClienteEntrenar, JTextField tfEdadClienteEntrenar, JTextField tfAlturaClienteEntrenar,
			JTextField tfPesoClienteEntrenar, JTextField tfIDEjercicioEntrenar, JTextField tfNombreEjercicioEntrenar,
			JTextField tfSeriesEjercicioEntrenar, JTextField tfRepeticionesEjercicioEntrenar,
			JTextField tfCargaEjercicioEntrenar, JTextField tfApellidosClienteEntrenar,
			JLabel lblFotoSubidaClientesEntrenar, JLabel lblFotoSubidaEjerciciosEntrenar,
			JLabel lblFotoSubidaRutinaEntrenar) {
		lblVentanaEntrenar.setVisible(false);
		cbCategoriasEntrenar.setVisible(false);
		lblCategoriasEntrenar.setVisible(false);
		btnLimpiarEntrenar.setVisible(false);
		tableClientesEntrenar.setVisible(false);
		scrollPaneEntrenarEntrenar.setVisible(false);
		btnMostrarEntrenar.setVisible(false);
		tableEjerciciosEntrenar.setVisible(false);
		scrollPane2Entrenar.setVisible(false);
		tableRealizaEntrenar.setVisible(false);
		scrollPane3EntrenarEntrenar.setVisible(false);
		lblIDClienteEntrenar.setVisible(false);
		lblNombreClienteEntrenar.setVisible(false);
		lblApellidosClienteEntrenar.setVisible(false);
		lblEdadClienteEntrenar.setVisible(false);
		lblAlturaClienteEntrenar.setVisible(false);
		lblPesoClienteEntrenar.setVisible(false);
		lblCargakgEntrenar.setVisible(false);
		lblRepeticionesEntrenar.setVisible(false);
		lblSeriesEntrenar.setVisible(false);
		lblNombreEjercicioEntrenar.setVisible(false);
		lblIDEjercicioEntrenar.setVisible(false);
		btnEntrenarEntrenar.setVisible(false);
		btnDejarDeEntrenar.setVisible(false);
		btnAcabarSesionEntrenar.setVisible(false);
		tfIDClienteEntrenar.setVisible(false);
		tfNombreClienteEntrenar.setVisible(false);
		tfEdadClienteEntrenar.setVisible(false);
		tfAlturaClienteEntrenar.setVisible(false);
		tfPesoClienteEntrenar.setVisible(false);
		tfIDEjercicioEntrenar.setVisible(false);
		tfNombreEjercicioEntrenar.setVisible(false);
		tfSeriesEjercicioEntrenar.setVisible(false);
		tfRepeticionesEjercicioEntrenar.setVisible(false);
		tfCargaEjercicioEntrenar.setVisible(false);
		tfApellidosClienteEntrenar.setVisible(false);
		lblFotoSubidaClientesEntrenar.setVisible(false);
		lblFotoSubidaEjerciciosEntrenar.setVisible(false);
		lblFotoSubidaRutinaEntrenar.setVisible(false);

	}

	/**
	 * Muestra los componentes relacionados con la función de entrenar en la
	 * interfaz de usuario.
	 *
	 * @param lblVentanaEntrenar              Etiqueta de la ventana de
	 *                                        entrenamiento.
	 * @param cbCategoriasEntrenar            Cuadro de selección de categorías de
	 *                                        entrenamiento.
	 * @param lblCategoriasEntrenar           Etiqueta de categorías de
	 *                                        entrenamiento.
	 * @param btnLimpiarEntrenar              Botón de limpiar entrenamiento.
	 * @param tableClientesEntrenar           Tabla de clientes en el entrenamiento.
	 * @param scrollPaneEntrenarEntrenar      Panel de desplazamiento para la tabla
	 *                                        de clientes en el entrenamiento.
	 * @param btnMostrarEntrenar              Botón de mostrar entrenamiento.
	 * @param tableEjerciciosEntrenar         Tabla de ejercicios en el
	 *                                        entrenamiento.
	 * @param scrollPane2Entrenar             Panel de desplazamiento para la tabla
	 *                                        de ejercicios en el entrenamiento.
	 * @param tableRealizaEntrenar            Tabla de registros de entrenamiento.
	 * @param scrollPane3EntrenarEntrenar     Panel de desplazamiento para la tabla
	 *                                        de registros de entrenamiento.
	 * @param lblIDClienteEntrenar            Etiqueta de ID de cliente en el
	 *                                        entrenamiento.
	 * @param lblNombreClienteEntrenar        Etiqueta de nombre de cliente en el
	 *                                        entrenamiento.
	 * @param lblApellidosClienteEntrenar     Etiqueta de apellidos de cliente en el
	 *                                        entrenamiento.
	 * @param lblEdadClienteEntrenar          Etiqueta de edad de cliente en el
	 *                                        entrenamiento.
	 * @param lblAlturaClienteEntrenar        Etiqueta de altura de cliente en el
	 *                                        entrenamiento.
	 * @param lblPesoClienteEntrenar          Etiqueta de peso de cliente en el
	 *                                        entrenamiento.
	 * @param lblCargakgEntrenar              Etiqueta de carga en kilogramos en el
	 *                                        entrenamiento.
	 * @param lblRepeticionesEntrenar         Etiqueta de repeticiones en el
	 *                                        entrenamiento.
	 * @param lblSeriesEntrenar               Etiqueta de series en el
	 *                                        entrenamiento.
	 * @param lblNombreEjercicioEntrenar      Etiqueta de nombre de ejercicio en el
	 *                                        entrenamiento.
	 * @param lblIDEjercicioEntrenar          Etiqueta de ID de ejercicio en el
	 *                                        entrenamiento.
	 * @param btnEntrenarEntrenar             Botón de empezar entrenamiento.
	 * @param btnDejarDeEntrenar              Botón de dejar de entrenar.
	 * @param btnAcabarSesionEntrenar         Botón de finalizar sesión de
	 *                                        entrenamiento.
	 * @param tfIDClienteEntrenar             Campo de texto para el ID de cliente
	 *                                        en el entrenamiento.
	 * @param tfNombreClienteEntrenar         Campo de texto para el nombre de
	 *                                        cliente en el entrenamiento.
	 * @param tfEdadClienteEntrenar           Campo de texto para la edad de cliente
	 *                                        en el entrenamiento.
	 * @param tfAlturaClienteEntrenar         Campo de texto para la altura de
	 *                                        cliente en el entrenamiento.
	 * @param tfPesoClienteEntrenar           Campo de texto para el peso de cliente
	 *                                        en el entrenamiento.
	 * @param tfIDEjercicioEntrenar           Campo de texto para el ID de ejercicio
	 *                                        en el entrenamiento.
	 * @param tfNombreEjercicioEntrenar       Campo de texto para el nombre de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfSeriesEjercicioEntrenar       Campo de texto para las series de
	 *                                        ejercicio en el entrenamiento
	 * @param tfRepeticionesEjercicioEntrenar Campo de texto para las repeticiones
	 *                                        de ejercicio en el entrenamiento.
	 * @param tfCargaEjercicioEntrenar        Campo de texto para la carga de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfApellidosClienteEntrenar      Campo de texto para los apellidos de
	 *                                        cliente en el entrenamiento.
	 * @param lblFotoSubidaClientesEntrenar   Etiqueta de la foto subida del cliente
	 *                                        en el entrenamiento.
	 * @param lblFotoSubidaEjerciciosEntrenar Etiqueta de la foto subida del
	 *                                        ejercicio en el entrenamiento.
	 * @param lblFotoSubidaRutinaEntrenar     Etiqueta de la foto subida de la
	 *                                        rutina en el entrenamiento.
	 */
	public void verEntrenar(JLabel lblVentanaEntrenar, JComboBox<String> cbCategoriasEntrenar,
			JLabel lblCategoriasEntrenar, JButton btnLimpiarEntrenar, JTable tableClientesEntrenar,
			JScrollPane scrollPaneEntrenarEntrenar, JButton btnMostrarEntrenar, JTable tableEjerciciosEntrenar,
			JScrollPane scrollPane2Entrenar, JTable tableRealizaEntrenar, JScrollPane scrollPane3EntrenarEntrenar,
			JLabel lblIDClienteEntrenar, JLabel lblNombreClienteEntrenar, JLabel lblApellidosClienteEntrenar,
			JLabel lblEdadClienteEntrenar, JLabel lblAlturaClienteEntrenar, JLabel lblPesoClienteEntrenar,
			JLabel lblCargakgEntrenar, JLabel lblRepeticionesEntrenar, JLabel lblSeriesEntrenar,
			JLabel lblNombreEjercicioEntrenar, JLabel lblIDEjercicioEntrenar, JButton btnEntrenarEntrenar,
			JButton btnDejarDeEntrenar, JButton btnAcabarSesionEntrenar, JTextField tfIDClienteEntrenar,
			JTextField tfNombreClienteEntrenar, JTextField tfEdadClienteEntrenar, JTextField tfAlturaClienteEntrenar,
			JTextField tfPesoClienteEntrenar, JTextField tfIDEjercicioEntrenar, JTextField tfNombreEjercicioEntrenar,
			JTextField tfSeriesEjercicioEntrenar, JTextField tfRepeticionesEjercicioEntrenar,
			JTextField tfCargaEjercicioEntrenar, JTextField tfApellidosClienteEntrenar) {
		lblVentanaEntrenar.setVisible(true);
		cbCategoriasEntrenar.setVisible(true);
		lblCategoriasEntrenar.setVisible(true);
		btnLimpiarEntrenar.setVisible(true);
		tableClientesEntrenar.setVisible(true);
		scrollPaneEntrenarEntrenar.setVisible(true);
		btnMostrarEntrenar.setVisible(true);
		tableEjerciciosEntrenar.setVisible(true);
		scrollPane2Entrenar.setVisible(true);
		tableRealizaEntrenar.setVisible(true);
		scrollPane3EntrenarEntrenar.setVisible(true);
		lblIDClienteEntrenar.setVisible(true);
		lblNombreClienteEntrenar.setVisible(true);
		lblApellidosClienteEntrenar.setVisible(true);
		lblEdadClienteEntrenar.setVisible(true);
		lblAlturaClienteEntrenar.setVisible(true);
		lblPesoClienteEntrenar.setVisible(true);
		lblCargakgEntrenar.setVisible(true);
		lblRepeticionesEntrenar.setVisible(true);
		lblSeriesEntrenar.setVisible(true);
		lblNombreEjercicioEntrenar.setVisible(true);
		lblIDEjercicioEntrenar.setVisible(true);
		btnEntrenarEntrenar.setVisible(true);
		btnDejarDeEntrenar.setVisible(true);
		btnAcabarSesionEntrenar.setVisible(true);
		tfIDClienteEntrenar.setVisible(true);
		tfNombreClienteEntrenar.setVisible(true);
		tfEdadClienteEntrenar.setVisible(true);
		tfAlturaClienteEntrenar.setVisible(true);
		tfPesoClienteEntrenar.setVisible(true);
		tfIDEjercicioEntrenar.setVisible(true);
		tfNombreEjercicioEntrenar.setVisible(true);
		tfSeriesEjercicioEntrenar.setVisible(true);
		tfRepeticionesEjercicioEntrenar.setVisible(true);
		tfCargaEjercicioEntrenar.setVisible(true);
		tfApellidosClienteEntrenar.setVisible(true);

	}

	/**
	 * Limpia los campos relacionados con la función de entrenar en la interfaz de
	 * usuario.
	 *
	 * @param tableClientesEntrenar           Tabla de clientes en el entrenamiento.
	 * @param tableEjerciciosEntrenar         Tabla de ejercicios en el
	 *                                        entrenamiento.
	 * @param tableRealizaEntrenar            Tabla de registros de entrenamiento.
	 * @param tfIDClienteEntrenar             Campo de texto para el ID de cliente
	 *                                        en el entrenamiento.
	 * @param tfNombreClienteEntrenar         Campo de texto para el nombre de
	 *                                        cliente en el entrenamiento.
	 * @param tfEdadClienteEntrenar           Campo de texto para la edad de cliente
	 *                                        en el entrenamiento.
	 * @param tfAlturaClienteEntrenar         Campo de texto para la altura de
	 *                                        cliente en el entrenamiento.
	 * @param tfPesoClienteEntrenar           Campo de texto para el peso de cliente
	 *                                        en el entrenamiento.
	 * @param tfIDEjercicioEntrenar           Campo de texto para el ID de ejercicio
	 *                                        en el entrenamiento.
	 * @param tfNombreEjercicioEntrenar       Campo de texto para el nombre de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfSeriesEjercicioEntrenar       Campo de texto para las series de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfRepeticionesEjercicioEntrenar Campo de texto para las repeticiones
	 *                                        de ejercicio en el entrenamiento.
	 * @param tfCargaEjercicioEntrenar        Campo de texto para la carga de
	 *                                        ejercicio en el entrenamiento.
	 * @param tfApellidosClienteEntrenar      Campo de texto para los apellidos de
	 *                                        cliente en el entrenamiento.
	 * @param lblFotoSubidaClientesEntrenar   Etiqueta de la foto subida del cliente
	 *                                        en el entrenamiento.
	 * @param lblFotoSubidaEjerciciosEntrenar Etiqueta de la foto subida del
	 *                                        ejercicio en el entrenamiento.
	 * @param lblFotoSubidaRutinaEntrenar     Etiqueta de la foto subida de la
	 *                                        rutina en el entrenamiento.
	 */
	public void limpiarCamposEntrenar(JTable tableClientesEntrenar, JTable tableEjerciciosEntrenar,
			JTable tableRealizaEntrenar, JTextField tfIDClienteEntrenar, JTextField tfNombreClienteEntrenar,
			JTextField tfEdadClienteEntrenar, JTextField tfAlturaClienteEntrenar, JTextField tfPesoClienteEntrenar,
			JTextField tfIDEjercicioEntrenar, JTextField tfNombreEjercicioEntrenar,
			JTextField tfSeriesEjercicioEntrenar, JTextField tfRepeticionesEjercicioEntrenar,
			JTextField tfCargaEjercicioEntrenar, JTextField tfApellidosClienteEntrenar,
			JLabel lblFotoSubidaClientesEntrenar, JLabel lblFotoSubidaEjerciciosEntrenar,
			JLabel lblFotoSubidaRutinaEntrenar) {

		// Limpiar el contenido de los JTextField
		tfIDClienteEntrenar.setText("");
		tfNombreClienteEntrenar.setText("");
		tfEdadClienteEntrenar.setText("");
		tfAlturaClienteEntrenar.setText("");
		tfPesoClienteEntrenar.setText("");
		tfIDEjercicioEntrenar.setText("");
		tfNombreEjercicioEntrenar.setText("");
		tfSeriesEjercicioEntrenar.setText("");
		tfRepeticionesEjercicioEntrenar.setText("");
		tfCargaEjercicioEntrenar.setText("");
		tfApellidosClienteEntrenar.setText("");

		// Restablecer la selección de las JTables
		tableClientesEntrenar.clearSelection();
		tableEjerciciosEntrenar.clearSelection();
		tableRealizaEntrenar.clearSelection();

		// ocultar fotos de cliente, rutina y ejercicio
		lblFotoSubidaClientesEntrenar.setVisible(false);
		lblFotoSubidaEjerciciosEntrenar.setVisible(false);
		lblFotoSubidaRutinaEntrenar.setVisible(false);
	}

	/**
	 * Actualiza la apariencia y el diseño de un JFrame.
	 * 
	 * @param frame El JFrame que se va a actualizar.
	 */

	private static void updateUI(JFrame frame) {
		SwingUtilities.updateComponentTreeUI(frame);
		frame.validate();
		frame.repaint();
	}

	/**
	 * Obtiene la extensión de un archivo.
	 * 
	 * @param file El archivo del que se desea obtener la extensión.
	 * @return La extensión del archivo, en formato de texto.
	 */

	public String getFileExtension(File file) {
		String extension = "";
		String fileName = file.getName();
		int dotIndex = fileName.lastIndexOf('.');
		if (dotIndex > 0 && dotIndex < fileName.length() - 1) {
			extension = fileName.substring(dotIndex + 1).toLowerCase();
		}
		return extension;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntelliJTheme.setup(App.class.getResourceAsStream("temas/claros/arc-theme-orange.theme.json"));
					App window = new App();
					window.frmFirePunch.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		/**
		 * Declaración de expresiones regulares para hacer las comprobaciones de
		 * errores.
		 * 
		 * patNombre: Cadena de texto que empiece por mayúscula, que tenga como mínimo 2
		 * letras y no hay máximo.
		 * 
		 * patApellido: Cadena de texto que empiece por mayúscula, que tenga como mínimo
		 * 2 letras y no hay máximo, seguida de otra cadena opcional de las mismas
		 * características.
		 * 
		 * patEdad: Cadena de dos dígitos. Más adelante se comprueba que haya un mínimo
		 * y máximo de edad para realizar ciertas acciones.
		 * 
		 * patEmail: Cadena de texto que obliga a que se pueda poner cualquier dígito o
		 * letra seguida de @, después otra cadea de cualquier dígito o letra seguida de
		 * punto y después 2 0 3 letras minúsculas.
		 * 
		 * patDecimal: Comprobación de que el número sea decimal.
		 * 
		 * patEntero: Comprobación de que el número sea entero, limitándolo a 1 cifra
		 * como mínimo y 4 cifras como máximo.
		 */
		Pattern patNombre = Pattern.compile("^[A-Za-z]{2,}$");
		Pattern patApellido = Pattern.compile("^[A-Za-z]{2,}(\\s[A-Za-z]{2,})?$");
		Pattern patEdad = Pattern.compile("^\\d{2}$");
		Pattern patEmail = Pattern.compile("\\w+@\\w+\\.[a-z]{2,3}");
		Pattern patDecimal = Pattern.compile("^\\d+(\\.\\d+)?$");
		Pattern patEntero = Pattern.compile("^\\d{1,4}$");

		/**
		 * Declaración de objetos de las clases DAO que se usan en la aplicación.
		 * 
		 * clienteDAO: clase DAO con las acciones relativas a los clientes que se
		 * realizan sobre la bbdd.
		 * 
		 * categoriaDAO: clase DAO con las acciones relativas a las categorías que se
		 * realizan sobre la bbdd.
		 * 
		 * ejercicioDAO: clase DAO con las acciones relativas a los ejercicios que se
		 * realizan sobre la bbdd.
		 * 
		 * entrenadorDAO: clase DAO con las acciones relativas a los entrenadores que se
		 * realizan sobre la bbdd.
		 */
		ClienteDAO clienteDAO = new ClienteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		EjercicioDAO ejercicioDAO = new EjercicioDAO();
		EntrenadorDAO entrenadorDAO = new EntrenadorDAO();

		/**
		 * Declaración a nulo de las listas de datos relativos a las clases del
		 * proyecto. Más adelante se les asigna valor.
		 * 
		 * List<Cliente> clientes: lista de todos los clientes obtenidos en la bbdd.
		 * 
		 * List<Cliente> clientesDeEntrenador: lista de los clientes filtrados por id de
		 * entrenador.
		 * 
		 * List<Ejercicio> ejercicios: lista de todos los ejercicios obtenidos en la
		 * bbdd.
		 * 
		 * List<Entrenador> entrenadores: lista de todos los entrenadores obtenidos en
		 * la bbdd.
		 * 
		 * List<Categoria> categorias: lista de todos las categorías obtenidos en la
		 * bbdd.
		 */
		List<Cliente> clientes = null;
		List<Cliente> clientesDeEntrenador = null;
		List<Ejercicio> ejercicios = null;
		List<Entrenador> entrenadores = null;
		List<Categoria> categorias = null;

		/**
		 * Inicialización del frame que contiene la aplicación
		 */
		frmFirePunch = new JFrame();
		frmFirePunch.getContentPane().setBackground(new Color(240, 240, 240));
		frmFirePunch.setBounds(25, 25, 1550, 850);
		frmFirePunch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFirePunch.getContentPane().setLayout(null);

		lblHomePage = new JLabel("Inicio de la aplicación");
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblHomePage.setBounds(765, 55, 270, 33);
		frmFirePunch.getContentPane().add(lblHomePage);

		cbCategorias = new JComboBox<String>();
		cbCategorias.setBounds(1070, 498, 220, 22);
		categorias = categoriaDAO.selectAllCategoria();
		cbCategorias.removeAllItems();

		/**
		 * Se crea un contador con valor 1 para rellenar los valores del desplegable de
		 * las categorías obtenidas.
		 */

		int numeral2 = 1;
		for (Categoria c : categorias) {
			cbCategorias.addItem(numeral2 + ". " + c.getNombreCategoria());
			numeral2++;
		}

		frmFirePunch.getContentPane().add(cbCategorias);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(959, 502, 66, 18);
		frmFirePunch.getContentPane().add(lblCategoria);

		/**
		 * Botón oculto que sirve para limpiar los datos de los campos de texto e
		 * imágenes de clientes y ejercicios.
		 */
		btnLimpiar = new JButton("New button");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfIDCliente.setText("");
				tfIDEjercicio.setText("");
				tfNombreCliente.setText("");
				tfNombreEjercicio.setText("");
				tfApellidosCliente.setText("");
				tfEdadCliente.setText("");
				tfAlturaCliente.setText("");
				tfPesoCliente.setText("");
				tfSeriesEjercicio.setText("");
				tfRepeticionesEjercicio.setText("");
				tfCargaEjercicio.setText("");
				lblFotoSubidaClientes.setVisible(false);
				lblFotoSubidaEjercicios.setVisible(false);
				cbCategorias.setSelectedIndex(0);
			}
		});
		btnLimpiar.setBounds(287, -52, 117, 25);
		frmFirePunch.getContentPane().add(btnLimpiar);
		btnLimpiar.setVisible(false);

		lblFotoSubidaClientes = new JLabel();
		lblFotoSubidaClientes.setBounds(669, 356, 200, 200);
		frmFirePunch.getContentPane().add(lblFotoSubidaClientes);

		lblFotoSubidaEjercicios = new JLabel();
		lblFotoSubidaEjercicios.setBounds(1312, 356, 200, 200);
		frmFirePunch.getContentPane().add(lblFotoSubidaEjercicios);

		/**
		 * Declaración de los modelos de las tablas que contendrán los valores de la
		 * bbdd.
		 * 
		 * modelCliente: modelo relativo a la tabla de los clientes.
		 * 
		 * modelEjercicio: modelo relativo a la tabla de los ejercicios.
		 */
		DefaultTableModel modelCliente = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false; // No permitir la edición de las celdas
			}
		};

		DefaultTableModel modelEjercicio = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false; // No permitir la edición de las celdas
			}
		};

		modelCliente.addColumn("ID");
		modelCliente.addColumn("Nombre");
		modelCliente.addColumn("Apellidos");
		modelCliente.addColumn("Edad");
		modelCliente.addColumn("Altura");
		modelCliente.addColumn("Peso");
		modelCliente.addColumn("Entrenador");

		/**
		 * Los datos de la tabla de los clientes se rellena más adelante, cuando se
		 * realiza el login, porque dependiendo del usuario registrado, se mostrará unos
		 * clientes u otros
		 */

		tableClientes = new JTable(modelCliente);
		tableClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tableClientes.getSelectedRow();
				TableModel model = tableClientes.getModel();

				tfIDCliente.setText(model.getValueAt(index, 0).toString());
				tfNombreCliente.setText(model.getValueAt(index, 1).toString());
				tfApellidosCliente.setText(model.getValueAt(index, 2).toString());
				tfEdadCliente.setText(model.getValueAt(index, 3).toString());
				tfAlturaCliente.setText(model.getValueAt(index, 4).toString());
				tfPesoCliente.setText(model.getValueAt(index, 5).toString());

				Cliente c = clienteDAO.selectClienteById(Integer.parseInt(model.getValueAt(index, 0).toString()));
				rutaFoto = c.getFotoPerfil();

				ImageIcon imageIcon = new ImageIcon(rutaFoto);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaClientes.getWidth(),
						lblFotoSubidaClientes.getHeight(), Image.SCALE_SMOOTH);
				lblFotoSubidaClientes.setIcon(new ImageIcon(image));
				lblFotoSubidaClientes.setVisible(true);

			}

		});
		tableClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel = tableClientes.getColumnModel();

		/**
		 * Declaración y asignación de valores relativos al ancho y centrado de datos de
		 * las columnas de la tabla de clientes
		 */
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);

		columnModel.getColumn(0).setPreferredWidth(60);
		columnModel.getColumn(0).setCellRenderer(centerRender);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(1).setCellRenderer(centerRender);
		columnModel.getColumn(2).setPreferredWidth(130);
		columnModel.getColumn(2).setCellRenderer(centerRender);
		columnModel.getColumn(3).setPreferredWidth(60);
		columnModel.getColumn(3).setCellRenderer(centerRender);
		columnModel.getColumn(4).setPreferredWidth(90);
		columnModel.getColumn(4).setCellRenderer(centerRender);
		columnModel.getColumn(5).setPreferredWidth(90);
		columnModel.getColumn(5).setCellRenderer(centerRender);
		columnModel.getColumn(6).setPreferredWidth(100);
		columnModel.getColumn(6).setCellRenderer(centerRender);

		frmFirePunch.getContentPane().add(tableClientes);
		tableClientes.setDefaultEditor(Cliente.class, null);

		scrollPane = new JScrollPane(tableClientes);
		scrollPane.setBounds(250, 127, 630, 181);
		frmFirePunch.getContentPane().add(scrollPane);

		modelEjercicio.addColumn("ID");
		modelEjercicio.addColumn("Nombre");
		modelEjercicio.addColumn("Series");
		modelEjercicio.addColumn("Repeticiones");
		modelEjercicio.addColumn("Carga (Kg)");
		modelEjercicio.addColumn("Categoria");

		/**
		 * Obtención de los datos para rellenar la tabla de clientes.
		 * 
		 * ejercicios: Lista de ejercicios con todos los valores de la bbdd.
		 * 
		 * categorias: Lista de categorías con todos los valores de la bbdd.
		 */
		ejercicios = ejercicioDAO.selectAllEjercicio();
		categorias = categoriaDAO.selectAllCategoria();

		for (Ejercicio e : ejercicios) {
			Object[] row = new Object[6];
			row[0] = e.getIdEjercicio();
			row[1] = e.getNombre();
			row[2] = e.getSeries();
			row[3] = e.getRepeticiones();
			row[4] = e.getCargaKg();
			for (Categoria c : categorias) {
				c = categoriaDAO.selectCategoriaById(e.getCategoria().getIdCategoria());
				row[5] = c.getNombreCategoria();
			}
			modelEjercicio.addRow(row);
		}

		tableEjercicios = new JTable(modelEjercicio);
		tableEjercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int indiceCategoria = 0;

				int index = tableEjercicios.getSelectedRow();
				TableModel model = tableEjercicios.getModel();

				tfIDEjercicio.setText(model.getValueAt(index, 0).toString());
				tfNombreEjercicio.setText(model.getValueAt(index, 1).toString());
				tfSeriesEjercicio.setText(model.getValueAt(index, 2).toString());
				tfRepeticionesEjercicio.setText(model.getValueAt(index, 3).toString());
				tfCargaEjercicio.setText(model.getValueAt(index, 4).toString());
				switch (model.getValueAt(index, 5).toString()) {
				case "Pierna":
					indiceCategoria = 0;
					break;
				case "Pecho":
					indiceCategoria = 1;
					break;
				case "Espalda":
					indiceCategoria = 2;
					break;
				case "Brazo":
					indiceCategoria = 3;
					break;
				case "Abdomen":
					indiceCategoria = 4;
					break;
				default:
					indiceCategoria = 10;
				}
				cbCategorias.setSelectedIndex(indiceCategoria);

				Ejercicio ej = ejercicioDAO
						.selectEjercicioById(Integer.parseInt(model.getValueAt(index, 0).toString()));
				rutaFoto2 = ej.getFotoPerfil();

				ImageIcon imageIcon = new ImageIcon(rutaFoto2);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaEjercicios.getWidth(),
						lblFotoSubidaEjercicios.getHeight(), Image.SCALE_SMOOTH);
				lblFotoSubidaEjercicios.setIcon(new ImageIcon(image));
				lblFotoSubidaEjercicios.setVisible(true);
			}

		});
		tableEjercicios.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel2 = tableEjercicios.getColumnModel();

		/**
		 * Declaración y asignación de valores relativos al ancho y centrado de datos de
		 * las columnas de la tabla de clientes
		 */
		DefaultTableCellRenderer centerRender2 = new DefaultTableCellRenderer();
		centerRender2.setHorizontalAlignment(JLabel.CENTER);

		columnModel2.getColumn(0).setPreferredWidth(60);
		columnModel2.getColumn(0).setCellRenderer(centerRender2);
		columnModel2.getColumn(1).setPreferredWidth(240);
		columnModel2.getColumn(1).setCellRenderer(centerRender2);
		columnModel2.getColumn(2).setPreferredWidth(60);
		columnModel2.getColumn(2).setCellRenderer(centerRender2);
		columnModel2.getColumn(3).setPreferredWidth(80);
		columnModel2.getColumn(3).setCellRenderer(centerRender2);
		columnModel2.getColumn(4).setPreferredWidth(70);
		columnModel2.getColumn(4).setCellRenderer(centerRender2);
		columnModel2.getColumn(5).setPreferredWidth(70);
		columnModel2.getColumn(5).setCellRenderer(centerRender2);
		frmFirePunch.getContentPane().add(tableEjercicios);
		tableEjercicios.setDefaultEditor(Cliente.class, null);

		scrollPane2 = new JScrollPane(tableEjercicios);
		scrollPane2.setBounds(920, 127, 570, 181);
		frmFirePunch.getContentPane().add(scrollPane2);

		/**
		 * Botón oculto que hace la función de refrescar los datos de las tablas cuando
		 * se realiza alguna acción sobre ellas. Se hace uso de la función doClick del
		 * botón más adelante.
		 */
		JButton btnMostrar = new JButton("New button");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<Cliente> clientes = clienteDAO.selectClientesPorEntrenadorYSinAsignar(
						entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado).getIdEntrenador());
				List<Entrenador> entrenadores = entrenadorDAO.selectAllEntrenador();
				modelCliente.setRowCount(0);
				modelEjercicio.setRowCount(0);
				for (Cliente c : clientes) {
					Object[] row = new Object[7];
					row[0] = c.getIdCliente();
					row[1] = c.getNombre();
					row[2] = c.getApellidos();
					row[3] = c.getEdad();
					row[4] = (int) c.getAltura();
					row[5] = c.getPeso();
					for (Entrenador en : entrenadores) {
						en = entrenadorDAO.selectEntrenadorById(c.getEntrenador().getIdEntrenador());
						row[6] = en.getUsuario();
					}
					modelCliente.addRow(row);
				}

				List<Ejercicio> ejercicios = ejercicioDAO.selectAllEjercicio();
				List<Categoria> categorias = categoriaDAO.selectAllCategoria();
				for (Ejercicio e : ejercicios) {
					Object[] row = new Object[6];
					row[0] = e.getIdEjercicio();
					row[1] = e.getNombre();
					row[2] = e.getSeries();
					row[3] = e.getRepeticiones();
					row[4] = e.getCargaKg();
					for (Categoria c : categorias) {
						c = categoriaDAO.selectCategoriaById(e.getCategoria().getIdCategoria());
						row[5] = c.getNombreCategoria();
					}
					modelEjercicio.addRow(row);
				}

			}
		});
		btnMostrar.setBounds(159, -47, 117, 25);
		frmFirePunch.getContentPane().add(btnMostrar);
		btnMostrar.setVisible(false);

		btnEligeFoto = new JButton("Subir foto");
		btnEligeFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);

				/**
				 * Declaración de un filtro de extensiones permitidas en la subida de archivos
				 */
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
				fileChooser.setFileFilter(filter);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String extension = getFileExtension(selectedFile);

					if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg")
							&& !extension.equalsIgnoreCase("png") && !extension.equalsIgnoreCase("gif")) {
						JOptionPane.showMessageDialog(null,
								"Selecciona una imagen con el formato jpg, jpeg, png o gif, por favor.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Random random = new Random();
						String fileName = "image_" + random.nextInt(1000000) + "." + extension;

						try {
							File destination = new File("src/main/resources/" + fileName);
							rutaFoto = "src/main/resources/" + fileName;
							ImageIcon imageIcon = new ImageIcon(rutaFoto);
							Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaClientes.getWidth(),
									lblFotoSubidaClientes.getHeight(), Image.SCALE_SMOOTH);
							lblFotoSubidaClientes.setIcon(new ImageIcon(image));
							Files.copy(selectedFile.toPath(), destination.toPath());
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnEligeFoto.setBounds(373, 540, 215, 23);
		frmFirePunch.getContentPane().add(btnEligeFoto);

		btnEligeFotoEjercicio = new JButton("Subir foto");
		btnEligeFotoEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);

				/**
				 * Declaración de un filtro de extensiones permitidas en la subida de archivos
				 */
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
				fileChooser.setFileFilter(filter);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();

					String extension = getFileExtension(selectedFile);

					if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg")
							&& !extension.equalsIgnoreCase("png") && !extension.equalsIgnoreCase("gif")) {
						JOptionPane.showMessageDialog(null,
								"Selecciona una imagen con el formato jpg, jpeg, png o gif, por favor.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Random random = new Random();
						String fileName = "image_" + random.nextInt(1000000) + "." + extension;

						try {
							File destination = new File("src/main/resources/" + fileName);
							rutaFoto2 = "src/main/resources/" + fileName;
							ImageIcon imageIcon = new ImageIcon(rutaFoto2);
							Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaClientes.getWidth(),
									lblFotoSubidaClientes.getHeight(), Image.SCALE_SMOOTH);
							lblFotoSubidaClientes.setIcon(new ImageIcon(image));
							Files.copy(selectedFile.toPath(), destination.toPath());
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnEligeFotoEjercicio.setBounds(1070, 540, 220, 23);
		frmFirePunch.getContentPane().add(btnEligeFotoEjercicio);

		btnInsertarCliente = new JButton("Insertar");
		btnInsertarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Comprobación de errores de los campos de cliente. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfNombreCliente.getText().isEmpty() || tfApellidosCliente.getText().isEmpty()
						|| tfAlturaCliente.getText().isEmpty() || tfPesoCliente.getText().isEmpty()
						|| tfEdadCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matNombre = patNombre.matcher(tfNombreCliente.getText());
					Matcher matApellidos = patApellido.matcher(tfApellidosCliente.getText());
					Matcher matEdad = patEdad.matcher(tfEdadCliente.getText());
					Matcher matAltura = patEntero.matcher(tfAlturaCliente.getText());
					Matcher matPeso = patDecimal.matcher(tfPesoCliente.getText());

					if (!matNombre.matches()) {
						JOptionPane.showMessageDialog(null, "El nombre tiene un formato incorrecto.\nEj: Pablo.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (!matApellidos.matches()) {
						JOptionPane.showMessageDialog(null,
								"El apellido tiene un formato incorrecto.\nEj: Molero Marín.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matEdad.matches()) {
						JOptionPane.showMessageDialog(null,
								"La edad no tiene un formato correcto. Prueba con dos dígitos.\nEj: 25.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(tfEdadCliente.getText()) < 15)) {
						JOptionPane.showMessageDialog(null, "No pueden entrar personas menores de 15 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(tfEdadCliente.getText()) > 90)) {
						JOptionPane.showMessageDialog(null, "No pueden entrar personas mayores de 90 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matAltura.matches()) {
						JOptionPane.showMessageDialog(null, "La altura no tiene el formato correcto.\nEj: 180.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfAlturaCliente.getText()) < 130) {
						JOptionPane.showMessageDialog(null,
								"No puede entrar nadie con menos de 130cm de altura.\nEj: 180.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfAlturaCliente.getText()) > 230) {
						JOptionPane.showMessageDialog(null,
								"No puede entrar nadie con más de 230cm de altura.\nEj: 180.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matPeso.matches()) {
						JOptionPane.showMessageDialog(null, "La altura no tiene el formato correcto.\\nEj:45.7.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (Double.parseDouble(tfPesoCliente.getText()) < 35) {
						JOptionPane.showMessageDialog(null, "El peso no puede ser inferior a 35Kg.\\nEj:45.7.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Double.parseDouble(tfPesoCliente.getText()) > 150) {
						JOptionPane.showMessageDialog(null, "El peso no puede ser superior a 150Kg.\\nEj:45.7.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						Entrenador entrenador = entrenadorDAO.selectEntrenadorById(10000);
						Cliente cliente = new Cliente(tfNombreCliente.getText(), tfApellidosCliente.getText(),
								Integer.parseInt(tfEdadCliente.getText()), Integer.parseInt(tfAlturaCliente.getText()),
								Double.parseDouble(tfPesoCliente.getText()), entrenador, rutaFoto);
						clienteDAO.insertCliente(cliente);
						btnMostrar.doClick();
						limpiarCamposHome(tableClientes, tableEjercicios, tfIDCliente, tfNombreCliente, tfEdadCliente,
								tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
								tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblFotoSubidaClientes,
								lblFotoSubidaEjercicios);
						JOptionPane.showMessageDialog(null, "Cliente creado");
					}
				}
			}
		});
		btnInsertarCliente.setBounds(275, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnInsertarCliente);

		btnInsertarEjercicio = new JButton("Insertar");
		btnInsertarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Comprobación de errores de los campos de ejercicio. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfCargaEjercicio.getText().isEmpty() || tfRepeticionesEjercicio.getText().isEmpty()
						|| tfSeriesEjercicio.getText().isEmpty() || tfNombreEjercicio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matCarga = patDecimal.matcher(tfCargaEjercicio.getText());
					Matcher matRepticiones = patEntero.matcher(tfRepeticionesEjercicio.getText());
					Matcher matSeries = patEntero.matcher(tfSeriesEjercicio.getText());
					if (!matCarga.matches()) {
						JOptionPane.showMessageDialog(null,
								"La carga del ejercicio tiene un formato incorrecto.\nEj: 12.0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matRepticiones.matches()) {
						JOptionPane.showMessageDialog(null,
								"Las repeticiones del ejercicio tiene un formato incorrecto.\nEj: 10", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matSeries.matches()) {
						JOptionPane.showMessageDialog(null,
								"Las series del ejercicio tiene un formato incorrecto.\nEj: 4", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {

						Categoria categoria = categoriaDAO.selectCategoriaById(cbCategorias.getSelectedIndex() + 1);

						Ejercicio ejercicio = new Ejercicio(tfNombreEjercicio.getText(),
								Integer.parseInt(tfSeriesEjercicio.getText()),
								Integer.parseInt(tfRepeticionesEjercicio.getText()),
								Double.parseDouble(tfCargaEjercicio.getText()), categoria, rutaFoto2);
						ejercicioDAO.insertEjercicio(ejercicio);
						btnMostrar.doClick();
						btnLimpiar.doClick();
						JOptionPane.showMessageDialog(null, "Ejercicio creado");
					}
				}
			}
		});
		btnInsertarEjercicio.setBounds(960, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnInsertarEjercicio);

		btnActualizarEjercicio = new JButton("Actualizar");
		btnActualizarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Comprobación de errores de los campos de ejercicio. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfCargaEjercicio.getText().isEmpty() || tfRepeticionesEjercicio.getText().isEmpty()
						|| tfSeriesEjercicio.getText().isEmpty() || tfNombreEjercicio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matCarga = patDecimal.matcher(tfCargaEjercicio.getText());
					Matcher matRepticiones = patEntero.matcher(tfRepeticionesEjercicio.getText());
					Matcher matSeries = patEntero.matcher(tfSeriesEjercicio.getText());
					if (!matCarga.matches()) {
						JOptionPane.showMessageDialog(null,
								"La carga del ejercicio tiene un formato incorrecto.\nEj: 12.0", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matRepticiones.matches()) {
						JOptionPane.showMessageDialog(null,
								"Las repeticiones del ejercicio tiene un formato incorrecto.\nEj: 10", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matSeries.matches()) {
						JOptionPane.showMessageDialog(null,
								"Las series del ejercicio tiene un formato incorrecto.\nEj: 4", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Categoria categoria = categoriaDAO.selectCategoriaById(cbCategorias.getSelectedIndex() + 1);

						Ejercicio ejercicioActualizar = ejercicioDAO
								.selectEjercicioById(Integer.parseInt(tfIDEjercicio.getText()));
						ejercicioActualizar.setIdEjercicio(Integer.parseInt(tfIDEjercicio.getText()));
						ejercicioActualizar.setNombre(tfNombreEjercicio.getText());
						ejercicioActualizar.setSeries(Integer.parseInt(tfSeriesEjercicio.getText()));
						ejercicioActualizar.setRepeticiones(Integer.parseInt(tfRepeticionesEjercicio.getText()));
						ejercicioActualizar.setCargaKg(Double.parseDouble(tfCargaEjercicio.getText()));
						ejercicioActualizar.setCategoria(categoria);
						if (ejercicioActualizar.getFotoPerfil()==null) {
							ejercicioActualizar.setFotoPerfil(rutaFoto2);
						} else {
							ejercicioActualizar.setFotoPerfil(ejercicioActualizar.getFotoPerfil());
						}

						ejercicioDAO.updateEjercicio(ejercicioActualizar);
						btnMostrar.doClick();
						btnLimpiar.doClick();
						JOptionPane.showMessageDialog(null, "Ejercicio actualizado");
					}
				}
			}
		});
		btnActualizarEjercicio.setBounds(1108, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnActualizarEjercicio);

		btnActualizarCliente = new JButton("Actualizar");
		btnActualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Comprobación de errores de los campos de cliente. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfNombreCliente.getText().isEmpty() || tfApellidosCliente.getText().isEmpty()
						|| tfAlturaCliente.getText().isEmpty() || tfPesoCliente.getText().isEmpty()
						|| tfEdadCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matNombre = patNombre.matcher(tfNombreCliente.getText());
					Matcher matApellidos = patApellido.matcher(tfApellidosCliente.getText());
					Matcher matEdad = patEdad.matcher(tfEdadCliente.getText());
					Matcher matAltura = patEntero.matcher(tfAlturaCliente.getText());
					Matcher matPeso = patDecimal.matcher(tfPesoCliente.getText());

					if (!matNombre.matches()) {
						JOptionPane.showMessageDialog(null, "El nombre tiene un formato incorrecto.\nEj: Pablo.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (!matApellidos.matches()) {
						JOptionPane.showMessageDialog(null,
								"El apellido tiene un formato incorrecto.\nEj: Molero Marín.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matEdad.matches()) {
						JOptionPane.showMessageDialog(null,
								"La edad no tiene un formato correcto. Prueba con dos dígitos.\nEj: 25.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(tfEdadCliente.getText()) < 15)) {
						JOptionPane.showMessageDialog(null, "No pueden entrar personas menores de 15 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(tfEdadCliente.getText()) > 90)) {
						JOptionPane.showMessageDialog(null, "No pueden entrar personas mayores de 90 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matAltura.matches()) {
						JOptionPane.showMessageDialog(null, "La altura no tiene el formato correcto.\nEj: 180.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfAlturaCliente.getText()) < 130) {
						JOptionPane.showMessageDialog(null,
								"No puede entrar nadie con menos de 130cm de altura.\nEj: 180.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfAlturaCliente.getText()) > 230) {
						JOptionPane.showMessageDialog(null,
								"No puede entrar nadie con más de 230cm de altura.\nEj: 180.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matPeso.matches()) {
						JOptionPane.showMessageDialog(null, "La altura no tiene el formato correcto.\\nEj:45.7.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (Double.parseDouble(tfPesoCliente.getText()) < 35) {
						JOptionPane.showMessageDialog(null, "El peso no puede ser inferior a 35Kg.\\nEj:45.7.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Double.parseDouble(tfPesoCliente.getText()) > 150) {
						JOptionPane.showMessageDialog(null, "El peso no puede ser superior a 150Kg.\\nEj:45.7.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {

						Cliente clienteActualizar = clienteDAO
								.selectClienteById(Integer.parseInt(tfIDCliente.getText()));
						if (clienteActualizar.getEntrenador().getIdEntrenador() == 10000) {
							Entrenador entrenador = entrenadorDAO.selectEntrenadorById(10000);
							clienteActualizar.setEntrenador(entrenador);
						} else {
							Entrenador entrenador = entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado);
							clienteActualizar.setEntrenador(entrenador);
						}

						clienteActualizar.setIdCliente(Integer.parseInt(tfIDCliente.getText()));
						clienteActualizar.setNombre(tfNombreCliente.getText());
						clienteActualizar.setApellidos(tfApellidosCliente.getText());
						clienteActualizar.setEdad(Integer.parseInt(tfEdadCliente.getText()));
						clienteActualizar.setAltura(Integer.parseInt(tfAlturaCliente.getText()));
						clienteActualizar.setPeso(Double.parseDouble(tfPesoCliente.getText()));
						if (clienteActualizar.getFotoPerfil()==null) {
							clienteActualizar.setFotoPerfil(rutaFoto);
						} else {
							clienteActualizar.setFotoPerfil(clienteActualizar.getFotoPerfil());
						}
						clienteDAO.updateCliente(clienteActualizar);
						btnMostrar.doClick();
						limpiarCamposHome(tableClientes, tableEjercicios, tfIDCliente, tfNombreCliente, tfEdadCliente,
								tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
								tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblFotoSubidaClientes,
								lblFotoSubidaEjercicios);
						JOptionPane.showMessageDialog(null, "Cliente actualizado");
					}
				}
			}
		});
		btnActualizarCliente.setBounds(436, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnActualizarCliente);

		btnBorrarCliente = new JButton("Borrar");
		btnBorrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Si el campo del ID está vacío no deja realizar el borrado.
				 */
				if (tfIDCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente para eliminarlo.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					clienteDAO.deleteCliente(Integer.parseInt(tfIDCliente.getText()));
					btnMostrar.doClick();
					btnLimpiar.doClick();
					JOptionPane.showMessageDialog(null, "Cliente borrado");
				}
			}
		});
		btnBorrarCliente.setBounds(565, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnBorrarCliente);

		btnBorrarEjercicio = new JButton("Borrar");
		btnBorrarEjercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * Si el campo del ID está vacío no deja realizar el borrado.
				 */
				if (tfIDEjercicio.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecciona un ejercicio para eliminarlo.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ejercicioDAO.deleteEjercicio(Integer.parseInt(tfIDEjercicio.getText()));
					btnMostrar.doClick();
					btnLimpiar.doClick();
					JOptionPane.showMessageDialog(null, "Ejercicio borrado");
				}
			}
		});
		btnBorrarEjercicio.setBounds(1250, 628, 117, 25);
		frmFirePunch.getContentPane().add(btnBorrarEjercicio);

		btnAsignarmeCliente = new JButton("Asignarme cliente");
		btnAsignarmeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Asignación de un cliente sin entrenador al entrenador que haya hecho el
				 * login. Si ya tiene entrenador o el campo del ID está en blanco no deja hacer
				 * la acción.
				 */
				Entrenador entrenador = entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado);
				Cliente clienteActualizar = clienteDAO.selectClienteById(Integer.parseInt(tfIDCliente.getText()));
				if (tfIDCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente para asignarte como entrenador.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else if (entrenador.getNombre() == clienteActualizar.getEntrenador().getNombre()) {
					JOptionPane.showMessageDialog(null, "Ya tienes entrenas a este cliente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					clienteActualizar.setEntrenador(entrenador);
					clienteDAO.updateCliente(clienteActualizar);
					btnMostrar.doClick();
					btnLimpiar.doClick();
					JOptionPane.showMessageDialog(null, "Cliente actualizado");
				}
			}
		});
		btnAsignarmeCliente.setBounds(373, 583, 215, 23);
		frmFirePunch.getContentPane().add(btnAsignarmeCliente);

		btnDesasignarmeCliente = new JButton("Deasignarme cliente");
		btnDesasignarmeCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Desasignación de un cliente con entrenador. Si no tiene entrenador o el campo
				 * del ID está en blanco no deja hacer la acción.
				 */
				Entrenador entrenador = entrenadorDAO.selectEntrenadorById(10000);
				Cliente clienteActualizar = clienteDAO.selectClienteById(Integer.parseInt(tfIDCliente.getText()));
				if (tfIDCliente.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecciona un cliente para desasignarte como entrenador.",
							"Error", JOptionPane.ERROR_MESSAGE);
				} else if (entrenador.getNombre() != clienteActualizar.getEntrenador().getNombre()) {
					JOptionPane.showMessageDialog(null, "No entrenas a este cliente.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					clienteActualizar.setEntrenador(entrenador);
					clienteDAO.updateCliente(clienteActualizar);
					btnMostrar.doClick();
					btnLimpiar.doClick();
					JOptionPane.showMessageDialog(null, "Cliente actualizado");
				}
			}
		});
		btnDesasignarmeCliente.setBounds(373, 540, 215, 23);
		frmFirePunch.getContentPane().add(btnDesasignarmeCliente);
		btnDesasignarmeCliente.setVisible(false);

		/**
		 * Declaración de los campos relativos a clientes y ejercicios.
		 */

		tfIDCliente = new JTextField();
		tfIDCliente.setEditable(false);
		tfIDCliente.setBounds(368, 342, 220, 19);
		frmFirePunch.getContentPane().add(tfIDCliente);
		tfIDCliente.setColumns(10);

		tfNombreCliente = new JTextField();
		tfNombreCliente.setColumns(10);
		tfNombreCliente.setBounds(368, 374, 220, 19);
		frmFirePunch.getContentPane().add(tfNombreCliente);

		tfEdadCliente = new JTextField();
		tfEdadCliente.setColumns(10);
		tfEdadCliente.setBounds(370, 436, 220, 19);
		frmFirePunch.getContentPane().add(tfEdadCliente);

		tfAlturaCliente = new JTextField();
		tfAlturaCliente.setColumns(10);
		tfAlturaCliente.setBounds(370, 467, 220, 19);
		frmFirePunch.getContentPane().add(tfAlturaCliente);

		tfPesoCliente = new JTextField();
		tfPesoCliente.setColumns(10);
		tfPesoCliente.setBounds(370, 500, 220, 19);
		frmFirePunch.getContentPane().add(tfPesoCliente);

		tfIDEjercicio = new JTextField();
		tfIDEjercicio.setEditable(false);
		tfIDEjercicio.setColumns(10);
		tfIDEjercicio.setBounds(1070, 342, 220, 19);
		frmFirePunch.getContentPane().add(tfIDEjercicio);

		tfNombreEjercicio = new JTextField();
		tfNombreEjercicio.setColumns(10);
		tfNombreEjercicio.setBounds(1070, 374, 220, 19);
		frmFirePunch.getContentPane().add(tfNombreEjercicio);

		tfSeriesEjercicio = new JTextField();
		tfSeriesEjercicio.setColumns(10);
		tfSeriesEjercicio.setBounds(1070, 405, 220, 19);
		frmFirePunch.getContentPane().add(tfSeriesEjercicio);

		tfRepeticionesEjercicio = new JTextField();
		tfRepeticionesEjercicio.setColumns(10);
		tfRepeticionesEjercicio.setBounds(1070, 436, 220, 19);
		frmFirePunch.getContentPane().add(tfRepeticionesEjercicio);

		tfCargaEjercicio = new JTextField();
		tfCargaEjercicio.setColumns(10);
		tfCargaEjercicio.setBounds(1070, 469, 220, 19);
		frmFirePunch.getContentPane().add(tfCargaEjercicio);

		tfApellidosCliente = new JTextField();
		tfApellidosCliente.setColumns(10);
		tfApellidosCliente.setBounds(370, 405, 220, 19);
		frmFirePunch.getContentPane().add(tfApellidosCliente);

		lblIDCliente = new JLabel("id");
		lblIDCliente.setBounds(275, 344, 70, 15);
		frmFirePunch.getContentPane().add(lblIDCliente);

		lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(275, 376, 70, 15);
		frmFirePunch.getContentPane().add(lblNombreCliente);

		lblApellidosCliente = new JLabel("Apellidos");
		lblApellidosCliente.setBounds(275, 407, 70, 15);
		frmFirePunch.getContentPane().add(lblApellidosCliente);

		lblEdadCliente = new JLabel("Edad");
		lblEdadCliente.setBounds(275, 438, 70, 15);
		frmFirePunch.getContentPane().add(lblEdadCliente);

		lblAlturaCliente = new JLabel("Altura (cm)");
		lblAlturaCliente.setBounds(275, 469, 70, 15);
		frmFirePunch.getContentPane().add(lblAlturaCliente);

		lblPesoCliente = new JLabel("Peso (Kg)");
		lblPesoCliente.setBounds(275, 502, 70, 15);
		frmFirePunch.getContentPane().add(lblPesoCliente);

		lblCargakg = new JLabel("Carga (Kg)");
		lblCargakg.setBounds(959, 476, 89, 15);
		frmFirePunch.getContentPane().add(lblCargakg);

		lblRepeticiones = new JLabel("Repeticiones");
		lblRepeticiones.setBounds(959, 439, 106, 15);
		frmFirePunch.getContentPane().add(lblRepeticiones);

		lblSeries = new JLabel("Series");
		lblSeries.setBounds(959, 408, 70, 15);
		frmFirePunch.getContentPane().add(lblSeries);

		lblNombreEjercicio = new JLabel("Nombre");
		lblNombreEjercicio.setBounds(959, 377, 70, 15);
		frmFirePunch.getContentPane().add(lblNombreEjercicio);

		lblIDEjercicio = new JLabel("id");
		lblIDEjercicio.setBounds(959, 345, 70, 15);
		frmFirePunch.getContentPane().add(lblIDEjercicio);

		lblFotoCliente = new JLabel("Foto");
		lblFotoCliente.setBounds(275, 544, 70, 15);
		frmFirePunch.getContentPane().add(lblFotoCliente);

		lblFotoEjercicio = new JLabel("Foto");
		lblFotoEjercicio.setBounds(959, 544, 70, 15);
		frmFirePunch.getContentPane().add(lblFotoEjercicio);

		/**
		 * Declaración de los campos relativos al menú lateral.
		 */
		lblFondoMenu = new JLabel("");
		lblFondoMenu.setBackground(Color.DARK_GRAY);
		lblFondoMenu.setBounds(0, 0, 227, 833);

		lblMenu = new JLabel("MENU");
		lblMenu.setForeground(new Color(252, 61, 3));
		lblMenu.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMenu.setBounds(48, 86, 89, 25);
		frmFirePunch.getContentPane().add(lblMenu);

		lblHome = new JLabel("HOME");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHome.setForeground(Color.WHITE);
				lblPerfil.setForeground(Color.GRAY);
				lblEntrenar.setForeground(Color.GRAY);
				lblOpciones.setForeground(Color.GRAY);

				/* mostrar ventana */
				verHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
						tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
						btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
						btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente,
						lblApellidosCliente, lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg,
						lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio, lblFotoCliente,
						lblFotoEjercicio, btnAsignarmeCliente);
				mostrarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

				/* ocultar ventanas */
				ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
						tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil,
						lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil,
						btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom,
						lblMostrarNombrePerfil, btnEligeFotoPerfil);
				ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
				ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
						tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
						scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
						lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar,
						lblAlturaClienteEntrenar, lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar,
						lblSeriesEntrenar, lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar,
						btnDejarDeEntrenar, btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
						tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar,
						tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar,
						tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar,
						lblFotoSubidaEjerciciosEntrenar, lblFotoSubidaRutinaEntrenar);

				limpiarCamposHome(tableClientes, tableEjercicios, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblFotoSubidaClientes,
						lblFotoSubidaEjercicios);

			}
		});
		lblHome.setForeground(Color.WHITE);
		lblHome.setFont(new Font("Dialog", Font.BOLD, 20));
		lblHome.setBounds(48, 197, 89, 25);
		frmFirePunch.getContentPane().add(lblHome);

		lblPerfil = new JLabel("PERFIL");
		lblPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHome.setForeground(Color.GRAY);
				lblPerfil.setForeground(Color.WHITE);
				lblEntrenar.setForeground(Color.GRAY);
				lblOpciones.setForeground(Color.GRAY);

				/* mostrar ventana */
				verPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
						tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil,
						lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil,
						btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom,
						lblMostrarNombrePerfil, btnEligeFotoPerfil);
				mostrarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

				/* ocultar ventanas */
				ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
						tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
						btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
						btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente,
						lblApellidosCliente, lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg,
						lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio, lblFotoCliente,
						lblFotoEjercicio, btnAsignarmeCliente);
				ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
				ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
						tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
						scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
						lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar,
						lblAlturaClienteEntrenar, lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar,
						lblSeriesEntrenar, lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar,
						btnDejarDeEntrenar, btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
						tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar,
						tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar,
						tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar,
						lblFotoSubidaEjerciciosEntrenar, lblFotoSubidaRutinaEntrenar);

				ImageIcon imageFotoPerfil = new ImageIcon(
						entrenadorDAO.selectEntrenadorByUserName(tfUsuarioEntrenador.getText()).getFotoPerfil());
				Image imagePerfilFoto = imageFotoPerfil.getImage().getScaledInstance(lblFotoPerfil.getWidth(),
						lblFotoPerfil.getHeight(), Image.SCALE_SMOOTH);
				lblFotoPerfil.setIcon(new ImageIcon(imagePerfilFoto));
			}
		});
		lblPerfil.setForeground(Color.GRAY);
		lblPerfil.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPerfil.setBounds(48, 308, 89, 25);
		frmFirePunch.getContentPane().add(lblPerfil);

		lblOpciones = new JLabel("OPCIONES");
		lblOpciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHome.setForeground(Color.GRAY);
				lblPerfil.setForeground(Color.GRAY);
				lblEntrenar.setForeground(Color.GRAY);
				lblOpciones.setForeground(Color.WHITE);

				verOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
				mostrarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

				/* ocultar ventanas */
				ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
						tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
						btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
						btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente,
						lblApellidosCliente, lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg,
						lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio, lblFotoCliente,
						lblFotoEjercicio, btnAsignarmeCliente);
				ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
						tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil,
						lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil,
						btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom,
						lblMostrarNombrePerfil, btnEligeFotoPerfil);
				ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
						tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
						scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
						lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar,
						lblAlturaClienteEntrenar, lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar,
						lblSeriesEntrenar, lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar,
						btnDejarDeEntrenar, btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
						tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar,
						tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar,
						tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar,
						lblFotoSubidaEjerciciosEntrenar, lblFotoSubidaRutinaEntrenar);

			}
		});
		lblOpciones.setForeground(Color.GRAY);
		lblOpciones.setFont(new Font("Dialog", Font.BOLD, 20));
		lblOpciones.setBounds(48, 530, 130, 25);
		frmFirePunch.getContentPane().add(lblOpciones);

		lblEntrenar = new JLabel("ENTRENAR");
		lblEntrenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblHome.setForeground(Color.GRAY);
				lblPerfil.setForeground(Color.GRAY);
				lblEntrenar.setForeground(Color.WHITE);
				lblOpciones.setForeground(Color.GRAY);

				verEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
						tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
						scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
						lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar,
						lblAlturaClienteEntrenar, lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar,
						lblSeriesEntrenar, lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar,
						btnDejarDeEntrenar, btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
						tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar,
						tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar,
						tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar);
				mostrarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

				/* ocultar ventanas */
				ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
						tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
						btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
						btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente,
						lblApellidosCliente, lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg,
						lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio, lblFotoCliente,
						lblFotoEjercicio, btnAsignarmeCliente);
				ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
				ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
						tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil,
						lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil,
						btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom,
						lblMostrarNombrePerfil, btnEligeFotoPerfil);
				btnMostrarEntrenar.doClick();
				limpiarCamposEntrenar(tableClientesEntrenar, tableEjerciciosEntrenar, tableRealizaEntrenar,
						tfIDClienteEntrenar, tfNombreClienteEntrenar, tfEdadClienteEntrenar, tfAlturaClienteEntrenar,
						tfPesoClienteEntrenar, tfIDEjercicioEntrenar, tfNombreEjercicioEntrenar,
						tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar, tfCargaEjercicioEntrenar,
						tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar, lblFotoSubidaEjerciciosEntrenar,
						lblFotoSubidaRutinaEntrenar);
			}
		});
		lblEntrenar.setForeground(Color.GRAY);
		lblEntrenar.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEntrenar.setBounds(48, 419, 130, 25);
		frmFirePunch.getContentPane().add(lblEntrenar);

		lblLogoApp = new JLabel("");
		lblLogoApp.setBounds(48, 641, 131, 107);
		ImageIcon imageIconLogo = new ImageIcon("src/main/resources/logo.png");
		Image imageLogoApp = imageIconLogo.getImage().getScaledInstance(lblLogoApp.getWidth(), lblLogoApp.getHeight(),
				Image.SCALE_SMOOTH);
		lblLogoApp.setIcon(new ImageIcon(imageLogoApp));
		frmFirePunch.getContentPane().add(lblLogoApp);

		ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenu.png");
		Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
				Image.SCALE_SMOOTH);
		lblFondoMenu.setIcon(new ImageIcon(image));
		frmFirePunch.getContentPane().add(lblFondoMenu);

		ocultarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

		/* Ventana de Perfil de entrenador */
		lblPerfilUsuario = new JLabel("Perfil del entrenador");
		lblPerfilUsuario.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPerfilUsuario.setBounds(750, 55, 275, 33);
		frmFirePunch.getContentPane().add(lblPerfilUsuario);

		lblFotoPerfil = new JLabel("");
		lblFotoPerfil.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		lblFotoPerfil.setBounds(295, 147, 170, 170);
		ImageIcon imageFotoPerfil = new ImageIcon("src/main/resources/fotoPerfil.png");
		Image imagePerfilFoto = imageFotoPerfil.getImage().getScaledInstance(lblFotoPerfil.getWidth(),
				lblFotoPerfil.getHeight(), Image.SCALE_SMOOTH);
		lblFotoPerfil.setIcon(new ImageIcon(imagePerfilFoto));
		frmFirePunch.getContentPane().add(lblFotoPerfil);

		lblEntrenadorPerfil = new JLabel("Nombre");
		lblEntrenadorPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEntrenadorPerfil.setBounds(603, 149, 66, 20);
		frmFirePunch.getContentPane().add(lblEntrenadorPerfil);

		tfNombrePerfil = new JTextField();
		tfNombrePerfil.setColumns(10);
		tfNombrePerfil.setBounds(740, 147, 349, 20);
		frmFirePunch.getContentPane().add(tfNombrePerfil);

		lblApellidosPerfil = new JLabel("Apellidos");
		lblApellidosPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidosPerfil.setBounds(603, 204, 90, 19);
		frmFirePunch.getContentPane().add(lblApellidosPerfil);

		tfApellidosPerfil = new JTextField();
		tfApellidosPerfil.setColumns(10);
		tfApellidosPerfil.setBounds(740, 200, 349, 20);
		frmFirePunch.getContentPane().add(tfApellidosPerfil);

		lblContraPerfil = new JLabel("Contraseña");
		lblContraPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraPerfil.setBounds(603, 415, 135, 14);
		frmFirePunch.getContentPane().add(lblContraPerfil);

		lblEdadPerfil = new JLabel("Edad");
		lblEdadPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdadPerfil.setBounds(603, 256, 66, 14);
		frmFirePunch.getContentPane().add(lblEdadPerfil);

		tfEdadPerfil = new JTextField();
		tfEdadPerfil.setColumns(10);
		tfEdadPerfil.setBounds(740, 250, 349, 20);
		frmFirePunch.getContentPane().add(tfEdadPerfil);

		tfUsuarioPerfil = new JTextField();
		tfUsuarioPerfil.setColumns(10);
		tfUsuarioPerfil.setBounds(740, 303, 349, 20);
		frmFirePunch.getContentPane().add(tfUsuarioPerfil);

		lblUsuarioPerfil = new JLabel("Usuario");
		lblUsuarioPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuarioPerfil.setBounds(603, 309, 66, 14);
		frmFirePunch.getContentPane().add(lblUsuarioPerfil);

		lblEmailPerfil = new JLabel("Email");
		lblEmailPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailPerfil.setBounds(603, 360, 66, 14);
		frmFirePunch.getContentPane().add(lblEmailPerfil);

		tfEmailPerfil = new JTextField();
		tfEmailPerfil.setColumns(10);
		tfEmailPerfil.setBounds(740, 354, 349, 20);
		frmFirePunch.getContentPane().add(tfEmailPerfil);

		tfContraPerfil = new JTextField();
		tfContraPerfil.setColumns(10);
		tfContraPerfil.setBounds(740, 409, 349, 20);
		frmFirePunch.getContentPane().add(tfContraPerfil);

		lblSubirFotoPerfil = new JLabel("Subir foto");
		lblSubirFotoPerfil.setBounds(603, 467, 105, 15);
		lblSubirFotoPerfil.setFont(new Font("Tahoma", Font.BOLD, 15));
		frmFirePunch.getContentPane().add(lblSubirFotoPerfil);

		btnEligeFotoPerfil = new JButton("Elige la foto");
		btnEligeFotoPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * Declaración de un filtro de extensiones permitidas en la subida de archivos
				 */
				JFileChooser fileChooser = new JFileChooser();
				int returnValue = fileChooser.showOpenDialog(null);

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
				fileChooser.setFileFilter(filter);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String filePath = selectedFile.getAbsolutePath();
					rutaFoto4 = filePath;

					ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());
					Image image = imageIcon.getImage().getScaledInstance(lblFotoPerfil.getWidth(),
							lblFotoPerfil.getHeight(), Image.SCALE_SMOOTH);
					lblFotoPerfil.setIcon(new ImageIcon(image));

					String extension = getFileExtension(selectedFile);
					if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("jpeg")
							&& !extension.equalsIgnoreCase("png") && !extension.equalsIgnoreCase("gif")) {
						JOptionPane.showMessageDialog(null,
								"Selecciona una imagen con el formato jpg, jpeg, png o gif, por favor.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Random random = new Random();
						String fileName = "image_" + random.nextInt(1000000) + "." + extension;

						try {
							File destination = new File("src/main/resources/" + fileName);
							rutaFoto4 = "src/main/resources/" + fileName;
							Files.copy(selectedFile.toPath(), destination.toPath());
						} catch (IOException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnEligeFotoPerfil.setBounds(740, 465, 349, 23);
		frmFirePunch.getContentPane().add(btnEligeFotoPerfil);

		btnActualizarEntrenador = new JButton("Actualizar información");
		btnActualizarEntrenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Comprobación de errores de los campos del entrenador. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfNombrePerfil.getText().isEmpty() || tfApellidosPerfil.getText().isEmpty()
						|| tfEdadPerfil.getText().isEmpty() || tfUsuarioPerfil.getText().isEmpty()
						|| tfEmailPerfil.getText().isEmpty() || tfContraPerfil.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matNombre = patNombre.matcher(tfNombrePerfil.getText());
					Matcher matApellidos = patApellido.matcher(tfApellidosPerfil.getText());
					Matcher matEdad = patEdad.matcher(tfEdadPerfil.getText());
					Matcher matEmail = patEmail.matcher(tfEmailPerfil.getText());

					if (!matNombre.matches()) {
						JOptionPane.showMessageDialog(null, "El nombre tiene un formato incorrecto.\nEj: Pablo",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (!matApellidos.matches()) {
						JOptionPane.showMessageDialog(null,
								"Los apellidos tienen un formato incorrecto.\nEj: Molero Marín", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matEdad.matches()) {
						JOptionPane.showMessageDialog(null, "La edad tiene un formato incorrecto.\nEj: 25", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if ((Integer.parseInt(tfEdadPerfil.getText()) < 18)
							|| (Integer.parseInt(tfEdadPerfil.getText()) > 60)) {
						JOptionPane.showMessageDialog(null,
								"No pueden haber entrenadores menores de 18 años ni mayores de 60.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matEmail.matches()) {
						JOptionPane.showMessageDialog(null,
								"El email tiene un formato incorrecto.\nEj:firepunchfitnessclub@soporte.com", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Entrenador entrenador = entrenadorDAO.selectEntrenadorByUserName(tfUsuarioPerfil.getText());
						entrenador.setNombre(tfNombrePerfil.getText());
						entrenador.setApellidos(tfApellidosPerfil.getText());
						entrenador.setEdad(Integer.parseInt(tfEdadPerfil.getText()));
						entrenador.setUsuario(tfUsuarioPerfil.getText());
						entrenador.setEmail(tfEmailPerfil.getText());
						entrenador.setContrasenya(entrenadorDAO.codificarContra(tfContraPerfil.getText()));
						if (entrenador.getFotoPerfil()==null) {
							entrenador.setFotoPerfil(rutaFoto4);
						} else {
							entrenador.setFotoPerfil(entrenador.getFotoPerfil());
						}

						ImageIcon imageFotoPerfil = new ImageIcon(rutaFoto4);
						Image imagePerfilFoto = imageFotoPerfil.getImage().getScaledInstance(lblFotoPerfil.getWidth(),
								lblFotoPerfil.getHeight(), Image.SCALE_SMOOTH);
						lblFotoPerfil.setIcon(new ImageIcon(imagePerfilFoto));

						JOptionPane.showMessageDialog(null,
								"Información cambiada del entrenador " + tfUsuarioPerfil.getText());
					}
				}
			}
		});
		btnActualizarEntrenador.setBounds(603, 526, 486, 35);
		btnActualizarEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmFirePunch.getContentPane().add(btnActualizarEntrenador);

		btnBorrarEntrenador = new JButton("Eliminar entrenador");
		btnBorrarEntrenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int result = JOptionPane.showConfirmDialog(null,
						"Si se borra el usuario, se pierde toda su información. NO HAY VUELTA ATRAS", "ATENCION",
						JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					// Acción si se hace clic en OK
					Entrenador entrenador = entrenadorDAO.selectEntrenadorByUserName(tfUsuarioPerfil.getText());
					entrenadorDAO.deleteEntrenador(entrenador.getIdEntrenador());

					JOptionPane.showMessageDialog(null,
							"Se ha borrado al entrenador. Serás redireccionado a la pantalla de inicio de sesión");

					ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
							tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2,
							btnEligeFoto, btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio,
							btnActualizarCliente, btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente,
							tfEdadCliente, tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio,
							tfSeriesEjercicio, tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente,
							lblIDCliente, lblNombreCliente, lblApellidosCliente, lblEdadCliente, lblAlturaCliente,
							lblPesoCliente, lblCargakg, lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio,
							lblFotoCliente, lblFotoEjercicio, btnAsignarmeCliente);
					ocultarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);
					verLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador, lblFondoLogin,
							lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin, btnVerRegistro,
							btnInicioSesion);

					ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
							tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar,
							tableEjerciciosEntrenar, scrollPane2Entrenar, tableRealizaEntrenar,
							scrollPane3EntrenarEntrenar, lblIDClienteEntrenar, lblNombreClienteEntrenar,
							lblApellidosClienteEntrenar, lblEdadClienteEntrenar, lblAlturaClienteEntrenar,
							lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar, lblSeriesEntrenar,
							lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar, btnDejarDeEntrenar,
							btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
							tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar,
							tfIDEjercicioEntrenar, tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar,
							tfRepeticionesEjercicioEntrenar, tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar,
							lblFotoSubidaClientesEntrenar, lblFotoSubidaEjerciciosEntrenar,
							lblFotoSubidaRutinaEntrenar);

					ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
					ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil,
							lblApellidosPerfil, tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil,
							tfUsuarioPerfil, lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil,
							lblSubirFotoPerfil, btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion,
							lblFotoTioRandom, lblMostrarNombrePerfil, btnEligeFotoPerfil);

					tfUsuarioEntrenador.setText("");
					tfContraEntrenador.setText("");

				} else if (result == JOptionPane.CANCEL_OPTION) {
					// No se realiza ninguna acción si se hace clic en Cancel
				}
			}
		});
		btnBorrarEntrenador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBorrarEntrenador.setBounds(603, 583, 486, 35);
		frmFirePunch.getContentPane().add(btnBorrarEntrenador);
		btnCerrarSesion = new JButton("Cerrar Sesión");
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Se ha cerrado la sesión. Serás redireccionado a la pantalla de inicio de sesión");

				ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
						tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
						btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
						btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
						tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
						tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente,
						lblApellidosCliente, lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg,
						lblRepeticiones, lblSeries, lblNombreEjercicio, lblIDEjercicio, lblFotoCliente,
						lblFotoEjercicio, btnAsignarmeCliente);
				ocultarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);
				verLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador, lblFondoLogin,
						lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin, btnVerRegistro,
						btnInicioSesion);

				ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
						tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
						scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
						lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar,
						lblAlturaClienteEntrenar, lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar,
						lblSeriesEntrenar, lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar,
						btnDejarDeEntrenar, btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar,
						tfEdadClienteEntrenar, tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar,
						tfNombreEjercicioEntrenar, tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar,
						tfCargaEjercicioEntrenar, tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar,
						lblFotoSubidaEjerciciosEntrenar, lblFotoSubidaRutinaEntrenar);

				ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);
				ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
						tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil,
						lblUsuarioPerfil, lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil,
						btnActualizarEntrenador, btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom,
						lblMostrarNombrePerfil, btnEligeFotoPerfil);

				tfUsuarioEntrenador.setText("");
				tfContraEntrenador.setText("");
			}
		});
		btnCerrarSesion.setBounds(782, 640, 142, 35);
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmFirePunch.getContentPane().add(btnCerrarSesion);

		lblFotoTioRandom = new JLabel("");
		lblFotoTioRandom.setBounds(1180, 147, 285, 528);
		ImageIcon imageTioEntrenando = new ImageIcon("src/main/resources/tioEntrenando.png");
		Image imageEntrenando = imageTioEntrenando.getImage().getScaledInstance(lblFotoTioRandom.getWidth(),
				lblFotoTioRandom.getHeight(), Image.SCALE_SMOOTH);
		lblFotoTioRandom.setIcon(new ImageIcon(imageEntrenando));
		frmFirePunch.getContentPane().add(lblFotoTioRandom);

		lblMostrarNombrePerfil = new JLabel("Foto del entrenador");
		lblMostrarNombrePerfil.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMostrarNombrePerfil.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarNombrePerfil.setAlignmentY(Component.TOP_ALIGNMENT);
		lblMostrarNombrePerfil.setBounds(305, 330, 160, 15);
		frmFirePunch.getContentPane().add(lblMostrarNombrePerfil);

		/* ventana de Opciones de la aplicación */

		lblPersonalizacionApp = new JLabel("Personalización de la app");
		lblPersonalizacionApp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalizacionApp.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPersonalizacionApp.setBounds(750, 55, 301, 33);
		frmFirePunch.getContentPane().add(lblPersonalizacionApp);

		lblFP = new JLabel("");
		lblFP.setBounds(330, 181, 240, 200);
		lblFP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/claros/arc-theme-orange.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenu.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				lblMenu.setForeground(new Color(252, 61, 3));

				frmFirePunch.getContentPane().setBackground(new Color(240, 240, 240));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a FirePunch");
			}
		});
		ImageIcon imageOpcionesFP = new ImageIcon("src/main/resources/opcionesFP.png");
		Image imageFPOpciones = imageOpcionesFP.getImage().getScaledInstance(lblFP.getWidth(), lblFP.getHeight(),
				Image.SCALE_SMOOTH);
		lblFP.setIcon(new ImageIcon(imageFPOpciones));
		frmFirePunch.getContentPane().add(lblFP);

		lblFR = new JLabel("");
		lblFR.setBounds(621, 181, 240, 200);
		lblFR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/colores/Solarized Light.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuFR.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(253, 246, 227));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Frambuesa");
			}
		});
		ImageIcon imageOpcionesFR = new ImageIcon("src/main/resources/opcionesFR.png");
		Image imageFROpciones = imageOpcionesFR.getImage().getScaledInstance(lblFR.getWidth(), lblFR.getHeight(),
				Image.SCALE_SMOOTH);
		lblFR.setIcon(new ImageIcon(imageFROpciones));
		frmFirePunch.getContentPane().add(lblFR);

		lblAM = new JLabel("");
		lblAM.setBounds(912, 181, 240, 200);
		lblAM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/colores/Moonlight.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuAM.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(34, 36, 54));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Azumarill");
			}
		});
		ImageIcon imageOpcionesAM = new ImageIcon("src/main/resources/opcionesAM.png");
		Image imageAMOpciones = imageOpcionesAM.getImage().getScaledInstance(lblAM.getWidth(), lblAM.getHeight(),
				Image.SCALE_SMOOTH);
		lblAM.setIcon(new ImageIcon(imageAMOpciones));
		frmFirePunch.getContentPane().add(lblAM);

		lblEM = new JLabel("");
		lblEM.setBounds(1197, 181, 240, 200);
		lblEM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/colores/Gradianto_Nature_Green.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuEM.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(41, 80, 79));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Esmeralda");
			}
		});
		ImageIcon imageOpcionesEM = new ImageIcon("src/main/resources/opcionesEM.png");
		Image imageEMOpciones = imageOpcionesEM.getImage().getScaledInstance(lblEM.getWidth(), lblEM.getHeight(),
				Image.SCALE_SMOOTH);
		lblEM.setIcon(new ImageIcon(imageEMOpciones));
		frmFirePunch.getContentPane().add(lblEM);

		lblAZ = new JLabel("");
		lblAZ.setBounds(330, 488, 240, 200);
		lblAZ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/claros/Github Contrast.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuAZ.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(240, 240, 240));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Azerbaiyán");
			}
		});
		ImageIcon imageOpcionesAZ = new ImageIcon("src/main/resources/opcionesAZ.png");
		Image imageAZOpciones = imageOpcionesAZ.getImage().getScaledInstance(lblAZ.getWidth(), lblAZ.getHeight(),
				Image.SCALE_SMOOTH);
		lblAZ.setIcon(new ImageIcon(imageAZOpciones));
		frmFirePunch.getContentPane().add(lblAZ);

		lblLM = new JLabel("");
		lblLM.setBounds(621, 488, 240, 200);
		lblLM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/oscuros/Monokai Pro Contrast.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuLM.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(45, 42, 46));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Lemon Milk");
			}
		});
		ImageIcon imageOpcionesLM = new ImageIcon("src/main/resources/opcionesLM.png");
		Image imageLMOpciones = imageOpcionesLM.getImage().getScaledInstance(lblLM.getWidth(), lblLM.getHeight(),
				Image.SCALE_SMOOTH);
		lblLM.setIcon(new ImageIcon(imageLMOpciones));
		frmFirePunch.getContentPane().add(lblLM);

		lblMM = new JLabel("");
		lblMM.setBounds(912, 488, 240, 200);
		lblMM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/colores/Material Palenight.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenuMM.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(41, 45, 62));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Mismagius");
			}
		});
		ImageIcon imageOpcionesMM = new ImageIcon("src/main/resources/opcionesMM.png");
		Image imageMMOpciones = imageOpcionesMM.getImage().getScaledInstance(lblMM.getWidth(), lblMM.getHeight(),
				Image.SCALE_SMOOTH);
		lblMM.setIcon(new ImageIcon(imageMMOpciones));
		frmFirePunch.getContentPane().add(lblMM);

		lblN2 = new JLabel("");
		lblN2.setBounds(1197, 488, 240, 200);
		lblN2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/**
				 * Personalización con un tema de FlatLaf almacenado en los paquetes dentro del
				 * paquete gui.
				 */
				IntelliJTheme.setup(App.class.getResourceAsStream("temas/oscuros/arc_theme_dark_orange.theme.json"));
				updateUI(frmFirePunch);

				ImageIcon imageIcon = new ImageIcon("src/main/resources/fondoMenu.png");
				Image image = imageIcon.getImage().getScaledInstance(lblFondoMenu.getWidth(), lblFondoMenu.getHeight(),
						Image.SCALE_SMOOTH);
				lblFondoMenu.setIcon(new ImageIcon(image));
				frmFirePunch.getContentPane().add(lblFondoMenu);

				frmFirePunch.getContentPane().setBackground(new Color(56, 60, 74));

				JOptionPane.showMessageDialog(null, "Aspecto cambiado a Naranjito 2");
			}
		});
		ImageIcon imageOpcionesN2 = new ImageIcon("src/main/resources/opcionesN2.png");
		Image imageN2Opciones = imageOpcionesN2.getImage().getScaledInstance(lblN2.getWidth(), lblN2.getHeight(),
				Image.SCALE_SMOOTH);
		lblN2.setIcon(new ImageIcon(imageN2Opciones));
		frmFirePunch.getContentPane().add(lblN2);

		/* ventana de entrenar */

		lblVentanaEntrenar = new JLabel("Programa los entrenamientos");
		lblVentanaEntrenar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentanaEntrenar.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblVentanaEntrenar.setBounds(749, 20, 349, 33);
		frmFirePunch.getContentPane().add(lblVentanaEntrenar);

		cbCategoriasEntrenar = new JComboBox();
		cbCategoriasEntrenar.setBounds(1063, 448, 220, 22);
		categorias = categoriaDAO.selectAllCategoria();
		cbCategoriasEntrenar.removeAllItems();

		int numeral3 = 1;
		for (Categoria c : categorias) {
			cbCategoriasEntrenar.addItem(numeral3 + ". " + c.getNombreCategoria());
			numeral3++;
		}

		frmFirePunch.getContentPane().add(cbCategoriasEntrenar);

		lblCategoriasEntrenar = new JLabel("Categoria");
		lblCategoriasEntrenar.setBounds(956, 454, 66, 14);
		frmFirePunch.getContentPane().add(lblCategoriasEntrenar);

		btnLimpiarEntrenar = new JButton("New button");
		btnLimpiarEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfIDClienteEntrenar.setText("");
				tfIDEjercicioEntrenar.setText("");
				tfNombreClienteEntrenar.setText("");
				tfNombreEjercicioEntrenar.setText("");
				tfApellidosClienteEntrenar.setText("");
				tfEdadClienteEntrenar.setText("");
				tfAlturaClienteEntrenar.setText("");
				tfPesoClienteEntrenar.setText("");
				tfSeriesEjercicioEntrenar.setText("");
				tfRepeticionesEjercicioEntrenar.setText("");
				tfCargaEjercicioEntrenar.setText("");
			}
		});
		btnLimpiarEntrenar.setBounds(287, -52, 117, 25);
		frmFirePunch.getContentPane().add(btnLimpiarEntrenar);
		btnLimpiarEntrenar.setVisible(false);

		lblFotoSubidaClientesEntrenar = new JLabel();
		lblFotoSubidaClientesEntrenar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblFotoSubidaClientesEntrenar.setBounds(640, 296, 200, 200);
		frmFirePunch.getContentPane().add(lblFotoSubidaClientesEntrenar);
		lblFotoSubidaClientesEntrenar.setVisible(false);

		lblFotoSubidaEjerciciosEntrenar = new JLabel();
		lblFotoSubidaEjerciciosEntrenar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblFotoSubidaEjerciciosEntrenar.setBounds(1308, 296, 200, 200);
		frmFirePunch.getContentPane().add(lblFotoSubidaEjerciciosEntrenar);
		lblFotoSubidaEjerciciosEntrenar.setVisible(false);

		lblFotoSubidaRutinaEntrenar = new JLabel();
		lblFotoSubidaRutinaEntrenar.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		lblFotoSubidaRutinaEntrenar.setBounds(1193, 530, 200, 200);
		frmFirePunch.getContentPane().add(lblFotoSubidaRutinaEntrenar);
		lblFotoSubidaRutinaEntrenar.setVisible(false);

		DefaultTableModel modelCliente2 = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false; // No permitir la edición de las celdas
			}
		};

		DefaultTableModel modelEjercicio2 = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false; // No permitir la edición de las celdas
			}
		};

		DefaultTableModel modelRealiza2 = new DefaultTableModel() {
			public boolean isCellEditable(int fila, int columna) {
				return false; // No permitir la edición de las celdas
			}
		};

		// modelCliente.addColumn("Foto");
		modelCliente2.addColumn("ID");
		modelCliente2.addColumn("Nombre");
		modelCliente2.addColumn("Apellidos");
		modelCliente2.addColumn("Edad");
		modelCliente2.addColumn("Altura");
		modelCliente2.addColumn("Peso");
		modelCliente2.addColumn("Entrenador");

		clientesDeEntrenador = clienteDAO.selectClientesByIdEntrenador(
				entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado).getIdEntrenador());
		entrenadores = entrenadorDAO.selectAllEntrenador();

		for (Cliente c : clientesDeEntrenador) {
			Object[] row = new Object[7];

			row[0] = c.getIdCliente();
			row[1] = c.getNombre();
			row[2] = c.getApellidos();
			row[3] = c.getEdad();
			row[4] = (int) c.getAltura();
			row[5] = c.getPeso();
			for (Entrenador en : entrenadores) {
				en = entrenadorDAO.selectEntrenadorById(c.getEntrenador().getIdEntrenador());
				row[6] = en.getUsuario();
			}

			modelCliente2.addRow(row);
		}

		tableClientesEntrenar = new JTable(modelCliente2);
		tableClientesEntrenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tableClientesEntrenar.getSelectedRow();
				TableModel model = tableClientesEntrenar.getModel();

				// rutaFoto = (model.getValueAt(index, 0).toString());
				tfIDClienteEntrenar.setText(model.getValueAt(index, 0).toString());
				tfNombreClienteEntrenar.setText(model.getValueAt(index, 1).toString());
				tfApellidosClienteEntrenar.setText(model.getValueAt(index, 2).toString());
				tfEdadClienteEntrenar.setText(model.getValueAt(index, 3).toString());
				tfAlturaClienteEntrenar.setText(model.getValueAt(index, 4).toString());
				tfPesoClienteEntrenar.setText(model.getValueAt(index, 5).toString());
				lblFotoSubidaClientesEntrenar.setVisible(true);

				Cliente c = clienteDAO.selectClienteById(Integer.parseInt(model.getValueAt(index, 0).toString()));
				rutaFoto = c.getFotoPerfil();

				ImageIcon imageIcon = new ImageIcon(rutaFoto);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaClientesEntrenar.getWidth(),
						lblFotoSubidaClientesEntrenar.getHeight(), Image.SCALE_SMOOTH);
				lblFotoSubidaClientesEntrenar.setIcon(new ImageIcon(image));
				lblFotoSubidaClientesEntrenar.setVisible(true);

			}

		});
		tableClientesEntrenar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel1 = tableClientesEntrenar.getColumnModel();

		DefaultTableCellRenderer centerRenderClientes = new DefaultTableCellRenderer();
		centerRenderClientes.setHorizontalAlignment(JLabel.CENTER);
		columnModel1.getColumn(0).setPreferredWidth(60);
		columnModel1.getColumn(0).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(1).setPreferredWidth(80);
		columnModel1.getColumn(1).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(2).setPreferredWidth(150);
		columnModel1.getColumn(2).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(3).setPreferredWidth(60);
		columnModel1.getColumn(3).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(4).setPreferredWidth(90);
		columnModel1.getColumn(4).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(5).setPreferredWidth(90);
		columnModel1.getColumn(5).setCellRenderer(centerRenderClientes);
		columnModel1.getColumn(6).setPreferredWidth(90);
		columnModel1.getColumn(6).setCellRenderer(centerRenderClientes);

		frmFirePunch.getContentPane().add(tableClientesEntrenar);
		tableClientesEntrenar.setDefaultEditor(Cliente.class, null);

		scrollPaneEntrenarEntrenar = new JScrollPane(tableClientesEntrenar);
		scrollPaneEntrenarEntrenar.setBounds(255, 70, 660, 181);
		frmFirePunch.getContentPane().add(scrollPaneEntrenarEntrenar);

		btnMostrarEntrenar = new JButton("New button");
		btnMostrarEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Cliente> clientes = clienteDAO.selectClientesByIdEntrenador(
						entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado).getIdEntrenador());
				List<Entrenador> entrenadores = entrenadorDAO.selectAllEntrenador();
				modelCliente2.setRowCount(0);
				modelEjercicio2.setRowCount(0);
				for (Cliente c : clientes) {
					Object[] row = new Object[7];
					row[0] = c.getIdCliente();
					row[1] = c.getNombre();
					row[2] = c.getApellidos();
					row[3] = c.getEdad();
					row[4] = (int) c.getAltura();
					row[5] = c.getPeso();
					for (Entrenador en : entrenadores) {
						en = entrenadorDAO.selectEntrenadorById(c.getEntrenador().getIdEntrenador());
						row[6] = en.getUsuario();
					}
					modelCliente2.addRow(row);
				}

				List<Ejercicio> ejercicios = ejercicioDAO.selectAllEjercicio();
				List<Categoria> categorias = categoriaDAO.selectAllCategoria();
				for (Ejercicio e : ejercicios) {
					Object[] row = new Object[6];
					row[0] = e.getIdEjercicio();
					row[1] = e.getNombre();
					row[2] = e.getSeries();
					row[3] = e.getRepeticiones();
					row[4] = e.getCargaKg();
					for (Categoria c : categorias) {
						c = categoriaDAO.selectCategoriaById(e.getCategoria().getIdCategoria());
						row[5] = c.getNombreCategoria();
					}
					modelEjercicio2.addRow(row);
				}

			}
		});
		btnMostrarEntrenar.setBounds(159, -47, 117, 25);
		frmFirePunch.getContentPane().add(btnMostrarEntrenar);
		btnMostrarEntrenar.setVisible(false);

		modelEjercicio2.addColumn("ID");
		modelEjercicio2.addColumn("Nombre");
		modelEjercicio2.addColumn("Series");
		modelEjercicio2.addColumn("Repeticiones");
		modelEjercicio2.addColumn("Carga (Kg)");
		modelEjercicio2.addColumn("Categoria");

		ejercicios = ejercicioDAO.selectAllEjercicio();
		categorias = categoriaDAO.selectAllCategoria();

		for (Ejercicio e : ejercicios) {
			Object[] row = new Object[6];
			row[0] = e.getIdEjercicio();
			row[1] = e.getNombre();
			row[2] = e.getSeries();
			row[3] = e.getRepeticiones();
			row[4] = e.getCargaKg();
			for (Categoria c : categorias) {
				c = categoriaDAO.selectCategoriaById(e.getCategoria().getIdCategoria());
				row[5] = c.getNombreCategoria();
			}
			modelEjercicio2.addRow(row);
		}

		tableEjerciciosEntrenar = new JTable(modelEjercicio2);
		tableEjerciciosEntrenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tableEjerciciosEntrenar.getSelectedRow();
				TableModel model = tableEjerciciosEntrenar.getModel();

				tfIDEjercicioEntrenar.setText(model.getValueAt(index, 0).toString());
				tfNombreEjercicioEntrenar.setText(model.getValueAt(index, 1).toString());
				tfSeriesEjercicioEntrenar.setText(model.getValueAt(index, 2).toString());
				tfRepeticionesEjercicioEntrenar.setText(model.getValueAt(index, 3).toString());
				tfCargaEjercicioEntrenar.setText(model.getValueAt(index, 4).toString());

				int indiceCategoria = 0;
				switch (model.getValueAt(index, 5).toString()) {
				case "Pierna":
					indiceCategoria = 0;
					break;
				case "Pecho":
					indiceCategoria = 1;
					break;
				case "Espalda":
					indiceCategoria = 2;
					break;
				case "Brazo":
					indiceCategoria = 3;
					break;
				case "Abdomen":
					indiceCategoria = 4;
					break;
				default:
					indiceCategoria = 10;
				}
				cbCategoriasEntrenar.setSelectedIndex(indiceCategoria);

				lblFotoSubidaEjerciciosEntrenar.setVisible(true);
				cbCategoriasEntrenar.setVisible(true);
				lblCategoriasEntrenar.setVisible(true);

				Ejercicio ej = ejercicioDAO
						.selectEjercicioById(Integer.parseInt(model.getValueAt(index, 0).toString()));
				rutaFoto2 = ej.getFotoPerfil();

				ImageIcon imageIcon = new ImageIcon(rutaFoto2);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaEjerciciosEntrenar.getWidth(),
						lblFotoSubidaEjerciciosEntrenar.getHeight(), Image.SCALE_SMOOTH);
				lblFotoSubidaEjerciciosEntrenar.setIcon(new ImageIcon(image));
				lblFotoSubidaEjerciciosEntrenar.setVisible(true);
			}

		});
		tableEjerciciosEntrenar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel4 = tableEjerciciosEntrenar.getColumnModel();

		DefaultTableCellRenderer centerRender4 = new DefaultTableCellRenderer();
		centerRender4.setHorizontalAlignment(JLabel.CENTER);

		columnModel4.getColumn(0).setPreferredWidth(60);
		columnModel4.getColumn(0).setCellRenderer(centerRender4);
		columnModel4.getColumn(1).setPreferredWidth(330);
		columnModel4.getColumn(1).setCellRenderer(centerRender4);
		columnModel4.getColumn(2).setPreferredWidth(90);
		columnModel4.getColumn(2).setCellRenderer(centerRender4);
		columnModel4.getColumn(3).setPreferredWidth(90);
		columnModel4.getColumn(3).setCellRenderer(centerRender4);
		columnModel4.getColumn(4).setPreferredWidth(90);
		columnModel4.getColumn(4).setCellRenderer(centerRender4);
		frmFirePunch.getContentPane().add(tableEjerciciosEntrenar);
		tableEjerciciosEntrenar.setDefaultEditor(Cliente.class, null);
		scrollPane2Entrenar = new JScrollPane(tableEjerciciosEntrenar);
		scrollPane2Entrenar.setBounds(949, 70, 550, 181);
		frmFirePunch.getContentPane().add(scrollPane2Entrenar);

		modelRealiza2.addColumn("Cliente");
		modelRealiza2.addColumn("Ejercicio");
		modelRealiza2.addColumn("Categoría");
		modelRealiza2.addColumn("Duración");

		tableRealizaEntrenar = new JTable(modelRealiza2);
		tableRealizaEntrenar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int index = tableRealizaEntrenar.getSelectedRow();
				TableModel model = tableRealizaEntrenar.getModel();

				lblFotoSubidaRutinaEntrenar.setVisible(true);

				tfIDClienteEntrenar.setText("");
				tfNombreClienteEntrenar.setText("");
				tfApellidosClienteEntrenar.setText("");
				tfEdadClienteEntrenar.setText("");
				tfPesoClienteEntrenar.setText("");
				tfAlturaClienteEntrenar.setText("");
				lblFotoSubidaClientesEntrenar.setVisible(false);
				tfIDEjercicioEntrenar.setText("");
				tfNombreEjercicioEntrenar.setText("");
				tfSeriesEjercicioEntrenar.setText("");
				tfRepeticionesEjercicioEntrenar.setText("");
				tfCargaEjercicioEntrenar.setText("");
				lblFotoSubidaEjerciciosEntrenar.setVisible(false);
				cbCategoriasEntrenar.setVisible(false);
				lblCategoriasEntrenar.setVisible(false);

				tableClientesEntrenar.clearSelection();
				tableEjerciciosEntrenar.clearSelection();

				Ejercicio ej = ejercicioDAO.selectEjercicioByNombre(model.getValueAt(index, 1).toString());
				rutaFoto3 = ej.getFotoPerfil();

				ImageIcon imageIcon = new ImageIcon(rutaFoto3);
				Image image = imageIcon.getImage().getScaledInstance(lblFotoSubidaRutinaEntrenar.getWidth(),
						lblFotoSubidaRutinaEntrenar.getHeight(), Image.SCALE_SMOOTH);
				lblFotoSubidaRutinaEntrenar.setIcon(new ImageIcon(image));
				lblFotoSubidaRutinaEntrenar.setVisible(true);
			}

		});
		tableRealizaEntrenar.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TableColumnModel columnModel5 = tableRealizaEntrenar.getColumnModel();

		DefaultTableCellRenderer centerRender5 = new DefaultTableCellRenderer();
		centerRender5.setHorizontalAlignment(JLabel.CENTER);

		columnModel5.getColumn(0).setPreferredWidth(60);
		columnModel5.getColumn(0).setCellRenderer(centerRender5);
		columnModel5.getColumn(1).setPreferredWidth(200);
		columnModel5.getColumn(1).setCellRenderer(centerRender5);
		columnModel5.getColumn(2).setPreferredWidth(60);
		columnModel5.getColumn(2).setCellRenderer(centerRender5);
		columnModel5.getColumn(3).setPreferredWidth(150);
		columnModel5.getColumn(3).setCellRenderer(centerRender5);
		frmFirePunch.getContentPane().add(tableRealizaEntrenar);
		tableRealizaEntrenar.setDefaultEditor(Cliente.class, null);

		scrollPane3EntrenarEntrenar = new JScrollPane(tableRealizaEntrenar);
		scrollPane3EntrenarEntrenar.setBounds(530, 545, 600, 181);
		frmFirePunch.getContentPane().add(scrollPane3EntrenarEntrenar);

		tfIDClienteEntrenar = new JTextField();
		tfIDClienteEntrenar.setEditable(false);
		tfIDClienteEntrenar.setBounds(366, 296, 220, 19);
		frmFirePunch.getContentPane().add(tfIDClienteEntrenar);
		tfIDClienteEntrenar.setColumns(10);

		tfNombreClienteEntrenar = new JTextField();
		tfNombreClienteEntrenar.setEditable(false);
		tfNombreClienteEntrenar.setColumns(10);
		tfNombreClienteEntrenar.setBounds(366, 328, 220, 19);
		frmFirePunch.getContentPane().add(tfNombreClienteEntrenar);

		tfEdadClienteEntrenar = new JTextField();
		tfEdadClienteEntrenar.setEditable(false);
		tfEdadClienteEntrenar.setColumns(10);
		tfEdadClienteEntrenar.setBounds(368, 390, 220, 19);
		frmFirePunch.getContentPane().add(tfEdadClienteEntrenar);
		tfAlturaClienteEntrenar = new JTextField();
		tfAlturaClienteEntrenar.setEditable(false);
		tfAlturaClienteEntrenar.setColumns(10);
		tfAlturaClienteEntrenar.setBounds(368, 421, 220, 19);
		frmFirePunch.getContentPane().add(tfAlturaClienteEntrenar);

		tfPesoClienteEntrenar = new JTextField();
		tfPesoClienteEntrenar.setEditable(false);
		tfPesoClienteEntrenar.setColumns(10);
		tfPesoClienteEntrenar.setBounds(368, 454, 220, 19);
		frmFirePunch.getContentPane().add(tfPesoClienteEntrenar);

		tfIDEjercicioEntrenar = new JTextField();
		tfIDEjercicioEntrenar.setEditable(false);
		tfIDEjercicioEntrenar.setColumns(10);
		tfIDEjercicioEntrenar.setBounds(1063, 296, 220, 19);
		frmFirePunch.getContentPane().add(tfIDEjercicioEntrenar);

		tfNombreEjercicioEntrenar = new JTextField();
		tfNombreEjercicioEntrenar.setEditable(false);
		tfNombreEjercicioEntrenar.setColumns(10);
		tfNombreEjercicioEntrenar.setBounds(1063, 328, 220, 19);
		frmFirePunch.getContentPane().add(tfNombreEjercicioEntrenar);

		tfSeriesEjercicioEntrenar = new JTextField();
		tfSeriesEjercicioEntrenar.setEditable(false);
		tfSeriesEjercicioEntrenar.setColumns(10);
		tfSeriesEjercicioEntrenar.setBounds(1063, 359, 220, 19);
		frmFirePunch.getContentPane().add(tfSeriesEjercicioEntrenar);

		tfRepeticionesEjercicioEntrenar = new JTextField();
		tfRepeticionesEjercicioEntrenar.setEditable(false);
		tfRepeticionesEjercicioEntrenar.setColumns(10);
		tfRepeticionesEjercicioEntrenar.setBounds(1063, 390, 220, 19);
		frmFirePunch.getContentPane().add(tfRepeticionesEjercicioEntrenar);

		tfCargaEjercicioEntrenar = new JTextField();
		tfCargaEjercicioEntrenar.setEditable(false);
		tfCargaEjercicioEntrenar.setColumns(10);
		tfCargaEjercicioEntrenar.setBounds(1063, 419, 220, 19);
		frmFirePunch.getContentPane().add(tfCargaEjercicioEntrenar);

		tfApellidosClienteEntrenar = new JTextField();
		tfApellidosClienteEntrenar.setEditable(false);
		tfApellidosClienteEntrenar.setColumns(10);
		tfApellidosClienteEntrenar.setBounds(368, 359, 220, 19);
		frmFirePunch.getContentPane().add(tfApellidosClienteEntrenar);

		lblIDClienteEntrenar = new JLabel("id");
		lblIDClienteEntrenar.setBounds(273, 298, 70, 15);
		frmFirePunch.getContentPane().add(lblIDClienteEntrenar);

		lblNombreClienteEntrenar = new JLabel("Nombre");
		lblNombreClienteEntrenar.setBounds(273, 330, 70, 15);
		frmFirePunch.getContentPane().add(lblNombreClienteEntrenar);

		lblApellidosClienteEntrenar = new JLabel("Apellidos");
		lblApellidosClienteEntrenar.setBounds(273, 361, 70, 15);
		frmFirePunch.getContentPane().add(lblApellidosClienteEntrenar);

		lblEdadClienteEntrenar = new JLabel("Edad");
		lblEdadClienteEntrenar.setBounds(273, 392, 70, 15);
		frmFirePunch.getContentPane().add(lblEdadClienteEntrenar);

		lblAlturaClienteEntrenar = new JLabel("Altura");
		lblAlturaClienteEntrenar.setBounds(273, 423, 70, 15);
		frmFirePunch.getContentPane().add(lblAlturaClienteEntrenar);

		lblPesoClienteEntrenar = new JLabel("Peso");
		lblPesoClienteEntrenar.setBounds(273, 456, 70, 15);
		frmFirePunch.getContentPane().add(lblPesoClienteEntrenar);

		lblCargakgEntrenar = new JLabel("Carga (Kg)");
		lblCargakgEntrenar.setBounds(956, 423, 89, 15);
		frmFirePunch.getContentPane().add(lblCargakgEntrenar);

		lblRepeticionesEntrenar = new JLabel("Repeticiones");
		lblRepeticionesEntrenar.setBounds(956, 393, 106, 15);
		frmFirePunch.getContentPane().add(lblRepeticionesEntrenar);

		lblSeriesEntrenar = new JLabel("Series");
		lblSeriesEntrenar.setBounds(956, 362, 70, 15);
		frmFirePunch.getContentPane().add(lblSeriesEntrenar);

		lblNombreEjercicioEntrenar = new JLabel("Nombre");
		lblNombreEjercicioEntrenar.setBounds(952, 331, 70, 15);
		frmFirePunch.getContentPane().add(lblNombreEjercicioEntrenar);

		lblIDEjercicioEntrenar = new JLabel("id");
		lblIDEjercicioEntrenar.setBounds(956, 299, 70, 15);
		frmFirePunch.getContentPane().add(lblIDEjercicioEntrenar);

		btnEntrenarEntrenar = new JButton("Entrenar");
		btnEntrenarEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] row = new Object[4];

				Cliente clienteNombre = clienteDAO.selectClienteById(Integer.parseInt(tfIDClienteEntrenar.getText()));
				row[0] = clienteNombre.getNombre();

				Ejercicio ejercicioNombre = ejercicioDAO
						.selectEjercicioById(Integer.parseInt(tfIDEjercicioEntrenar.getText()));
				row[1] = ejercicioNombre.getNombre();

				Categoria c = categoriaDAO.selectCategoriaById(ejercicioNombre.getCategoria().getIdCategoria());
				row[2] = c.getNombreCategoria();

				LocalDateTime fechaHoy = LocalDateTime.now();
				LocalDateTime fechaInicio = fechaHoy.plus(10, ChronoUnit.MINUTES);
				LocalDateTime fechaFinal = fechaHoy.plus(80, ChronoUnit.MINUTES);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
				String horaMinSegInicio = fechaInicio.format(formatter);
				String horaMinSegFinal = fechaFinal.format(formatter);
				row[3] = "Entrenas de " + horaMinSegInicio + " a " + horaMinSegFinal;
				modelRealiza2.addRow(row);

				JOptionPane.showMessageDialog(null, "Cliente entrenando");
			}
		});
		btnEntrenarEntrenar.setBounds(530, 737, 117, 25);
		frmFirePunch.getContentPane().add(btnEntrenarEntrenar);

		btnDejarDeEntrenar = new JButton("Dejar de entrenar");
		btnDejarDeEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFotoSubidaRutinaEntrenar.setVisible(false);
				int index = tableRealizaEntrenar.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) tableRealizaEntrenar.getModel();
				model.removeRow(index);
			}
		});
		btnDejarDeEntrenar.setBounds(753, 737, 142, 25);
		frmFirePunch.getContentPane().add(btnDejarDeEntrenar);

		btnAcabarSesionEntrenar = new JButton("Acabar sesión");
		btnAcabarSesionEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFotoSubidaRutinaEntrenar.setVisible(false);
				DefaultTableModel model = (DefaultTableModel) tableRealizaEntrenar.getModel();
				model.setRowCount(0);
			}
		});
		btnAcabarSesionEntrenar.setBounds(988, 737, 142, 25);
		frmFirePunch.getContentPane().add(btnAcabarSesionEntrenar);

		ocultarEntrenar(lblVentanaEntrenar, cbCategoriasEntrenar, lblCategoriasEntrenar, btnLimpiarEntrenar,
				tableClientesEntrenar, scrollPaneEntrenarEntrenar, btnMostrarEntrenar, tableEjerciciosEntrenar,
				scrollPane2Entrenar, tableRealizaEntrenar, scrollPane3EntrenarEntrenar, lblIDClienteEntrenar,
				lblNombreClienteEntrenar, lblApellidosClienteEntrenar, lblEdadClienteEntrenar, lblAlturaClienteEntrenar,
				lblPesoClienteEntrenar, lblCargakgEntrenar, lblRepeticionesEntrenar, lblSeriesEntrenar,
				lblNombreEjercicioEntrenar, lblIDEjercicioEntrenar, btnEntrenarEntrenar, btnDejarDeEntrenar,
				btnAcabarSesionEntrenar, tfIDClienteEntrenar, tfNombreClienteEntrenar, tfEdadClienteEntrenar,
				tfAlturaClienteEntrenar, tfPesoClienteEntrenar, tfIDEjercicioEntrenar, tfNombreEjercicioEntrenar,
				tfSeriesEjercicioEntrenar, tfRepeticionesEjercicioEntrenar, tfCargaEjercicioEntrenar,
				tfApellidosClienteEntrenar, lblFotoSubidaClientesEntrenar, lblFotoSubidaEjerciciosEntrenar,
				lblFotoSubidaRutinaEntrenar);

		ocultarOpciones(lblFP, lblFR, lblAM, lblEM, lblAZ, lblLM, lblMM, lblN2, lblPersonalizacionApp);

		ocultarPerfil(lblPerfilUsuario, lblFotoPerfil, lblEntrenadorPerfil, tfNombrePerfil, lblApellidosPerfil,
				tfApellidosPerfil, lblContraPerfil, lblEdadPerfil, tfEdadPerfil, tfUsuarioPerfil, lblUsuarioPerfil,
				lblEmailPerfil, tfEmailPerfil, tfContraPerfil, lblSubirFotoPerfil, btnActualizarEntrenador,
				btnBorrarEntrenador, btnCerrarSesion, lblFotoTioRandom, lblMostrarNombrePerfil, btnEligeFotoPerfil);

		ocultarHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes, lblFotoSubidaEjercicios,
				tableClientes, scrollPane, btnEligeFotoEjercicio, tableEjercicios, scrollPane2, btnEligeFoto,
				btnInsertarCliente, btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
				btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente, tfAlturaCliente,
				tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio, tfRepeticionesEjercicio,
				tfCargaEjercicio, tfApellidosCliente, lblIDCliente, lblNombreCliente, lblApellidosCliente,
				lblEdadCliente, lblAlturaCliente, lblPesoCliente, lblCargakg, lblRepeticiones, lblSeries,
				lblNombreEjercicio, lblIDEjercicio, lblFotoCliente, lblFotoEjercicio, btnAsignarmeCliente);
		ocultarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu, lblLogoApp);

		lblNombreRegister = new JLabel("Nombre");
		lblNombreRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombreRegister.setBounds(927, 224, 66, 20);
		frmFirePunch.getContentPane().add(lblNombreRegister);

		tfNombreRegister = new JTextField();
		tfNombreRegister.setColumns(10);
		tfNombreRegister.setBounds(1064, 222, 349, 20);
		frmFirePunch.getContentPane().add(tfNombreRegister);

		lblApellidosRegister = new JLabel("Apellidos");
		lblApellidosRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblApellidosRegister.setBounds(927, 279, 90, 19);
		frmFirePunch.getContentPane().add(lblApellidosRegister);

		tfApellidosRegister = new JTextField();
		tfApellidosRegister.setColumns(10);
		tfApellidosRegister.setBounds(1064, 275, 349, 20);
		frmFirePunch.getContentPane().add(tfApellidosRegister);

		lblContraRegistro = new JLabel("Contraseña");
		lblContraRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraRegistro.setBounds(927, 490, 135, 14);
		frmFirePunch.getContentPane().add(lblContraRegistro);

		lblEdadRegister = new JLabel("Edad");
		lblEdadRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdadRegister.setBounds(927, 331, 66, 14);
		frmFirePunch.getContentPane().add(lblEdadRegister);

		tfEdadRegister = new JTextField();
		tfEdadRegister.setColumns(10);
		tfEdadRegister.setBounds(1064, 325, 349, 20);
		frmFirePunch.getContentPane().add(tfEdadRegister);

		tfUsuarioRegistro = new JTextField();
		tfUsuarioRegistro.setColumns(10);
		tfUsuarioRegistro.setBounds(1064, 378, 349, 20);
		frmFirePunch.getContentPane().add(tfUsuarioRegistro);

		lblUsuarioRegistro = new JLabel("Usuario");
		lblUsuarioRegistro.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuarioRegistro.setBounds(927, 384, 66, 14);
		frmFirePunch.getContentPane().add(lblUsuarioRegistro);

		lblEmailRegister = new JLabel("Email");
		lblEmailRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailRegister.setBounds(927, 435, 66, 14);
		frmFirePunch.getContentPane().add(lblEmailRegister);

		tfEmailRegister = new JTextField();
		tfEmailRegister.setColumns(10);
		tfEmailRegister.setBounds(1064, 429, 349, 20);
		frmFirePunch.getContentPane().add(tfEmailRegister);

		tfContraRegistro = new JTextField();
		tfContraRegistro.setColumns(10);
		tfContraRegistro.setBounds(1064, 484, 349, 20);
		frmFirePunch.getContentPane().add(tfContraRegistro);

		lblFondoRegistro = new JLabel("");
		lblFondoRegistro.setBounds(0, 0, 775, 811);

		ImageIcon imageIconRegisterApp = new ImageIcon("src/main/resources/fondoRegister.png");
		Image imageRegisterApp = imageIconRegisterApp.getImage().getScaledInstance(lblFondoRegistro.getWidth(),
				lblFondoRegistro.getHeight(), Image.SCALE_SMOOTH);
		lblFondoRegistro.setIcon(new ImageIcon(imageRegisterApp));
		frmFirePunch.getContentPane().add(lblFondoRegistro);

		lblTituloRegister = new JLabel("¡Hola, estamos encantados de tenerte!");
		lblTituloRegister.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTituloRegister.setBounds(919, 125, 509, 33);
		frmFirePunch.getContentPane().add(lblTituloRegister);

		lblTituloRegister2 = new JLabel("Regístrate para unirte a Fire Punch Fitness Club");
		lblTituloRegister2.setForeground(Color.GRAY);
		lblTituloRegister2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloRegister2.setBounds(919, 170, 437, 20);
		frmFirePunch.getContentPane().add(lblTituloRegister2);

		lblDivisionRegister = new JLabel("");
		lblDivisionRegister.setBounds(927, 609, 486, 18);
		ImageIcon imageIconDivisionRegister = new ImageIcon("src/main/resources/divisionLogin.png");
		Image imageDivisionRegister = imageIconDivisionRegister.getImage()
				.getScaledInstance(lblDivisionRegister.getWidth(), lblDivisionRegister.getHeight(), Image.SCALE_SMOOTH);
		lblDivisionRegister.setIcon(new ImageIcon(imageDivisionRegister));
		frmFirePunch.getContentPane().add(lblDivisionRegister);

		btnRegistro = new JButton("Registro");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistro.setForeground(Color.WHITE);
		btnRegistro.setBackground(Color.DARK_GRAY);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Comprobación de errores de los campos del entrenador. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos.
				 */
				if (tfNombreRegister.getText().isEmpty() || tfApellidosRegister.getText().isEmpty()
						|| tfEdadRegister.getText().isEmpty() || tfUsuarioRegistro.getText().isEmpty()
						|| tfEmailRegister.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Matcher matNombre = patNombre.matcher(tfNombreRegister.getText());
					Matcher matApellidos = patApellido.matcher(tfApellidosRegister.getText());
					Matcher matEdad = patEdad.matcher(tfEdadRegister.getText());
					Matcher matEmail = patEmail.matcher(tfEmailRegister.getText());
					if (!matNombre.matches()) {
						JOptionPane.showMessageDialog(null,
								"El nombre debe empezar por mayúscula y contener como mínimo 2 letras.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matApellidos.matches()) {
						JOptionPane.showMessageDialog(null,
								"El apellido debe empezar por mayúscula y contener como mínimo 2 letras.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (!matEdad.matches()) {
						JOptionPane.showMessageDialog(null, "La persona debe ser mayor de 15 años y menor a 90 años.",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else if (!matEmail.matches()) {
						JOptionPane.showMessageDialog(null, "El email debe estar en el formato adecuado.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfEdadRegister.getText()) < 18) {
						JOptionPane.showMessageDialog(null, "El entrenador debe ser mayor de 18 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else if (Integer.parseInt(tfEdadRegister.getText()) > 61) {
						JOptionPane.showMessageDialog(null, "El entrenador debe ser menor de 61 años.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						Entrenador entrenador = new Entrenador(tfNombreRegister.getText(),
								tfApellidosRegister.getText(), Integer.parseInt(tfEdadRegister.getText()),
								tfUsuarioRegistro.getText(), tfEmailRegister.getText(),
								entrenadorDAO.codificarContra(tfContraRegistro.getText()), "");
						entrenadorDAO.insertEntrenador(entrenador);
						JOptionPane.showMessageDialog(null, "Entrenador creado");

						verLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador,
								lblFondoLogin, lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin,
								btnVerRegistro, btnInicioSesion);

						ocultarRegistro(lblNombreRegister, tfNombreRegister, lblApellidosRegister, tfApellidosRegister,
								lblContraRegistro, lblEdadRegister, tfEdadRegister, tfUsuarioRegistro,
								lblUsuarioRegistro, lblEmailRegister, tfEmailRegister, tfContraRegistro,
								lblFondoRegistro, lblTituloRegister, lblTituloRegister2, lblDivisionRegister,
								btnRegistro, btnVerLogin);
					}
				}
			}
		});
		btnRegistro.setBounds(927, 554, 486, 33);
		frmFirePunch.getContentPane().add(btnRegistro);

		btnVerLogin = new JButton("Iniciar sesión");
		btnVerLogin.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		btnVerLogin.setForeground(Color.DARK_GRAY);
		btnVerLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerLogin.setBackground(new Color(237, 237, 237));
		btnVerLogin.setBounds(927, 650, 486, 33);
		frmFirePunch.getContentPane().add(btnVerLogin);

		ocultarRegistro(lblNombreRegister, tfNombreRegister, lblApellidosRegister, tfApellidosRegister,
				lblContraRegistro, lblEdadRegister, tfEdadRegister, tfUsuarioRegistro, lblUsuarioRegistro,
				lblEmailRegister, tfEmailRegister, tfContraRegistro, lblFondoRegistro, lblTituloRegister,
				lblTituloRegister2, lblDivisionRegister, btnRegistro, btnVerLogin);

		lblContraLogin = new JLabel("Contraseña");
		lblContraLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContraLogin.setBounds(926, 364, 94, 14);
		frmFirePunch.getContentPane().add(lblContraLogin);

		lblUsuarioLogin = new JLabel("Usuario");
		lblUsuarioLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsuarioLogin.setBounds(926, 304, 66, 20);
		frmFirePunch.getContentPane().add(lblUsuarioLogin);

		tfUsuarioEntrenador = new JTextField();
		tfUsuarioEntrenador.setBounds(1079, 307, 292, 20);
		frmFirePunch.getContentPane().add(tfUsuarioEntrenador);
		tfUsuarioEntrenador.setColumns(10);

		tfContraEntrenador = new JPasswordField();
		tfContraEntrenador.setBounds(1079, 363, 292, 20);
		frmFirePunch.getContentPane().add(tfContraEntrenador);
		tfContraEntrenador.setColumns(10);

		lblFondoLogin = new JLabel("");
		lblFondoLogin.setBounds(0, 0, 775, 811);

		ImageIcon imageIconLoginApp = new ImageIcon("src/main/resources/fondoLogin.png");
		Image imageLoginApp = imageIconLoginApp.getImage().getScaledInstance(lblFondoLogin.getWidth(),
				lblFondoLogin.getHeight(), Image.SCALE_SMOOTH);
		lblFondoLogin.setIcon(new ImageIcon(imageLoginApp));
		frmFirePunch.getContentPane().add(lblFondoLogin);

		lblTituloLogin = new JLabel("¡Hola, estás de vuelta!");
		lblTituloLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTituloLogin.setBounds(921, 185, 290, 33);
		frmFirePunch.getContentPane().add(lblTituloLogin);

		lblTituloLogin2 = new JLabel("Introduce tus datos para entrar a la app de gestión");
		lblTituloLogin2.setForeground(Color.GRAY);
		lblTituloLogin2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTituloLogin2.setBounds(921, 229, 470, 33);
		frmFirePunch.getContentPane().add(lblTituloLogin2);

		lblOlvideContra = new JLabel("Olvidé la contraseña");
		lblOlvideContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfUsuarioEntrenador.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Introduce al menos el nombre de usuario.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Entrenador entrenador = entrenadorDAO.selectEntrenadorByUserName(tfUsuarioEntrenador.getText());
					JOptionPane.showMessageDialog(null,
							"Tu contraseña es: " + entrenadorDAO.descodificarContra(entrenador.getContrasenya()));
				}
			}
		});
		lblOlvideContra.setForeground(Color.GRAY);
		lblOlvideContra.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblOlvideContra.setBounds(1203, 413, 170, 20);
		frmFirePunch.getContentPane().add(lblOlvideContra);

		lblDivisionLogin = new JLabel("");
		lblDivisionLogin.setBounds(926, 527, 445, 18);
		ImageIcon imageIconDivision = new ImageIcon("src/main/resources/divisionLogin.png");
		Image imageDivision = imageIconDivision.getImage().getScaledInstance(lblDivisionLogin.getWidth(),
				lblDivisionLogin.getHeight(), Image.SCALE_SMOOTH);
		lblDivisionLogin.setIcon(new ImageIcon(imageDivision));
		frmFirePunch.getContentPane().add(lblDivisionLogin);

		btnVerRegistro = new JButton("Regístrate");

		btnInicioSesion = new JButton("Iniciar sesión");
		btnInicioSesion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicioSesion.setForeground(Color.WHITE);
		btnInicioSesion.setBackground(Color.DARK_GRAY);
		btnInicioSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Comprobación de errores de los campos del entrenador. Si alguno de los campos
				 * está en blanco no deja continuar y si está todo en el formato correcto se
				 * puede realizar la inserción de datos. Por último rellena la tabla de entrenar
				 * y clientes con los datos pertinentes
				 */
				if (tfUsuarioEntrenador.getText().isEmpty() || tfContraEntrenador.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos, por favor.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						Entrenador entrenadorNombreUsuario = entrenadorDAO
								.selectEntrenadorByUserName(tfUsuarioEntrenador.getText());
						entrenadorNombreUsuario.getContrasenya();

						String password = "";
						String user = tfUsuarioEntrenador.getText();

						password = entrenadorDAO.codificarContra(tfContraEntrenador.getText());

						if (!(password.equals(entrenadorNombreUsuario.getContrasenya()))) {
							JOptionPane.showMessageDialog(null, "La contraseña no es correcta.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else if (!(user.equals(entrenadorNombreUsuario.getUsuario()))) {
							JOptionPane.showMessageDialog(null, "El usuario no es correcto.", "Error",
									JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
							tfNombrePerfil.setText(entrenadorNombreUsuario.getNombre());
							tfApellidosPerfil.setText(entrenadorNombreUsuario.getApellidos());
							tfEdadPerfil.setText("" + entrenadorNombreUsuario.getEdad());
							tfUsuarioPerfil.setText(entrenadorNombreUsuario.getUsuario());
							usuarioLogeado = entrenadorNombreUsuario.getUsuario();
							tfEmailPerfil.setText(entrenadorNombreUsuario.getEmail());
							tfContraPerfil.setText(
									entrenadorDAO.descodificarContra(entrenadorNombreUsuario.getContrasenya()));

							List<Cliente> clientes = clienteDAO.selectClientesPorEntrenadorYSinAsignar(
									entrenadorDAO.selectEntrenadorByUserName(usuarioLogeado).getIdEntrenador());
							List<Entrenador> entrenadores = entrenadorDAO.selectAllEntrenador();
							modelCliente.setRowCount(0);
							modelCliente2.setRowCount(0);
							for (Cliente c : clientes) {
								Object[] row = new Object[7];
								row[0] = c.getIdCliente();
								row[1] = c.getNombre();
								row[2] = c.getApellidos();
								row[3] = c.getEdad();
								row[4] = (int) c.getAltura();
								row[5] = c.getPeso();
								for (Entrenador en : entrenadores) {
									en = entrenadorDAO.selectEntrenadorById(c.getEntrenador().getIdEntrenador());
									row[6] = en.getUsuario();
								}
								modelCliente.addRow(row);
								modelCliente2.addRow(row);
							}

							verHome(lblHomePage, cbCategorias, lblCategoria, lblFotoSubidaClientes,
									lblFotoSubidaEjercicios, tableClientes, scrollPane, btnEligeFotoEjercicio,
									tableEjercicios, scrollPane2, btnEligeFoto, btnInsertarCliente,
									btnInsertarEjercicio, btnActualizarEjercicio, btnActualizarCliente,
									btnBorrarCliente, btnBorrarEjercicio, tfIDCliente, tfNombreCliente, tfEdadCliente,
									tfAlturaCliente, tfPesoCliente, tfIDEjercicio, tfNombreEjercicio, tfSeriesEjercicio,
									tfRepeticionesEjercicio, tfCargaEjercicio, tfApellidosCliente, lblIDCliente,
									lblNombreCliente, lblApellidosCliente, lblEdadCliente, lblAlturaCliente,
									lblPesoCliente, lblCargakg, lblRepeticiones, lblSeries, lblNombreEjercicio,
									lblIDEjercicio, lblFotoCliente, lblFotoEjercicio, btnAsignarmeCliente);
							mostrarMenu(lblMenu, lblHome, lblPerfil, lblOpciones, lblEntrenar, lblFondoMenu,
									lblLogoApp);
							ocultarLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador,
									lblFondoLogin, lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin,
									btnVerRegistro, btnInicioSesion);

							ocultarRegistro(lblNombreRegister, tfNombreRegister, lblApellidosRegister,
									tfApellidosRegister, lblContraRegistro, lblEdadRegister, tfEdadRegister,
									tfUsuarioRegistro, lblUsuarioRegistro, lblEmailRegister, tfEmailRegister,
									tfContraRegistro, lblFondoRegistro, lblTituloRegister, lblTituloRegister2,
									lblDivisionRegister, btnRegistro, btnVerLogin);

						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "El usuario no existe.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnInicioSesion.setBounds(926, 467, 445, 33);
		frmFirePunch.getContentPane().add(btnInicioSesion);

		btnVerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ocultarLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador, lblFondoLogin,
						lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin, btnVerRegistro,
						btnInicioSesion);
				verRegistro(lblNombreRegister, tfNombreRegister, lblApellidosRegister, tfApellidosRegister,
						lblContraRegistro, lblEdadRegister, tfEdadRegister, tfUsuarioRegistro, lblUsuarioRegistro,
						lblEmailRegister, tfEmailRegister, tfContraRegistro, lblFondoRegistro, lblTituloRegister,
						lblTituloRegister2, lblDivisionRegister, btnRegistro, btnVerLogin);
			}
		});
		btnVerRegistro.setBorder(new LineBorder(new Color(64, 64, 64), 2));
		btnVerRegistro.setForeground(Color.DARK_GRAY);
		btnVerRegistro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVerRegistro.setBackground(new Color(237, 237, 237));
		btnVerRegistro.setBounds(926, 574, 445, 33);
		frmFirePunch.getContentPane().add(btnVerRegistro);

		btnVerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ocultarRegistro(lblNombreRegister, tfNombreRegister, lblApellidosRegister, tfApellidosRegister,
						lblContraRegistro, lblEdadRegister, tfEdadRegister, tfUsuarioRegistro, lblUsuarioRegistro,
						lblEmailRegister, tfEmailRegister, tfContraRegistro, lblFondoRegistro, lblTituloRegister,
						lblTituloRegister2, lblDivisionRegister, btnRegistro, btnVerLogin);
				verLogin(lblUsuarioLogin, lblContraLogin, tfUsuarioEntrenador, tfContraEntrenador, lblFondoLogin,
						lblTituloLogin, lblTituloLogin2, lblOlvideContra, lblDivisionLogin, btnVerRegistro,
						btnInicioSesion);
			}
		});
	}
}