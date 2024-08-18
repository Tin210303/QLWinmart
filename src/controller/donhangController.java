package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.chitiethoadondao;
import dao.hoadondao;

/**
 * Servlet implementation class donhangController
 */
@WebServlet("/donhangController")
public class donhangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public donhangController() {
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
			HttpSession session = request.getSession();
			hoadondao hddao = new hoadondao();
			chitiethoadondao ctdao = new chitiethoadondao();
			if(session.getAttribute("dn") != null) {
				String makhach = request.getParameter("makh");
				String mahd = request.getParameter("mahd");
				
				
				if(makhach != null) {
					long makh = Long.parseLong(makhach);
					request.setAttribute("dshoadon", hddao.gethoadon(makh));
				}
				if(mahd != null) {
					long mahoadon= Long.parseLong(mahd);
					request.setAttribute("dschitiet", ctdao.getchitiet(mahoadon));
				}
			}
			RequestDispatcher rd= request.getRequestDispatcher("donhnag.jsp");
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
