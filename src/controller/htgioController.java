package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.giohangbo;
import bo.loaibo;

/**
 * Servlet implementation class htgioController
 */
@WebServlet("/htgioController")
public class htgioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			HttpSession session= request.getSession();
			loaibo lbo= new loaibo();
			request.setAttribute("dsloai", lbo.getloai());
			
			//Dat hang
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String mh = request.getParameter("mh");
			String th = request.getParameter("th");
			String gia= request.getParameter("gia");
			String dvt = request.getParameter("dvt");
			String sl= "1";
			String anh= request.getParameter("anh");
			if(mh!=null && th!=null && gia!=null && sl!=null && dvt !=null) {
				giohangbo g= new giohangbo();
				//Neu mua hang lan dau
				if(session.getAttribute("gh")==null) {
					session.setAttribute("gh",g);
				}
				//Gan session: gh vao bien g
				g=(giohangbo)session.getAttribute("gh");
				//Them hang vao bien g
				g.Them(mh, th,dvt, Long.parseLong(sl), Double.parseDouble(gia), anh);
				//Luu vao bien session
				session.setAttribute("gh", g);
				response.sendRedirect("htgioController");
				return;
			}
			
			//Xoa, sua
			giohangbo g=(giohangbo)session.getAttribute("gh");
			String[] gt= request.getParameterValues("check");
			String tamms = request.getParameter("btn-sua");
			String sl_sua= request.getParameter(tamms);
			String tamxoa= request.getParameter("btn-xoa");
			String xoaall= request.getParameter("btnxoaall");
			String xoacheckbox= request.getParameter("btn-xoacheckbox");
			if(gt!=null) {
				for(String c:gt) {
					g.Xoa(c);
				}
			}
			if (tamms!=null && sl_sua!=null){
				g.Sua(tamms, Long.parseLong(sl_sua));
			}
			if(tamxoa != null) {
				g.Xoa(tamxoa);
			}
			if(xoaall!=null) {
				g.XoaAll();
			}
			if(xoacheckbox !=null) {
				for(String checkbox:gt) {
					g.Xoa(checkbox);
				}
			}
			session.setAttribute("gh", g);
			
			RequestDispatcher rd= request.getRequestDispatcher("chitiethang.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
