package DaoImplment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dao.DaoBase;
import vo.Pingjia;

public class PingjiaDao extends DaoBase {
	
    public PingjiaDao() throws Exception
    {
    	super();
    }
    
    //���������Ϣ
    public List<Pingjia> getAdmin() throws Exception {
        
        //�������ж���
        List<Pingjia> list = new ArrayList<Pingjia>();
        //���淵�صĵĲ�ѯ���
        ResultSet rs = null;
        //�������ڲ�ѯ��sql���
        String selectSql = " select * from t_pingjia ";
        
        this.state = this.con.prepareStatement(selectSql);
        rs = this.state.executeQuery();
        
        while( rs.next() ) {
        	Pingjia pingjia = new Pingjia();        //ʵ��������
            
        	pingjia.setInfos(rs.getString("infos"));
        	pingjia.setId(rs.getInt("id"));
        	pingjia.setName(rs.getString("name"));
            pingjia.setGrade(rs.getInt("grade"));
            pingjia.setAddtime(rs.getString("addtime"));
            pingjia.setUid(rs.getInt("uid"));
            pingjia.setItid(rs.getInt("itid"));
            pingjia.setType(rs.getString("type"));
        	
            list.add(pingjia);            //���뼯��
        }
        
        this.state.close();        //�ر�����
        
        return list;            //���ؼ���

    }
    
    //������������
	public boolean add(Pingjia pingjia) throws Exception{
		System.out.println("add");
		
        //���Լ������
        String temp="select * from t_user where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, pingjia.getUid());
        ResultSet rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;
      //���Լ������
        temp="select * from t_items where id=? ";
        this.state=this.con.prepareStatement(temp);
        this.state.setInt(1, pingjia.getItid());
        rs = state.executeQuery();        //���ܲ�ѯ���
        if(rs.next())
        	return false;

        if( pingjia != null ) {
            
            //��������sql���
            String insertSql = " insert into t_pingjia(name,infos,addtime,uid,itid,type,grade) "
                    + " values(?,?,?,?,?,?,?) ";
            
            //ȡ�ò������ݿ�Ķ���
            this.state = this.con.prepareStatement(insertSql);
            this.state.setString(1, pingjia.getName());
            this.state.setString(2, pingjia.getInfos());
            this.state.setString(3, pingjia.getAddtime());
            this.state.setInt(4, pingjia.getUid());
            this.state.setInt(5, pingjia.getItid());
            this.state.setString(6, pingjia.getType());
            this.state.setInt(7, pingjia.getGrade());
            
            if( this.state.executeUpdate() > 0 ) {        //�ɹ���������
                return true;
            }

            this.state.close();        //�ر����ݿ��������
        }
        return false;        //�����жϱ�־
	}

	//ɾ
	public boolean remove(int id) throws Exception {
     
        boolean flag = false;    //�ж��Ƿ�ɾ���ɹ�
        //��������ɾ����sql���
        String removeSql = " delete from t_pingjia where id = ? ";
        this.state = this.con.prepareStatement(removeSql);
        this.state.setInt(1, id); 
        if( this.state.executeUpdate() > 0 ) {        //ɾ���ɹ�
            flag = true;
        }
        this.state.close();        //�ر�����
        return flag;
    }

	//��
	public Pingjia search(int id) throws Exception {
		Pingjia pingjia = null;        //���ܲ�ѯ���صĶ���
        ResultSet rs = null;        //���ܲ�ѯ���
        
        //id��Ϊ�գ��Ҳ�Ϊ""
        if( id>0 ) {        
            
            //�������ڲ�ѯ��sql���
            String selectSql = "select * from t_pingjia where id=? ";
            
            this.state = this.con.prepareStatement(selectSql);
            this.state.setInt(1, id);
            rs = this.state.executeQuery();
            
            //��ѯ�ɹ�
            if( rs.next() ) {
                
                pingjia = new Pingjia();        //ʵ��������
            	pingjia.setInfos(rs.getString("infos"));
            	pingjia.setId(rs.getInt("id"));
            	pingjia.setName(rs.getString("name"));
                pingjia.setGrade(rs.getInt("grade"));
                pingjia.setAddtime(rs.getString("addtime"));
                pingjia.setUid(rs.getInt("uid"));
                pingjia.setItid(rs.getInt("itid"));
                pingjia.setType(rs.getString("type"));
            }
            
            this.state.close();        //�ر�����
        }
        
        return pingjia;
    }

	//��(���ܸ����)
    public boolean update(Pingjia pingjia) throws Exception {
        boolean flag = false;        //����Ƿ���³ɹ�
        
        if( pingjia != null ) {
            
            //����������
            String updateSql = " update t_pingjia set name=?,infos=?,addtime=?, type=?,grade=? where id=?";
            
            this.state = this.con.prepareStatement(updateSql);

            this.state.setString(1, pingjia.getName());
            this.state.setString(2, pingjia.getInfos());
            this.state.setString(3, pingjia.getAddtime());
            this.state.setString(4, pingjia.getType());
            this.state.setInt(5, pingjia.getGrade());  
            this.state.setInt(6, pingjia.getId());
            
            if( this.state.executeUpdate() > 0 ) {        //���³ɹ�
                flag = true;
            }
            this.state.close();            //�ر�����
        }
        return flag;
    }
}
