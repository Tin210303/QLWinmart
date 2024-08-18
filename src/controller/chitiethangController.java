package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import bo.giohangbo;
import bo.hangbo;
import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class chitiethangController
 */
@WebServlet("/chitiethangController")
public class chitiethangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chitiethangController() {
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
			sanphambo spbo= new sanphambo();
			hangbo hbo= new hangbo();
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dshang", hbo.gethang());
			String mh= request.getParameter("mh");
			String th= request.getParameter("th");
			String gia= request.getParameter("gia");
			String dvt= request.getParameter("dvt");
			String sl= "1";
			String anh= request.getParameter("anh");
			if(mh!=null && th!=null && gia!=null && sl!=null) {
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
				response.sendRedirect("chitiethangController");
				return;
			}
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
