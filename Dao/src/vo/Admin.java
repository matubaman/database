package vo;              //vo��Ϊ(Value Object ֵ���� )

public class Admin {
	private int id;
    private String no;        //�˺�
    private String pwd;
    private String  name;
    private String email;
    private String tel;

    //���幹�췽��
    public Admin() {
        
    }
    
    public Admin(int id,String no,String name,String email,String pwd,String tel) {
        this.id=id;
        this.no = no;
        this.pwd=pwd;
        this.name=name;
        this.email=email;
        this.tel=tel;
    }
    //����setter()��getter()����
    
	public String getNo() {
		return no;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


    
}