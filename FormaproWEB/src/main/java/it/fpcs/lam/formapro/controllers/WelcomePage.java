package it.fpcs.lam.formapro.controllers;

import java.io.IOException;
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

/**
 * Servlet implementation class WelcomePage
 */
@WebServlet("/WelcomePage")
public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TemplateEngine templateEngine;
//	@EJB(name = "it.fpcs.lam.formapro.services/EdizioneService")
//	private EdizioneService eds;
	
    public WelcomePage() {
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<Edizione> edizioni =new ArrayList<Edizione>();
//		try {
//		edizioni=eds.findAllEditions();
//		}catch (Exception e){
//			e.printStackTrace();
//			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Not possible to get All ServicePackages");
//			return;
//		}
		
		// Redirect to the Home page and add servicepackages to the parameters
				String path = "/index.html";
				ServletContext servletContext = getServletContext();
				final WebContext ctx = new WebContext(request, response, servletContext, request.getLocale());
				//ctx.setVariable("edizioni", edizioni);
				templateEngine.process(path, ctx, response.getWriter());				
	}

}
