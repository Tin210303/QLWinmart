package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicGraphicsUtils;

import bean.dangnhapbean;
import bean.khachhangbean;
import bo.dangnhapbo;
import bo.khachhangbo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/dangnhapController")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
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
			
			String un= request.getParameter("txtun");
			String pass= request.getParameter("txtpass");
			String buttonDangNHap = request.getParameter("buttonDangNhap");
			String btndangky = request.getParameter("btndangky");
			String btnbackdn = request.getParameter("btnbackdn");
			if(btnbackdn != null) {
				session.removeAttribute("dangky");
			}
			if(buttonDangNHap != null) {
				response.sendRedirect("dangnhap.jsp");
			}
			if(btndangky != null) {
				session.setAttribute("dangky", "dangky");
			}
			khachhangbo khbo= new khachhangbo();
			khachhangbean kh= khbo.ktdn(un, pass);
			int countDangNhap=0;
			if(session.getAttribute("countDangNhap")==null) {
				session.setAttribute("countDangNhap", countDangNhap);
			}
			else {
				countDangNhap= (int)session.getAttribute("countDangNhap");
			}
			if(countDangNhap < 3) {
				if(khbo.ktdn(un, pass) != null) {
					session.setAttribute("dn", kh);
					response.sendRedirect("MenuController");
					session.removeAttribute("tt");
				    session.removeAttribute("tk");
				}
			}
			if(khbo.ktdn(un, pass) != null) {
				response.getWriter().append("Served at: ").append(request.getContextPath());
				Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
				request.setCharacterEncoding("UTF-8");
				String answer = request.getParameter("answer");
				if(answer==null) {
					response.sendRedirect("dangnhap.jsp");
				}
				else
				if (captcha.isCorrect(answer)) {
				   session.setAttribute("dn", kh);
				   response.sendRedirect("MenuController");
				   session.removeAttribute("tt");
				   session.removeAttribute("tk");

				} else {
					 request.setAttribute("ktcc", "*Vui long nhap dung captcha");
				}
			}
			else {
				request.setAttribute("kt", "*Sai tên đăng nhập hoặc mật khẩu");
				countDangNhap++;
				session.setAttribute("countDangNhap", countDangNhap);
				System.out.println(countDangNhap);
			}
			
			String ht= request.getParameter("txtht");
			String dc= request.getParameter("txtdc");
			String sdt= request.getParameter("txtsdt");
			String email= request.getParameter("txtemail");
			String undk= request.getParameter("txtundk");
			String passdk= request.getParameter("txtpassdk");
			String passrepeat= request.getParameter("txtpassrepeat");
			if(ht!=null && dc!=null && sdt!=null && email!=null && undk!=null && passdk!=null && passrepeat!=null) {
				if(passdk.equals(passrepeat)) {
					if(khbo.ktdn(undk, passdk) != null) {
						session.setAttribute("tt", "*Tài khoản đã tồn tại");
					    session.removeAttribute("tk");
						response.sendRedirect("dangnhap.jsp");
					}else {
						khbo.KhachHang(ht, dc, sdt, email, undk, passdk);
						response.sendRedirect("MenuController");
					}
				}
				if(!passdk.equals(passrepeat)) {
					session.setAttribute("tk", "*Mật khẩu không trùng khớp");
					session.removeAttribute("tt");
					response.sendRedirect("dangnhap.jsp");
				}
				
			}
			
			RequestDispatcher rd= request.getRequestDispatcher("dangnhap.jsp");
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
