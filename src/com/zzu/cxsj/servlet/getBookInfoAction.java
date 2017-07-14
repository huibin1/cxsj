package com.zzu.cxsj.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.zzu.cxsj.Dao.StudentDao;
import com.zzu.cxsj.dbBean.DBStudent;
import com.zzu.cxsj.dbBean.DBXuanke;
import com.zzu.cxsj.dbutils.DBConnection;

/**
 * Servlet implementation class getBookInfoAction
 */
@WebServlet("/getBookInfoAction")
public class getBookInfoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getBookInfoAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userid = (String) request.getSession().getAttribute("userid");
		System.out.println("userid :"+userid);
		response.setCharacterEncoding("utf-8");
		String result = StudentDao.listAllBook(userid).toString();
//		System.out.println(result);
		response.getWriter().write(result);
		
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
