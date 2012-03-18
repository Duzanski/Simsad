package br.com.simsad.dao;


import br.com.simsad.bean.UnidadeSaude;
import br.com.simsad.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class UnidadeSaudeDAO {

	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto unidadeSaudeBean */

	public void salvar(UnidadeSaude unidadeSaudeBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(unidadeSaudeBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Unidade de Saude !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela exclusao do objeto unidadeSaudeBean */

	public void excluir(UnidadeSaude unidadeSaudeBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(unidadeSaudeBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Unidade de Saude !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela busca de Unidades de Saúde por nome */

	@SuppressWarnings("unchecked")
	public List<UnidadeSaude> buscarPorNome(UnidadeSaude unidadeSaudeBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UnidadeSaude> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UnidadeSaude.class);
			criteria.add(Restrictions.ilike("nome", "%" + unidadeSaudeBean.getNome() + "%"));


			lista = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

	/* Método responsável pela busca de todas as Unidades de Saúde */

	@SuppressWarnings("unchecked")
	public List<UnidadeSaude> buscarUnidadeSaude() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<UnidadeSaude> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UnidadeSaude.class);

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
