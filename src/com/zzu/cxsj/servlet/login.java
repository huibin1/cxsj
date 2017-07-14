package com.zzu.cxsj.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zzu.cxsj.dbutils.*;
import com.zzu.cxsj.Dao.StudentDao;
import com.zzu.cxsj.dbBean.*;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 3192589044176123852L;
	
	static SessionFactory sessionfactory;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证用户信息，，并将userid写入request的session中
		String userid = request.getParameter("userid");
		String usertype = request.getParameter("usertype");
		String password = request.getParameter("password");
		request.getSession().setAttribute("usertype", usertype);//student/tesacher
		request.getSession().setAttribute("userid", userid);
		request.getSession().setAttribute("username", "wlk");
		System.out.println(request.getSession().getAttribute("userid"));
		System.out.println(userid);
		System.out.println(password);
		Session session = DBConnection.getFactory().openSession();
		String hql = "from DBStudent where userid=:userid and password=:password";
		Query<DBStudent> query = session.createQuery(hql);
		query.setString("userid", userid);
		query.setString("password", password);
		
		List<DBStudent> stus = query.list();
		for(DBStudent stu:stus){
			System.out.println("************");
			System.out.println(stu.getUserid());
			System.out.println(stu.getName());
			System.out.println(stu.getYuanxi());
			System.out.println(stu.getZhuanye());
			System.out.println(stu.getClass());
		}
		if(usertype.equals("student"))
			response.sendRedirect("./welcomestu.html");
		else if(usertype.equals("teacher"))
			request.getRequestDispatcher("./welcomeTeacher.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
