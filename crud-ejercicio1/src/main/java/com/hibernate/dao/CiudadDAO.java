package com.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Ciudad;
import com.hibernate.util.HibernateUtil;
import com.mysql.cj.Query;

public class CiudadDAO {

	/**
	 * INSERCIÓN
	 */
	
	public void insertCiudad(Ciudad c) {
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
	 * ACTUALIZACIÓN
	 */
	
	public void updateCiudad(Ciudad c) {
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
	 * BORRADO
	 */
	
	public void deleteCiudad(int id) {
		Transaction transaction = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Ciudad.class, id);
			session.remove(c);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	/**
	 * SELECCIÓN SIMPLE
	 */
	
	public Ciudad selectCiudadById(int id) {
		Transaction transaction = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			c = session.get(Ciudad.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return c;
	}
	
	/**
	 * SELECCIÓN MÚLTIPLE
	 */
	
	public List<Ciudad> selectAllCiudad() {
		Transaction transaction = null;
		List<Ciudad> ciudades = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ciudades = session.createQuery("from Ciudad", Ciudad.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ciudades;
	}
	
	/**
	 * SELECCIÓN MÚLTIPLE 1 MILLÓN DE HABITANTES
	 */
	
	public List<Ciudad> selectCiudad1MHab() {
		Transaction transaction = null;
		List<Ciudad> ciudades = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			ciudades = session.createQuery("from Ciudad where habitantes > 1000000", Ciudad.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ciudades;
	}
	
	/**
	 * SELECCIÓN MÚLTIPLE MENOS HABITANTES DE LOS QUE SE SELECCIONAN
	 */
	
	public List<Ciudad> selectCiudadMenosMHab() {
		Transaction transaction = null;
		List<Ciudad> ciudades = null;
		Ciudad c = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query<Ciudad> query = session.createQuery("from Ciudad where habitantes < :menosHab", Ciudad.class);
			query.setParameter("menosHab");
			List<Ciudad> ciudadesMenosHab = query.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return ciudades;
	}
	
	
}
