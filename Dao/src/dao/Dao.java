/*
 * Description:����DAO�ӿڣ��ڸýӿ���ֻ�Ƕ����Ա���Ĳ�����
 *                 ���������Ҫʵ�ָýӿڵ������
 * 
 * */

package dao;

import java.sql.Connection;


public interface Dao {

	public Connection getConnection() throws Exception;
	
	public void close() throws Exception;
/*    //����������Ϣ
    public boolean add(Object obj) throws Exception;
    
    //���ݺ�ɾ�����ж�Ӧ��
    public boolean remove(int id) throws Exception;
    
    //���պŲ���
    public User search(int id) throws Exception;
    
    //����ȫ��
    public List<Object> getWorkers() throws Exception;
    
    //������Ϣ
    public boolean update(Object obj) throws Exception;*/
    
}