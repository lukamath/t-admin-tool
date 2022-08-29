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

import it.fpcs.lam.formapro.entities.Struttura;
import it.fpcs.lam.formapro.entities.Tirocinio;
import it.fpcs.lam.formapro.services.TirocinioService;


@WebServlet("/GetTirocinioDetails")
public class GetTirocinioDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TemplateEngine templateEngine;
	@EJB(name="it.fpcs.lam.formapro.services/TirocinioService")
	private TirocinioService trs;
	
    public GetTirocinioDetails() {
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
		List<Tirocinio> tirocini= new ArrayList<Tirocinio>();
		
		int iscrizioneid;
		try {
			iscrizioneid = Integer.parseInt(request.getParameter("iscrizioneid"));
		} catch (NumberFormatException | NullPointerException e) {
			// only for debugging e.printStackTrace();
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Incorrect param values");
			return;
		}
		
		try {
			tirocini=trs.findTirociniByIscrizione(iscrizioneid);
			}catch (Exception e){
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get data");
				return;
			}
			
		
		String path = "/WEB-INF/TirocinioDetails.html";
		ServletContext servletContext = getServletContext();
		final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
		ctx.setVariable("tirocini", tirocini);
		templateEngine.process(path, ctx, response.getWriter());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


