package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.khachhangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import dao.hoadondao;

/**
 * Servlet implementation class dathangController
 */
@WebServlet("/dathangController")
public class dathangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dathangController() {
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
            String xn = request.getParameter("DatHangBut");
            if(xn != null) {
                hoadondao hddao = new hoadondao();
                if(session.getAttribute("dn") == null) {
                	response.sendRedirect("donhnag.jsp");
                }
                if(session.getAttribute("dn") != null) {
                	
                	khachhangbean kh = (khachhangbean)session.getAttribute("dn");
                	// them vao hoa don
                	hddao.themhoadon(kh.getMakh());
                	long maxhd = hddao.maxhd();
                	
                	// them vao chi tiet
                	giohangbo gh = (giohangbo)session.getAttribute("gh");
                	chitiethoadonbo ctbo = new chitiethoadonbo();
                	for(giohangbean h : gh.ds) {
                		ctbo.themChiTietHD(h.getMahang(), h.getSoluongmua(), maxhd);
                	}
                }
                session.removeAttribute("gh");
                response.sendRedirect("MenuController");
            }
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
