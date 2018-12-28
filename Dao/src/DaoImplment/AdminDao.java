package DaoImplment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Admin;

public class AdminDao extends DaoBase{
//	private static DaoBase daobase;
	
	
    public AdminDao() throws Exception
    {
    	super();
    }
    
    //��������û�
    public List<Vobase> getVos() throws SQLException {
        
        //�������ж���
        List<Vobase> list = new ArrayList<Vobase>();
        //���淵�صĵĲ�ѯ���
        ResultSet rs = null;
        //�������ڲ�ѯ��sql���
        String selectSql = " select * from t_admin ";
        
       
			this.state = this.con.prepareStatement(selectSql);
			 rs = this.state.executeQuery();
		        
		        while( rs.next() ) {
		        	Admin admin = new Admin();        //ʵ��������
		            
		            admin.setName(rs.getString("name"));
		            admin.setPwd(rs.getString("pwd"));
		            admin.setNo(rs.getString("no"));
		            admin.setEmail(rs.getString("email"));
		            admin.setTel(rs.getString("tel"));
		            
		            list.add(admin);            //���뼯��
		        }
		        
		        this.state.close();        //�ر�����
		
       
        
        return list;            //���ؼ���

    }
    
    //��
	public boolean add(Vobase vo) throws SQLException {
		System.out.println("add");
		Admin admin=(Admin)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_admin where no=? ";
       
			this.state=this.con.prepareStatement(temp);
			this.state.setString(1, admin.getNo());
	        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
	        if(rs.next())
	        	return false;
	        
	        
	        if( admin != null ) {
	            
	            //��������sql���
	            String insertSql = " insert into t_admin(no,pwd,name,email,tel) "
	                    + " values(?,?,?,?,?) ";
	            
	            //ȡ�ò������ݿ�Ķ���
	            this.state = this.con.prepareStatement(insertSql);
	            this.state.setString(1, admin.getNo());
	            this.state.setString(2, admin.getPwd());
	            this.state.setString(3, admin.getName());
	            this.state.setString(4, admin.getEmail());
	            this.state.setString(5, admin.getTel());
	            
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
        String removeSql = " delete from t_admin where no = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setString(1, no); 
        if( this.state.executeUpdate() > 0 ) {        //ɾ���ɹ�
            flag = true;
        }
        this.state.close();        //�ر�����
        return flag;
    }

	//��
	public Admin search(String no) throws Exception {
		Admin admin = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( no != null || "".equals(no) ) {        
            
            //�������ڲ�ѯ��sql���
            String selectSql = "select * from t_admin where no=? ";
            
            this.state = this.con.prepareStatement(selectSql);
            this.state.setString(1, no);
            rs = this.state.executeQuery();
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
                admin = new Admin();        //ʵ��������
                admin.setName(rs.getString("name"));
                admin.setPwd(rs.getString("pwd"));
                admin.setEmail(rs.getString("email"));
                admin.setTel(rs.getString("tel"));
                admin.setId(rs.getInt("id"));
            }
            
            this.state.close();        //�ر�����
        }
        
        return admin;
    }

	//��
    public boolean update(Vobase vo) throws SQLException {
        boolean flag = false;        //����Ƿ���³ɹ�
        Admin admin=(Admin)vo;
        if( admin != null ) {
            
            //����������
            String updateSql = " update t_admin set pwd=?,name=?,email=?,tel=? where no=?";
            
            
				this.state = this.con.prepareStatement(updateSql);
				this.state.setString(1, admin.getPwd());
	            this.state.setString(2, admin.getName());
	            this.state.setString(3, admin.getEmail());
	            this.state.setString(4, admin.getTel());
	            this.state.setString(5, admin.getNo());    
	            
	            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
	                flag = true;
	            }
	            this.state.close();            //�ر�����
			

            
        }
        return flag;
    }

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		
		
			return remove(id,"t_admin");
		
		
	}

//	@Override
//	public ResultSet search(int id) throws Exception {
//		
//			return search(id,"t_admin");
//		
//		
//	}
	
}
