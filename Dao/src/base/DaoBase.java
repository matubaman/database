package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import dao.Dao;

public class DaoBase implements Dao{

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
    
}