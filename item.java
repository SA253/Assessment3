package Localstore;

public class item {
    int id;
	String icode;
	String iname;
	float iprice;
	public item() {
		
	}
	public item(int id,String icode, String iname, float iprice) {
		super();
		this.id=id;
		this.icode = icode;
		this.iname = iname;
		this.iprice = iprice;
	}
	public item(String icode, String iname, float iprice) {
		super();
		
		this.icode = icode;
		this.iname = iname;
		this.iprice = iprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcode() {
		return icode;
	}
	public void setIcode(String icode) {
		this.icode = icode;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public float getIprice() {
		return iprice;
	}
	public void setIprice(float iprice) {
		this.iprice = iprice;
	}
	public String toString() {
		return "id:"+id+"  name:"+iname+"  code:"+this.icode+"   phone:"+iprice;
	}
}
