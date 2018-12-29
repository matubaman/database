package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Blog;
import vo.Items;

public class ItemsDao extends DaoBase {

	public ItemsDao() throws Exception  {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vobase> getVos() throws SQLException {
		//�������ж���
        List<Vobase> list = new ArrayList<Vobase>();
        //���淵�صĵĲ�ѯ���
        ResultSet rs = null;
        //�������ڲ�ѯ��sql���
        String selectSql = " select * from t_items ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Items item = new Items();        //ʵ��������
        	item.setId(rs.getInt("id"));
        	item.setBrand(rs.getString("brand"));
            item.setInfos(rs.getString("infos"));
            item.setName(rs.getString("name"));
            item.setNo(rs.getString("no"));
            item.setPrice(rs.getDouble("price"));
            item.setType(rs.getString("type"));
            item.setUrls(rs.getString("urls"));
        	item.setSells(rs.getInt("sells"));
        	item.setCategory(rs.getString("category"));
            
            list.add(item);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���
	}
	
	public List<Items> getItems() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Items>)list;
    	return list2;
    }
	
	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Items item=(Items)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_items where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, item.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( item != null ) {
            
            //��������sql���
            String insertSql = " insert into t_items(name,urls,type,price,infos,brand,no,id,sells,category) "
                    + " values(?,?,?,?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
//            this.state.setInt(1, item.getId());
            this.state.setString(1, item.getName());
            this.state.setString(2, item.getUrls());
            this.state.setString(3, item.getType());
            this.state.setDouble(4, item.getPrice());
            this.state.setString(5, item.getInfos());
            this.state.setString(6, item.getBrand());
            this.state.setString(7, item.getNo());
            this.state.setInt(8, item.getId());
            this.state.setInt(9, item.getSells());
            this.state.setString(10, item.getCategory());
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}

	@Override
	public boolean remove(int id) throws Exception {
		// TODO Auto-generated method stub
		return remove(id,"t_items");
	}

	//��
	public Items search(int id) throws Exception {
		Items blog = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id!=0 ) {        
            
            //�������ڲ�ѯ��sql���
            rs=search(id,"t_items");
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
            	blog = new Items();        //ʵ����Worker�����
                blog.setId(rs.getInt("id"));
                blog.setInfos(rs.getString("infos"));
                blog.setName(rs.getString("name"));
                blog.setType(rs.getString("type"));
                blog.setBrand(rs.getString("brand"));
                blog.setNo(rs.getString("no"));
                blog.setPrice(rs.getDouble("price"));
                blog.setUrls(rs.getString("urls"));
                blog.setSells(rs.getInt("sells"));
                blog.setCategory(rs.getString("category"));
                
            }
            
            this.state.close();        //�ر�����
        }
        
        return blog;
    }
	
	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //����Ƿ���³ɹ�
        Items item=(Items)vo;
        if( item != null ) {
            
            //����������
            String updateSql = " update t_items set id=?,name=?,urls=?,type=?,price=?,infos=?,brand=?,no=?,sells=?,category=? where id=?";
            
            //ת���������ͣ�util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, item.getId());
            this.state.setString(2, item.getName());
            this.state.setString(3, item.getUrls());
            this.state.setString(4, item.getType());
            this.state.setDouble(5, item.getPrice());
            this.state.setString(6, item.getInfos());
            this.state.setString(7, item.getBrand());
            this.state.setString(8, item.getNo());
            
            this.state.setInt(9, item.getSells());
            this.state.setString(10, item.getCategory());
            
            this.state.setInt(11, item.getId());    
            
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
	}

}
