package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Shopcar;

public class ShopcarDao extends DaoBase {

	public ShopcarDao() throws Exception {
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
        String selectSql = " select * from t_shopcar ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Shopcar newvo = new Shopcar();        //ʵ��������
        	newvo.setId(rs.getInt("id"));
        	newvo.setItid(rs.getInt("itid"));
        	newvo.setPrice(rs.getDouble("price"));
        	newvo.setState(rs.getString("state"));
        	newvo.setUid(rs.getInt("uid"));
        	newvo.setUrls(rs.getString("urls"));
        	newvo.setName(rs.getString("name"));
        	newvo.setNum(rs.getInt("num"));
        	
            list.add(newvo);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���
	}
	
	public List<Shopcar> getShopcar() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Shopcar>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Shopcar newvo=(Shopcar)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_shopcar where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //��������sql���
            String insertSql = " insert into t_shopcar("
            		+ "id,urls,name,num,price,uid,itid,state)"
                    + " values(?,?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getUrls());
            this.state.setString(3, newvo.getName());
            this.state.setInt(4, newvo.getNum());
            this.state.setDouble(5,newvo.getPrice());
            this.state.setInt(6, newvo.getUid());
            this.state.setInt(7, newvo.getItid());
            this.state.setString(8, newvo.getState());
            
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_shopcar");
	}
	
	public Shopcar search(int id) throws Exception {
		Shopcar newvo = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id!=0 ) {        
            
            //�������ڲ�ѯ��sql���
            rs=search(id,"t_shopcar");
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
            	newvo = new Shopcar();        //ʵ����Worker�����
            	newvo.setId(rs.getInt("id"));
            	newvo.setItid(rs.getInt("itid"));
            	newvo.setPrice(rs.getDouble("price"));
            	newvo.setState(rs.getString("state"));
            	newvo.setUid(rs.getInt("uid"));
            	newvo.setUrls(rs.getString("urls"));
            	newvo.setName(rs.getString("name"));
            	newvo.setNum(rs.getInt("num"));
            
            this.state.close();        //�ر�����
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //����Ƿ���³ɹ�
        Shopcar newvo=(Shopcar)vo;
        if( newvo != null ) {
            
            //����������
            String updateSql = " update t_shopcar set id=?,urls=?,name=?,num=?,"
            		+ "price=?,uid=?,itid=?,state=?"
            		+ " where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getUrls());
            this.state.setString(3, newvo.getName());
            this.state.setInt(4, newvo.getNum());
            this.state.setDouble(5,newvo.getPrice());
            this.state.setInt(6, newvo.getUid());
            this.state.setInt(7, newvo.getItid());
            this.state.setString(8, newvo.getState());
            this.state.setInt(9, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
	}

}
