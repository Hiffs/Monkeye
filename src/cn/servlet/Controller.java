package cn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.framework.Action;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name="Controller",urlPatterns="*.do",loadOnStartup=1)
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Action ac = getAction(request);
		String str = ac.execute(request, response);
		request.getRequestDispatcher(str).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	public Action getAction(HttpServletRequest request){
		Action ac = null;
		String path = request.getServletPath();
		path = path.substring(path.lastIndexOf("/")+1, path.indexOf("."));
		path = path.substring(0,1).toUpperCase()+path.substring(1);
		String str = "cn.action."+path+"Action";
		try
		{
			ac = (Action) Class.forName(str).newInstance();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return ac;
	}

}
