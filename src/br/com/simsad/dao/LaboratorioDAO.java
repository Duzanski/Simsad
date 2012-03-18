package br.com.simsad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.simsad.bean.Laboratorio;
import br.com.simsad.util.HibernateUtil;

public class LaboratorioDAO {

	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto laboratorioBean */

	public void salvar(Laboratorio laboratorioBean) throws Exception {


		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(laboratorioBean);
			transaction.commit();


		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Laboratorio!");

		}

		finally {

			session.close();

		}

	}

	/* Método responsável pela exclusão do objeto laboratorioBean */

	public void excluir(Laboratorio laboratorioBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(laboratorioBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Laboratorio!");

		} finally {

			session.close();
		}


	}

	/* Método responsável pela busca de Laboratórios por nome */

	@SuppressWarnings("unchecked")
	public List<Laboratorio> buscarPorNome(Laboratorio laboratorioBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Laboratorio> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Laboratorio.class);
			criteria.add(Restrictions.ilike("nome", "%" + laboratorioBean.getNome() + "%"));

			lista = criteria.list();
			transaction.commit();


		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

	/* Método responsável pela busca de todos os Laboratórios */

	@SuppressWarnings("unchecked")
	public List<Laboratorio> buscarLaboratorio() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Laboratorio> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Laboratorio.class);

			lista = criteria.list();
			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

}
