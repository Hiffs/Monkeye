package cn.bean;

public class Film {
	private int id;
	private String name;
	private String year;
	private String area;
	private String time;
	private String filmtime_place;
	private int language_id;
	private String content;
	private int cover_id;
	private String score;
	public Film() {
		super();
	}
	public int getCover_id() {
		return cover_id;
	}

	public void setCover_id(int cover_id) {
		this.cover_id = cover_id;
	}

	public Film(int id, String name, String year, String area, String time, String filmtime_place, int language_id,
			String content, int cover_id, String score)
	{
		super();
		this.id = id;
		this.name = name;
		this.year = year;
		this.area = area;
		this.time = time;
		this.filmtime_place = filmtime_place;
		this.language_id = language_id;
		this.content = content;
		this.cover_id = cover_id;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getFilmtime_place() {
		return filmtime_place;
	}
	public void setFilmtime_place(String filmtime_place) {
		this.filmtime_place = filmtime_place;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getScore()
	{
		return score;
	}
	public void setScore(String score)
	{
		this.score = score;
	}
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Film)) {
            return false;
        }
        Film b = (Film)obj;
        if(this.id == b.id) {
            return true;
        }
        return false;
	}
	
	@Override
    public int hashCode() {
        return id;
    }
}
