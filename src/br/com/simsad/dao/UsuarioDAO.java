package br.com.simsad.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.simsad.bean.Usuario;
import br.com.simsad.util.HibernateUtil;

public class UsuarioDAO {

	Session session = null;
	Transaction transaction = null;

	/* Método responsável pela persistência do objeto usuarioBean */

	public void salvar(Usuario usuarioBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(usuarioBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao salvar Usuário !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela exclusão do objeto usuarioBean */

	public void excluir(Usuario usuarioBean) throws Exception {

		try {

			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(usuarioBean);
			transaction.commit();

		} catch (Exception e) {

			transaction.rollback();
			throw new Exception("Erro ao excluir Usuario !");

		} finally {

			session.close();
		}

	}

	/* Método responsável pela busca de Usuarios por nome e senha */

	public Usuario buscarUsuarioObj(Usuario usuarioBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Usuario u = new Usuario();

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.eq("nome", usuarioBean.getNome()));
			criteria.add(Restrictions.eq("senha", usuarioBean.getSenha()));


			u = (Usuario) criteria.uniqueResult();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return (Usuario) u;

	}

	/* Método responsável pela busca de Usuários por nome */

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarPorNome(Usuario usuarioBean) throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class);
			criteria.add(Restrictions.ilike("nome", "%" + usuarioBean.getNome() + "%"));


			lista = criteria.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			session.close();

		}

		return lista;

	}

	/* Método responsável pela busca de todos os Usuários */

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarUsuarioTodos() throws Exception {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> lista = null;

		try {

			Transaction transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Usuario.class);

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