package br.com.simsad.managedbean;

import java.sql.Connection;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import br.com.simsad.bean.Paciente;
import br.com.simsad.util.HibernateUtil;

@ManagedBean(name = "MBRelatorio")
@ViewScoped
public class MBRelatorio {

	/* Objeto da classe Paciente */

	private Paciente beanPaciente = new Paciente();

	/* M�todo respons�vel pela emiss�o de relat�rios gr�ficos de glicemia por paciente */

	@SuppressWarnings("deprecation")
	public void gerarRelatorioGraficoPacienteGlicemia() {


		if (beanPaciente != null) {

			try {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("ID_PESSOA", beanPaciente.getIdPessoa());

				String path = scontext.getRealPath("/WEB-INF/relatorio/Paciente_Grafico_Glicemia.jasper");

				Connection conn = HibernateUtil.getSessionFactory().openSession().connection();

				JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, conn);

				// Exporta para o disco f�sico
				// JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/teste/teste.pdf");

				byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

				HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				res.setContentType("application/pdf");
				res.setHeader("Content-disposition", "attachment;filename=grafico_glicemia_paciente.pdf");

				ServletOutputStream sos = (ServletOutputStream) res.getOutputStream();
				sos.write(b);
				sos.flush();
				sos.close();

				facesContext.responseComplete();


			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/* M�todo respons�vel pela emiss�o de relat�rios gr�ficos de hipertens�o por paciente */

	@SuppressWarnings("deprecation")
	public void gerarRelatorioPacienteGraficoHipertensao() {


		if (beanPaciente != null) {

			try {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("ID_PESSOA", beanPaciente.getIdPessoa());

				String path = scontext.getRealPath("/WEB-INF/relatorio/Paciente_Grafico_Hiper.jasper");

				Connection conn = HibernateUtil.getSessionFactory().openSession().connection();

				JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, conn);

				// Exporta para o disco f�sico
				// JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/teste/teste.pdf");

				byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

				HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				res.setContentType("application/pdf");
				res.setHeader("Content-disposition", "attachment;filename=grafico_hipertensao_paciente.pdf");

				ServletOutputStream sos = (ServletOutputStream) res.getOutputStream();
				sos.write(b);
				sos.flush();
				sos.close();

				facesContext.responseComplete();


			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/* M�todo respons�vel pela emiss�o de relat�rios detalhados por paciente */

	@SuppressWarnings("deprecation")
	public void gerarRelatorioPaciente() {


		if (beanPaciente != null) {

			try {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("ID_PESSOA", beanPaciente.getIdPessoa());

				String path = scontext.getRealPath("/WEB-INF/relatorio/Paciente.jasper");

				Connection conn = HibernateUtil.getSessionFactory().openSession().connection();


				JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, conn);

				// Exporta para o disco f�sico
				// JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/teste/teste.pdf");

				byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

				HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				res.setContentType("application/pdf");
				res.setHeader("Content-disposition", "attachment;filename=paciente_detalhado.pdf");

				ServletOutputStream sos = (ServletOutputStream) res.getOutputStream();
				sos.write(b);
				sos.flush();
				sos.close();

				facesContext.responseComplete();


			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/* M�todo respons�vel pela emiss�o de relat�rios de medica��o por paciente */

	@SuppressWarnings("deprecation")
	public void gerarRelatorioMedicamentoPaciente() {


		if (beanPaciente != null) {

			try {

				FacesContext facesContext = FacesContext.getCurrentInstance();
				ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();

				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("ID_PESSOA", beanPaciente.getIdPessoa());

				String path = scontext.getRealPath("/WEB-INF/relatorio/Medicamento_Paciente.jasper");

				Connection conn = HibernateUtil.getSessionFactory().openSession().connection();

				JasperPrint jasperPrint = JasperFillManager.fillReport(path, params, conn);

				// Exporta para o disco f�sico
				// JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/teste/teste.pdf");

				byte[] b = JasperExportManager.exportReportToPdf(jasperPrint);

				HttpServletResponse res = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				res.setContentType("application/pdf");
				res.setHeader("Content-disposition", "attachment;filename=medicamento_paciente.pdf");

				ServletOutputStream sos = (ServletOutputStream) res.getOutputStream();
				sos.write(b);
				sos.flush();
				sos.close();

				facesContext.responseComplete();


			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public Paciente getBeanPaciente() {

		return beanPaciente;
	}


	public void setBeanPaciente(Paciente beanPaciente) {

		this.beanPaciente = beanPaciente;
	}


}
