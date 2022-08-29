package it.fpcs.lam.formapro.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import it.fpcs.lam.formapro.entities.Corso;
import it.fpcs.lam.formapro.entities.Edizione;
import it.fpcs.lam.formapro.entities.Studente;
import it.fpcs.lam.formapro.services.CorsoService;
import it.fpcs.lam.formapro.services.EdizioneService;
import it.fpcs.lam.formapro.services.StudenteService;


@WebServlet("/GetEditionDetails")
public class GetEditionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TemplateEngine templateEngine;
	@EJB(name = "it.fpcs.lam.formapro.services/EdizioneService")
	private EdizioneService eds;
	@EJB(name = "it.fpcs.lam.formapro.services/StudenteService")
	private StudenteService stds;
	@EJB(name = "it.fpcs.lam.formapro.services/CorsoService")
	private CorsoService crs;
	
    public GetEditionDetails() {
        super();
    }
    
    public void init() throws ServletException {
		ServletContext servletContext = getServletContext();
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
		templateResolver.setTemplateMode(TemplateMode.HTML);
		this.templateEngine = new TemplateEngine();
		this.templateEngine.setTemplateResolver(templateResolver);
		templateResolver.setSuffix(".html");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Studente> studenti = new ArrayList<Studente>();
		// get and check params
		Integer edizioneid = null;
		Edizione edi=null;
		String nomeCorso=null;
		try {
			edizioneid = Integer.parseInt(request.getParameter("edizioneid"));
		} catch (NumberFormatException | NullPointerException e) {
			// only for debugging e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Incorrect param values");
			return;
		}
		
		try {
			studenti=stds.findStudentsByEdition(edizioneid);
			}catch (Exception e){
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get data");
				return;
			}
			
		
		try {
			edi=eds.findCourseByEdition(edizioneid);
			}catch (Exception e){
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get data");
				return;
			}
		
		Integer corsoid=edi.getIdCorso();
		
		try {
			nomeCorso=crs.findCorsoById(corsoid).getTipoCorso();
			}catch (Exception e){
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get data");
				return;
			}
		
		
//		try {
//			//corso= crs.findCorsoByEditionId(edizioneid);
//			cid= crs.findCorsoByEditionId(edizioneid);
//			}catch (Exception e){
//				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get CORSO data");
//				return;
//			}		
//		
			// Redirect to the Home page and add missions to the parameters
					String path = "/WEB-INF/EditionDetails.html";
					ServletContext servletContext = getServletContext();
					final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
					ctx.setVariable("studenti", studenti);
					//ctx.setVariable("corso", corso);
					ctx.setVariable("corso", nomeCorso);
					templateEngine.process(path, ctx, response.getWriter());
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
