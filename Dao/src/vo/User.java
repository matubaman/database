package vo;              //vo��Ϊ(Value Object ֵ���� )

public class User {
	int id;
    String no;        //�˺�
    String pwd;         
    String name;    
    String email;      
    String tel;
    int age;
    String birth;
    String role;      //Ȩ��
    String address;

    //���幹�췽��
    public User() {
        
    }
    
    public User(String no,String name,String email,String birth,String pwd,String tel,String role,int age,String address) {
        
        this.no = no;
        this.pwd=pwd;
        this.name=name;
        this.email=email;
        this.tel=tel;
        this.age=age;
        this.birth=birth;
        this.role=role;
        this.address=address;
    }
    
    //��дtoString����
/*    @Override
    public String toString() {
        return "Worker [workerId=" + workerId + ", workerName=" + workerName
                + ", workerSex=" + workerSex + ", workerPartment="
                + workerPartment + ", workerBirthday=" + workerBirthday
                + ", workerBeginDate=" + "]";
    }*/
    
    
    
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
    
}