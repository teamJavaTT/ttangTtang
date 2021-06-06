package auth.model;

public class Category {

	private String ccode;
	private String cname;
	private String maincategory;
	private String middlecategory;

	public Category(String ccode, String cname, String maincategory, String middlecategory) {
		this.ccode = ccode;
		this.cname = cname;
		this.maincategory = maincategory;
		this.middlecategory = middlecategory;
	}

	public String getCcode() {
		return ccode;
	}

	public String getCname() {
		return cname;
	}

	public String getMaincategory() {
		return maincategory;
	}

	public String getMiddlecategory() {
		return middlecategory;
	}

}
