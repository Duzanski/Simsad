package br.com.simsad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.simsad.bean.Medicamento;
import br.com.simsad.util.HibernateUtil;


public class MedicamentoDAO {


	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto medicamentoBean */

	public void salvar(Medicamento medicamentoBean) throws Exception {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(medicamentoBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Medicamento!");

		} finally {

			session.close();
		}
	}

	/* Método responsável pela persistência do objeto medicamentoBean */

	public void excluir(Medicamento medicamentoBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(medicamentoBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Medicamento!");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela busca de Medicamentos por nome */

	@SuppressWarnings("unchecked")
	public List<Medicamento> buscarPorNome(Medicamento medicamentoBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Medicamento> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Medicamento.class);
			criteria.add(Restrictions.ilike("nome", "%" + medicamentoBean.getNome() + "%"));


			lista = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

	/* Método responsável pela busca de todos os Medicamentos */

	@SuppressWarnings("unchecked")
	public List<Medicamento> buscarMedicamentoTodos() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Medicamento> lista = null;


		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Medicamento.class);

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
