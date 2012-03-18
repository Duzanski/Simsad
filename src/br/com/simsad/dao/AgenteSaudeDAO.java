package br.com.simsad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.simsad.bean.AgenteSaude;
import br.com.simsad.util.HibernateUtil;

public class AgenteSaudeDAO {

	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto agenteSaudeBean */

	public void salvar(AgenteSaude agenteSaudeBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(agenteSaudeBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Agente de Saude !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela exclusão do objeto agenteSaudeBean */

	public void excluir(AgenteSaude agenteSaudeBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(agenteSaudeBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Agente de Saude !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela busca de Agentes de Saúde por nome */

	@SuppressWarnings("unchecked")
	public List<AgenteSaude> buscarPorNome(AgenteSaude agenteSaudeBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<AgenteSaude> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AgenteSaude.class);
			criteria.add(Restrictions.ilike("nome", "%" + agenteSaudeBean.getNome() + "%"));


			lista = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

	/* Método responsável pela busca de todos os Agentes de Saúde */

	@SuppressWarnings("unchecked")
	public List<AgenteSaude> buscarAgenteSaudeTodos() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<AgenteSaude> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AgenteSaude.class);

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
