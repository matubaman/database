package DaoImplment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DaoBase;
import base.Vobase;
import vo.Blog;
import vo.Message;

public class MessageDao extends DaoBase {

	public MessageDao() throws Exception {
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
        String selectSql = " select * from t_message ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Message newvo = new Message();        //ʵ��������
        	newvo.setId(rs.getInt("id"));
        	newvo.setInfos(rs.getString("infos"));
        	newvo.setReply(rs.getString("reply"));
        	newvo.setState(rs.getString("state"));
        	newvo.setUid(rs.getInt("uid"));
        	
            list.add(newvo);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���
	}
	
	public List<Message> getMessage() throws SQLException
    {
    	List list=getVos();
    	List list2=(List<Message>)list;
    	return list2;
    }

	@Override
	public boolean add(Vobase vo) throws Exception {
		System.out.println("add");
		Message newvo=(Message)vo;
        //������ݿ��в�������ͬid��Ա������ɲ�������
        String temp="select * from t_message where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setLong(1, newvo.getId());/*
        this.state.setString(2, user.getTel());
        this.state.setString(3, user.getName());*/
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
        
        
        if( newvo != null ) {
            
            //��������sql���
            String insertSql = " insert into t_message(id,infos,state,reply,uid) "
                    + " values(?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getInfos());
            this.state.setString(3, newvo.getState());
            this.state.setString(4, newvo.getState());
            this.state.setInt(5, newvo.getUid());
            
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        
        return false;        //�����жϱ�־
	}

	@Override
	public boolean remove(int id) throws Exception {
		return remove(id,"t_message");
	}
	
	public Message search(int id) throws Exception {
		Message newvo = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id!=0 ) {        
            
            //�������ڲ�ѯ��sql���
            rs=search(id,"t_message");
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
            	newvo = new Message();        //ʵ����Worker�����
            	newvo.setId(rs.getInt("id"));
            	newvo.setInfos(rs.getString("infos"));
            	newvo.setReply(rs.getString("reply"));
            	newvo.setState(rs.getString("state"));
            	newvo.setUid(rs.getInt("uid"));
            
            this.state.close();        //�ر�����
            }
        }
        return newvo;
    }

	@Override
	public boolean update(Vobase vo) throws Exception {
		boolean flag = false;        //����Ƿ���³ɹ�
        Message newvo=(Message)vo;
        if( newvo != null ) {
            
            //����������
            String updateSql = " update t_message set id=?,infos=?,state=?,reply=?,uid=? where id=?";
            
            //ת���������ͣ�util.Date -> sql.Date
            /*Date date = user.getBirth();
            java.sql.Date d = new java.sql.Date(date.getTime());*/

            this.state = this.con.prepareStatement(updateSql);

            this.state.setInt(1, newvo.getId());
            this.state.setString(2, newvo.getInfos());
            this.state.setString(3, newvo.getState());
            this.state.setString(4, newvo.getReply());
            this.state.setInt(5, newvo.getUid());
            this.state.setInt(6, newvo.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
	}

}
