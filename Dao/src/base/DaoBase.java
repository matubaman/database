package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.Dao;
import vo.User;

public abstract class DaoBase implements Dao{

    //�������ݿ�������
    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    //�������ݿ�URL
    private static final String DBURL = "jdbc:mysql://localhost:3306/test";
    //�������ݿ������û���
    private static final String DBUSER = "root";
    //�������ݿ�����ָ��
    private static final String DBPASS = "123456";
    
  //�������ݿ����Ӷ���
    protected Connection con= null;
    protected PreparedStatement state;    //�������ݿ��������
    
    //�������ݿ����Ӷ���
    //Connection con = null;
    
    //���幹�췽������ʵ�������ݿ����Ӷ���
    public DaoBase() throws Exception {
        
        try {
            
            Class.forName(DBDRIVER);
            this.con = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        }catch(Exception e) {
            
            throw e;
        }
    }
      
    //ȡ�����ݿ����Ӷ���
    public Connection getConnection() throws Exception {
        
        return this.con;
    }
    
    //�ر����ݿ�����
    public void close() throws Exception{
        
        if( this.con != null ) {
            
            try {
                
                con.close();
            }catch(Exception e) {
                
                throw e;
            }
        }
    }
    
    
public abstract List<Vobase> getVos() ;
    //��
public abstract boolean add(Vobase vo);

	//ɾ
public boolean remove(int id,String table,String idname) throws Exception {
     
        boolean flag = false;    //�ж��Ƿ�ɾ���ɹ�
        //��������ɾ����sql���
        String removeSql = " delete from "+table+" where "+idname+" = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setLong(1, id); 
        if( this.state.executeUpdate() > 0 ) {        //ɾ���ɹ�
            flag = true;
        }
        this.state.close();        //�ر�����
        return flag;
    }

public boolean remove(int id,String table) throws Exception {
 
    return remove(id,table,"id");
}

public abstract boolean remove(int id) ;

	//��
public ResultSet search(int id,String table,String idname) throws Exception {
        User user = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id !=0 ) {    
            //�������ڲ�ѯ��sql���
            String selectSql = "select * from "+table+" where "+idname+"=? ";
            this.state = this.con.prepareStatement(selectSql);
            this.state.setLong(1, id);
            rs = this.state.executeQuery();
            //��ѯ�ɹ�
        }
        return rs;
    }
	
public ResultSet search(int id,String table) throws Exception {
		return search(id,table,"id");
	}
	
public abstract ResultSet search(int id);

	//��
   public abstract boolean update(Vobase vo) throws Exception ;
    
    
}