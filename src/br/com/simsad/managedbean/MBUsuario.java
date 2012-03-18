package br.com.simsad.managedbean;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.simsad.bean.Usuario;
import br.com.simsad.dao.UsuarioDAO;

@ManagedBean(name = "MBUsuario")
@SessionScoped
public class MBUsuario implements Serializable {

	private static final long serialVersionUID = 1;

	/* Objeto da classe Usuário */

	private Usuario usuarioBean = new Usuario();

	/* Método responsável pela validação do Usuário */

	@SuppressWarnings("static-access")
	public String validaUsuario() {

		FacesContext context = FacesContext.getCurrentInstance();


		try {

			UsuarioDAO dao = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario = dao.buscarUsuarioObj(usuarioBean);

			if (usuario == null) {
				context.addMessage(null, new FacesMessage("Usuário/Senha estão incorretos!"));
			}
			else {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", usuario);

				return "loginOk";
			}


		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

	/* Método responsável pelo encerramento da Sessão */

	@SuppressWarnings("static-access")
	public String encerraSessao() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getCurrentInstance().getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("currentUser");

		usuarioBean = new Usuario();

		return "redirect";

	}

	/* Getters and Setters */

	public Usuario getUsuarioBean() {

		return usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {

		this.usuarioBean = usuarioBean;
	}

}
