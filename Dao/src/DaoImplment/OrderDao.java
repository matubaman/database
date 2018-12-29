package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Order;

public class OrderDao extends DaoBase {
	public OrderDao() throws Exception {
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
        String selectSql = " select * from t_order ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Order newvo = new Order();        //ʵ��������
        	newvo.setId(rs.getInt("id"));
        	newvo.setInfos(rs.getString("infos"));
        	newvo.setAddress(rs.getString("address"));
        	newvo.setCity(rs.getString("city"));
        	newvo.setItid(rs.getInt("itid"));
        	newvo.setPaytype(rs.getString("paytype"));
        	newvo.setPostno(rs.getString("postno"));
        	newvo.setPrice(rs.getDouble("price"));
        	newvo.setProvince(rs.getString("province"));
        	newvo.setState(rs.getString("state"));
        	newvo.setTel(rs.getString("tel"));
        	newvo.setUid(rs.getInt("uid"));
        	newvo.setUrls(rs.getString("urls"));
        	newvo.setUsername(rs.getString("username"));
        	
            list.add(newvo);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���
	}
	
	public List<Order> getOrder() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Order>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Order newvo=(Order)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_order where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //��������sql���
            String insertSql = " insert into t_order(id,uid,username,"
            		+ "itid,price,address,state,postno,tel,paytype,infos,"
            		+ "urls,province,city)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
           
            this.state.setInt(2, newvo.getUid());
            this.state.setString(3, newvo.getUsername());
            this.state.setInt(4, newvo.getItid());
            this.state.setDouble(5, newvo.getPrice());
            this.state.setString(6, newvo.getAddress());
            this.state.setString(7, newvo.getState());
            this.state.setString(8, newvo.getPostno());
            this.state.setString(9, newvo.getTel());
            this.state.setString(10, newvo.getPaytype());
            this.state.setString(11, newvo.getInfos());
            this.state.setString(12, newvo.getUrls());
            this.state.setString(13, newvo.getProvince());
            this.state.setString(14, newvo.getCity());
            
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_order");
	}
	
	public Order search(int id) throws Exception {
		Order newvo = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id!=0 ) {        
            
            //�������ڲ�ѯ��sql���
            rs=search(id,"t_order");
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
            	newvo = new Order();        //ʵ����Worker�����
            	newvo.setId(rs.getInt("id"));
            	newvo.setInfos(rs.getString("infos"));
            	newvo.setAddress(rs.getString("address"));
            	newvo.setCity(rs.getString("city"));
            	newvo.setItid(rs.getInt("itid"));
            	newvo.setPaytype(rs.getString("paytype"));
            	newvo.setPostno(rs.getString("postno"));
            	newvo.setPrice(rs.getDouble("price"));
            	newvo.setProvince(rs.getString("province"));
            	newvo.setState(rs.getString("state"));
            	newvo.setTel(rs.getString("tel"));
            	newvo.setUid(rs.getInt("uid"));
            	newvo.setUrls(rs.getString("urls"));
            	newvo.setUsername(rs.getString("username"));
            
            this.state.close();        //�ر�����
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //����Ƿ���³ɹ�
        Order newvo=(Order)vo;
        if( newvo != null ) {
            
            //����������
            String updateSql = " update t_order set id=?,uid=?,username=?,itid=?,"
            		+ "price=?,address=?,state=?,postno=?,tel=?,paytype=?,infos=?,"
            		+ "urls=?,province=?,city=?"
            		+ " where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setInt(2, newvo.getUid());
            this.state.setString(3, newvo.getUsername());
            this.state.setInt(4, newvo.getItid());
            this.state.setDouble(5, newvo.getPrice());
            this.state.setString(6, newvo.getAddress());
            this.state.setString(7,newvo.getState());
            this.state.setString(8,newvo.getPostno());
            this.state.setString(9,newvo.getTel());
            this.state.setString(10, newvo.getPaytype());
            this.state.setString(11, newvo.getInfos());
            this.state.setString(12, newvo.getUrls());
            this.state.setString(13, newvo.getProvince());
            this.state.setString(14, newvo.getCity());
            this.state.setInt(15, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
	}
}
