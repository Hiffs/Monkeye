package cn.dbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Base {
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	//连接数据库
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/monkeye?setChracter?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库的连接
	public void getClose(ResultSet rs,PreparedStatement pst,Connection conn) {
		try {
			if(rs!=null)rs.close();
			if(pst!=null)pst.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//数据库的增删改方法集合
	public boolean getUpdate(String sql,List<Object> list) {
		try {
			pst=getConnection().prepareStatement(sql);
			if(list.size()>0) {
				for(int i=0;i<list.size();i++) {
					pst.setObject(i+1, list.get(i));
				}
			}
			int num=pst.executeUpdate();
			if(num>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			getClose(rs, pst, conn);
		}
		return false;
	}
	
	//数据库的查询方式集合
	public <T>List<T> getQuery(String sql,List<Object> list,Class clazz){
		List<T> li=new ArrayList<T>();
		try {
			pst=getConnection().prepareStatement(sql);
			if(list.size()>0) {
				for(int i=0;i<list.size();i++) {
					pst.setObject(i+1, list.get(i));
				}
			}
			rs=pst.executeQuery();
			ResultSetMetaData rsm=rs.getMetaData();
			int column=rsm.getColumnCount();
			while(rs.next()) {
				Object obj=clazz.newInstance();
				for(int i=1;i<=column;i++) {
					String name=rsm.getColumnName(i);
					Object o=rs.getObject(i);
					Field f=clazz.getDeclaredField(name);
					f.setAccessible(true);
					f.set(obj, o);
				}
				li.add((T)obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			getClose(rs, pst, conn);
		}
		return li;
	}
}
