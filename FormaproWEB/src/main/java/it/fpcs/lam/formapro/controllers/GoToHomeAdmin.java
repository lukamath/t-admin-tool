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

import it.fpcs.lam.formapro.entities.Edizione;
import it.fpcs.lam.formapro.services.EdizioneService;

@WebServlet("/GoToHomeAdmin")
public class GoToHomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TemplateEngine templateEngine;
	@EJB(name = "it.fpcs.lam.formapro.services/EdizioneService")
	private EdizioneService eds;

    public GoToHomeAdmin() {
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
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Edizione> edizioni =new ArrayList<Edizione>();
		try {
		edizioni=eds.findAllEditions();
		}catch (Exception e){
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get All ServicePackages");
			return;
		}

		// Redirect to the Home page and add servicepackages to the parameters
		String path = "/WEB-INF/HomeAdmin.html";
		ServletContext servletContext = getServletContext();
		final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
		ctx.setVariable("edizioni", edizioni);
		templateEngine.process(path, ctx, response.getWriter());			
	}

}
