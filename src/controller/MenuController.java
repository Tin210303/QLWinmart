package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.hangbo;
import bo.loaibo;
import bo.sanphambo;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
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
			String ml= request.getParameter("ml");
			String msp = request.getParameter("msp");
			String searchinput = request.getParameter("searchinput");
			
			loaibo lbo= new loaibo();
			sanphambo spbo= new sanphambo();
			hangbo hbo= new hangbo();
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dshang", hbo.gethang());
			if(ml != null) {
				request.setAttribute("dssanpham", spbo.timSPtheoMaLoai(ml));
			}
			if(msp != null) {
				request.setAttribute("dshang", hbo.timhangtheomasp(msp));
			}
			if(searchinput != null) {
				request.setAttribute("dshang", hbo.timhangtheoten(searchinput));
			}
			RequestDispatcher rd= request.getRequestDispatcher("TrangChu.jsp");
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
