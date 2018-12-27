package DaoImplment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dao.DaoBase;
import vo.User;

public class UserDao {
	private static DaoBase daobase;
	private Connection con;
    private PreparedStatement state;    //�������ݿ��������
	
    public UserDao()
    {
    	try {
			daobase=new DaoBase();    	
			con=daobase.getConnection();
			state=null;
		} catch (Exception e) {
			System.out.println("���ݿ����ӳ���������");
			e.printStackTrace();
		}
    }
    
    //��������û�
    public List<User> getUsers() throws Exception {
        
        //�������ж���
        List<User> list = new ArrayList<User>();
        //���淵�صĵĲ�ѯ���
        ResultSet rs = null;
        //�������ڲ�ѯ��sql���
        String selectSql = " select * from t_user ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	User user = new User();        //ʵ��������
            
            user.setName(rs.getString("name"));
            user.setPwd(rs.getString("pwd"));
            user.setNo(rs.getString("no"));
            user.setEmail(rs.getString("email"));
            user.setTel(rs.getString("tel"));
            user.setAge(rs.getInt("age"));
            user.setAddress(rs.getString("address"));
            user.setBirth(rs.getString("birth"));
            user.setRole(rs.getString("role"));
            
            list.add(user);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���

    }
    
    //��
	public boolean add(User user) throws Exception{
		System.out.println("add");
		
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_user where no=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setString(1, user.getNo());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( user != null ) {
            
            //��������sql���
            String insertSql = " insert into t_user(no,pwd,name,email,tel,age,birth,role,address) "
                    + " values(?,?,?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setString(1, user.getNo());
            this.state.setString(2, user.getPwd());
            this.state.setString(3, user.getName());
            this.state.setString(4, user.getEmail());
            this.state.setString(5, user.getTel());
            this.state.setInt(6, user.getAge());
            this.state.setString(7, user.getBirth());
            this.state.setString(8, user.getRole());
            this.state.setString(9, user.getAddress());
            
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}

	//ɾ
	public boolean remove(String no) throws Exception {
     
        boolean flag = false;    //�ж��Ƿ�ɾ���ɹ�
        //��������ɾ����sql���
        String removeSql = " delete from t_user where no = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setString(1, no); 
        if( this.state.executeUpdate() > 0 ) {        //ɾ���ɹ�
            flag = true;
        }
        this.state.close();        //�ر�����
        return flag;
    }

	//��
	public User search(String no) throws Exception {
        User user = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( no != null || "".equals(no) ) {        
            
            //�������ڲ�ѯ��sql���
            String selectSql = "select * from t_user where no=? ";
            
            this.state = this.con.prepareStatement(selectSql);
            this.state.setString(1, no);
            rs = this.state.executeQuery();
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
                user = new User();        //ʵ����Worker�����
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                user.setNo(rs.getString("no"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                user.setAge(rs.getInt("age"));
                user.setAddress(rs.getString("address"));
                user.setBirth(rs.getString("birth"));
                user.setRole(rs.getString("role"));
                
            }
            
            this.state.close();        //�ر�����
        }
        
        return user;
    }

	//��
    public boolean update(User user) throws Exception {
        boolean flag = false;        //����Ƿ���³ɹ�
        
        if( user != null ) {
            
            //����������
            String updateSql = " update t_user set pwd=?,name=?,email=?,tel=?,age=?,birth=?,role=?,address=? where no=?";
            
            //ת���������ͣ�util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setString(1, user.getPwd());
            this.state.setString(2, user.getName());
            this.state.setString(3, user.getEmail());
            this.state.setString(4, user.getTel());
            this.state.setInt(5, user.getAge());
            this.state.setString(6, user.getBirth());
            this.state.setString(7, user.getRole());
            this.state.setString(8, user.getAddress());
            this.state.setString(9, user.getNo());    
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
    }
}