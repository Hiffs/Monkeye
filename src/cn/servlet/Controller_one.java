package cn.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.User;
import cn.dao.AvatarDao;
import cn.dao.UserDao;
import cn.dao.impl.AvatarDaoImpl;
import cn.dao.impl.UserDaoImpl;


@WebServlet("*.fo")
public class Controller_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao ud=new UserDaoImpl();
	AvatarDao ad=new AvatarDaoImpl();
    public Controller_one() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		String methodNmae=path.substring(1,path.length()-3);
		try
		{
			Method method=getClass().getDeclaredMethod(methodNmae, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this,request,response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response)
	{
		
		User user=new User();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		user=ud.login(name, password);
		try
		{
			if(user.getName()!=null)
			{
				String aPath=ad.getaPathById(user.getPortrait_id());
				request.getSession().setAttribute("aPath",aPath);
				request.getSession().setAttribute("user",user);
				request.getRequestDispatcher("index.do").forward(request, response);
			}
			else
			{
				String ms="账户名或密码错误，请重新输入";
				request.setAttribute("ms",ms);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void register(HttpServletRequest request, HttpServletResponse response)
	{
		User user=new User();
		String name=request.getParameter("form_feild1");
		String password=request.getParameter("form_feild2");
		String phone=request.getParameter("form_feild4");
		boolean flag1=ud.checkUsername(name);
		boolean flag2=ud.checkPhone(phone);
		if(flag1)
		{
			String rep="该用户名已经被注册，请重新输入";
			request.setAttribute("rep1",rep);
			try
			{
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else if(flag2)
		{
			String rep="该电话号码已经被使用";
			request.setAttribute("rep2",rep);
			try
			{
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(!flag1 && !flag2)
		{
			user.setName(name);
			user.setPassword(password);
			user.setPhone(phone);
			boolean flag=ud.doUser(user);
			try
			{
				if(flag)
				{
					String losu="注册成功，立即登录！";
					request.setAttribute("losu",losu);
					request.getRequestDispatcher("register.jsp").forward(request, response);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	protected void exit(HttpServletRequest request, HttpServletResponse response)
	{
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("aPath");
		try
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
