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
import vo.Blog;
import vo.User;

public class BlogDao extends DaoBase {
	
    public BlogDao() throws Exception
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
        String selectSql = " select * from t_blog ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Blog blog = new Blog();        //ʵ��������
            blog.setId(rs.getInt("id"));
        	blog.setInfos(rs.getString("infos"));
            blog.setItid(rs.getInt("itid"));
            blog.setPicurls(rs.getString("picurls"));
            blog.setTime(rs.getString("time"));
            blog.setTitle(rs.getString("title"));
            blog.setType(rs.getString("type"));
            blog.setZhaiyao(rs.getString("zhaiyao"));
            
            list.add(blog);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���

    }
    
    public List<Blog> getBlog() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Blog>)list;
    	return list2;
    }
    //��
	public boolean add(Vobase vo) throws Exception{
		System.out.println("add");
		Blog blog=(Blog)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_blog where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, blog.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( blog != null ) {
            
            //��������sql���
            String insertSql = " insert into t_blog(id,title,infos,time,itid,type,zhaiyao,picurls) "
                    + " values(?,?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, blog.getId());
            this.state.setString(2, blog.getTitle());
            this.state.setString(3, blog.getInfos());
            this.state.setString(4, blog.getTime());
            this.state.setInt(5, blog.getItid());
            this.state.setString(6, blog.getType());
            this.state.setString(7, blog.getZhaiyao());
            this.state.setString(8, blog.getPicurls());
            
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}


	
	
	//ɾ
	public boolean remove(int id) throws Exception {
     
        return remove(id,"t_blog");
    }

	//��
	public Blog search(int id) throws Exception {
		Blog blog = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id!=0 ) {        
            
            //�������ڲ�ѯ��sql���
            rs=search(id,"t_blog");
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
            	blog = new Blog();        //ʵ����Worker�����
                blog.setId(rs.getInt("id"));
                blog.setInfos(rs.getString("infos"));
                blog.setItid(rs.getInt("itid"));
                blog.setPicurls(rs.getString("picurls"));
                blog.setTime(rs.getString("time"));
                blog.setTitle(rs.getString("title"));
                blog.setType(rs.getString("type"));
                blog.setZhaiyao(rs.getString("zhaiyao"));
            }
            
            this.state.close();        //�ر�����
        }
        
        return blog;
    }

	//��
    public boolean update(Vobase vo) throws Exception {
        boolean flag = false;        //����Ƿ���³ɹ�
        Blog blog=(Blog)vo;
        if( blog != null ) {
            
            //����������
            String updateSql = " update t_blog set id=?,title=?,infos=?,time=?,itid=?,type=?,zhaiyao=?,picurls=? where id=?";
            
            //ת���������ͣ�util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, blog.getId());
            this.state.setString(2, blog.getTitle());
            this.state.setString(3, blog.getInfos());
            this.state.setString(4, blog.getTime());
            this.state.setInt(5, blog.getItid());
            this.state.setString(6, blog.getType());
            this.state.setString(7, blog.getZhaiyao());
            this.state.setString(8, blog.getPicurls());
            this.state.setInt(9, blog.getId());    
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
    }





	

	
}
