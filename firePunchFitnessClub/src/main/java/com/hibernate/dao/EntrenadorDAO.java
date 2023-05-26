package com.hibernate.dao;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.model.Entrenador;
import com.hibernate.util.HibernateUtil;

public class EntrenadorDAO {
	
	String secretKey = "Prueba1";
	
	/**
	 * Inserta un nuevo entrenador en la base de datos.
	 * 
	 * @param e el entrenador a insertar
	 */
	public void insertEntrenador(Entrenador e) {
	    Transaction transaction = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.persist(e);
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }
	}

	/**
	 * Actualiza un entrenador existente en la base de datos.
	 * 
	 * @param e el entrenador a actualizar
	 */
	public void updateEntrenador(Entrenador e) {
	    Transaction transaction = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.merge(e);
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }
	}

	/**
	 * Elimina un entrenador de la base de datos dado su código.
	 * 
	 * @param codigo el código del entrenador a eliminar
	 */
	public void deleteEntrenador(int codigo) {
	    Transaction transaction = null;
	    Entrenador e = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        e = session.get(Entrenador.class, codigo);
	        session.remove(e);
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }
	}

	/**
	 * Obtiene todos los entrenadores almacenados en la base de datos.
	 * 
	 * @return una lista de todos los entrenadores
	 */
	public List<Entrenador> selectAllEntrenador() {
	    Transaction transaction = null;
	    List<Entrenador> entrenadores = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        entrenadores = session.createQuery("from Entrenador", Entrenador.class).getResultList();
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }

	    return entrenadores;
	}

	/**
	 * Obtiene un entrenador de la base de datos dado su código.
	 * 
	 * @param codigo el código del entrenador
	 * @return el entrenador encontrado o null si no existe
	 */
	public Entrenador selectEntrenadorById(int codigo) {
	    Transaction transaction = null;
	    Entrenador e = null;

	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        e = session.get(Entrenador.class, codigo);
	        transaction.commit();
	    } catch (Exception ex) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	    }

	    return e;
	}

	/**
	 * Obtiene un entrenador de la base de datos dado su nombre de usuario.
	 * 
	 * @param userName el nombre de usuario del entrenador
	 * @return el entrenador encontrado o null si no existe
	 */
	public Entrenador selectEntrenadorByUserName(String userName) {

		Transaction transaction = null;
		Entrenador e = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Entrenador> query = session.createQuery("FROM Entrenador WHERE usuario = :usuarioParam", Entrenador.class);
			query.setParameter("usuarioParam", userName);
			e = query.uniqueResult();
			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null) {

				transaction.rollback();
			}
		}
		return e;
	}
	
	/**
	 * Codifica una cadena de texto utilizando el algoritmo de encriptación DESede con una clave secreta.
	 * 
	 * @param cadena la cadena de texto a codificar
	 * @return la cadena de texto codificada
	 */
	public String codificarContra(String cadena) {
		 String encriptacion = "";
	        try {
	            MessageDigest md5 = MessageDigest.getInstance("MD5");
	            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
	            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
	            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
	            Cipher cifrado = Cipher.getInstance("DESede");
	            cifrado.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainTextBytes = cadena.getBytes("utf-8");
	            byte[] buf = cifrado.doFinal(plainTextBytes);
	            byte[] base64Bytes = Base64.encodeBase64(buf);
	            encriptacion = new String(base64Bytes);
	        } catch (Exception ex) {
	           
	        }
	        return encriptacion;
	}
	
	/**
	 * Descodifica una cadena de texto encriptada utilizando el algoritmo de encriptación DESede con una clave secreta.
	 * 
	 * @param cadenaEncriptada la cadena de texto encriptada
	 * @return la cadena de texto descodificada
	 */
	public String descodificarContra(String cadenaEncriptada) {
		String desencriptacion = "";
       try {
           byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
           MessageDigest md5 = MessageDigest.getInstance("MD5");
           byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
           byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
           SecretKey key = new SecretKeySpec(keyBytes, "DESede");
           Cipher decipher = Cipher.getInstance("DESede");
           decipher.init(Cipher.DECRYPT_MODE, key);
           byte[] plainText = decipher.doFinal(message);
           desencriptacion = new String(plainText, "UTF-8");

       } catch (Exception ex) {
         
       }
       return desencriptacion;
	}
}
