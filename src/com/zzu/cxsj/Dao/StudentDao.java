package com.zzu.cxsj.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zzu.cxsj.dbBean.*;
import com.zzu.cxsj.dbutils.DBConnection;

public class StudentDao {
	DBStudent student;
	
	public StudentDao(){}
	
	public StudentDao(DBStudent student) {
		this.student = student;
	}
	
	public DBBook listBooksWith(String courseid){
		return null;
	}
	public void makeOrder(List<DBBook> booklist){
	}
	public static Object listAllBook(String userid){
		String hql1 = "select courseid,teacherid "
				+ "from DBXuanke "
				+ "where stuid=:stuid";
		List<Map<String,String>> courseAndTeacher=new ArrayList<Map<String,String>>();
		Session session = DBConnection.getFactory().openSession();
		Query<Object[]> query = session.createQuery(hql1);
		query.setString("stuid", userid);
		List<Object[]> xuankes = query.list();//找出此学生的选修的所有课程
		for(Object[] a:xuankes){
			HashMap pair = new HashMap<>();
			pair.put("courseid", a[0]);
			pair.put("teacherid", a[1]);
			System.out.println(pair.toString());
			courseAndTeacher.add(pair);
		}
		
		
		Iterator<Map<String, String>> it = courseAndTeacher.iterator();
		String hql2 ="select bookisbns "
				+ "from DBXuanshu "
				+ "where courseid=:courseid and teacherid=:teacherid";
		String courseid,teacherid;
		Map<String, String> tempmap;
		Session session2 =null;
		Query<Object> query2 = null;
		List<Object> obj ;
		List<String> isbns = new ArrayList<String>();
		while(it.hasNext()){
			tempmap = it.next();
			courseid = tempmap.get("courseid");
			teacherid = tempmap.get("teacherid");
			session2 = DBConnection.getFactory().openSession();
			query2 = session2.createQuery(hql2);
			query2.setString("courseid", courseid);
			query2.setString("teacherid", teacherid);
			obj = query2.list();//根据每个课程，找出此课程，加到List中
//			System.out.println(obj.size());
			for(Object o:obj){
				JSONObject jsobj = JSONObject.parseObject(o.toString());
//				System.out.println(jsobj);
				JSONArray arr = jsobj.getJSONArray("isbns");
				for (int i = 0; i < arr.size(); i++) {
					isbns.add(arr.getString(i));
				}
			}
		}
		String hql3 = "from DBBook where isbn=:isbn";
		JSONObject result= new JSONObject();
		HashSet<String> bookset = new HashSet<String>();
		JSONArray jsonarry = new JSONArray();
		for(String isbn:isbns){//根据查询的图书isbn，，找出相应的图书信息
			Session session3 = DBConnection.getFactory().openSession();
			Query query3 = session3.createQuery(hql3);
			query3.setString("isbn", isbn);
			List<DBBook> books = query3.list();
			for(DBBook b:books){
//				System.out.println("获取到的图书信息:"+b.toString());
				if(!bookset.contains(b.getIsbn())){
					jsonarry.add(b);//加入jsonarray中
					bookset.add(b.getIsbn());
				}
			}
		}
		result.put("books", jsonarry);//放到resutl中
		
		return result;//返回
	}

}











