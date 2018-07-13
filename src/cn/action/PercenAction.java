package cn.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bean.User;
import cn.dao.UserDao;
import cn.dao.impl.UserDaoImpl;
import cn.framework.Action;

public class PercenAction implements Action
{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	{
		UserDao ud=new UserDaoImpl();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String se1=request.getParameter("se1");
		String se2=request.getParameter("se2");
		String se3=request.getParameter("se3");
		String birth=se1+"-"+se2+"-"+se3;
		String ls=request.getParameter("ls");
		String se4=request.getParameter("se4");
		String se5=request.getParameter("se5");
		String pro=se4+":"+se5;
		String[] xq=new String[15];
		xq=request.getParameterValues("xq");
		String interests="";
		if(xq!=null)
		{
			for(int i=0;i<xq.length;i++)
			{
				interests=interests+xq[i]+" ";
			}
		}
		System.out.println(interests);
		String intr=request.getParameter("introduce");
		System.out.println("name:"+name+"  "+"gender:"+gender+"  "+"birth:"+birth+"  "+"ls:"+ls+"  "+"pro:"+pro+"  "+"intr:"+intr);
		User user=new User();
		user.setName(name);
		user.setSex(gender);
		user.setBirth(birth);
		user.setMarriage(ls);
		user.setJob(pro);
		user.setInterests(interests);
		user.setIntroduce(intr);
		user.setId(id);
		boolean flag=ud.update(user);
		if(flag)
		{
			String upsu="ÐÞ¸Ä³É¹¦";
			request.setAttribute("upsu",upsu);
			request.getSession().setAttribute("user",user);
		}
		return "per_cen.jsp";
	}

}
