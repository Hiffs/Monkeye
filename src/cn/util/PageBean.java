package cn.util;

public class PageBean
{
	private int count; //总记录数
	private int pages; //总页数(计算得出)
	private int pageIndex; //当前页
	private int pageSize; //每页记录数
	private int startIndex; //开始索引
	private int start; //开始
	private int end;  //结束
	public int getStart()
	{
		return start;
	}
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getEnd()
	{
		return end;
	}
	public void setEnd(int end)
	{
		this.end = end;
	}
	public PageBean()
	{
		super();
	}
	public PageBean(int count, int pages, int pageIndex, int pageSize)
	{
		super();
		this.count = count;
		this.setPages(pages);
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}
	public PageBean(int count, int pageIndex, int pageSize)
	{
		super();
		this.count = count;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		pages = count%pageSize == 0?count/pageSize : count/pageSize+1;
		this.setStartIndex((pageIndex - 1) * pageSize);
		this.start = 1;
		this.end = 5;
		if(pages <= 5)
		{
			this.end = this.pages;
		}
		else
		{
			this.start = pageIndex - 2;
			this.end = pageIndex + 2;
			if(start <= 0)
			{
				this.start = 1;
				this.end = 5;
			}
			if(end > this.pages)
			{
				this.end = pages;
				this.start = end - 4;
			}
		}
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
	public int getPageIndex()
	{
		return pageIndex;
	}
	public void setPageIndex(int pageIndex)
	{
		this.pageIndex = pageIndex;
	}
	public int getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	public int getPages()
	{
		return pages;
	}
	public void setPages(int pages)
	{
		this.pages = pages;
	}
	public int getStartIndex()
	{
		return startIndex;
	}
	public void setStartIndex(int startIndex)
	{
		this.startIndex = startIndex;
	}
	
}
