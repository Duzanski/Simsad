package br.com.simsad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.simsad.bean.Laboratorio;
import br.com.simsad.bean.Paciente;
import br.com.simsad.util.HibernateUtil;

public class PacienteDAO {

	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto pacienteBean */

	public void salvar(Paciente pacienteBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(pacienteBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Paciente !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela exclusão do objeto pacienteBean */

	public void excluir(Laboratorio pacienteBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(pacienteBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Paciente !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela busca de todos os Pacientes */

	@SuppressWarnings("unchecked")
	public List<Paciente> buscarPacienteTodos() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Paciente> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Paciente.class);

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
