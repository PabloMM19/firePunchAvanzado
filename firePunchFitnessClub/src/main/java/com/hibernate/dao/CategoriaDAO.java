package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Categoria;
import com.hibernate.util.HibernateUtil;

public class CategoriaDAO {

	/**
	 * Inserta una nueva categoría en la base de datos.
	 * 
	 * @param c la categoría a insertar
	 */
	public void insertCategoria(Categoria c) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Actualiza una categoría existente en la base de datos.
	 * 
	 * @param c la categoría a actualizar
	 */
	public void updateCategoria(Categoria c) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Elimina una categoría de la base de datos dado su código.
	 * 
	 * @param codigo el código de la categoría a eliminar
	 */
	public void deleteCategoria(int codigo) {
		Transaction transaction = null;
		Categoria c = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Categoria.class, codigo);
			session.remove(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	/**
	 * Obtiene todas las categorías almacenadas en la base de datos.
	 * 
	 * @return una lista de todas las categorías
	 */
	public List<Categoria> selectAllCategoria() {
		Transaction transaction = null;
		List<Categoria> categorias = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			categorias = session.createQuery("from Categoria", Categoria.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return categorias;
	}

	/**
	 * Obtiene una categoría de la base de datos dado su código.
	 * 
	 * @param codigo el código de la categoría a obtener
	 * @return la categoría correspondiente al código especificado
	 */
	public Categoria selectCategoriaById(int codigo) {
		Transaction transaction = null;
		Categoria c = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Categoria.class, codigo);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}

		return c;
	}

}
