package main;

import java.util.List;

import DaoImplment.AdminDao;
import vo.Admin;

public class TestAdmin {

	public static void main(String args[]) throws Exception {
		List<Admin> list = null;
		AdminDao admindao = new AdminDao(); // ����
		System.out.println("1111111111111");
		list = admindao.getAdmin();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getName());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Admin admin = new Admin();
		admin.setEmail("test");
		admin.setPwd("123");
		admin.setNo("admin3");
		admin.setTel("131590");
		admin.setName("����");

		boolean flag = admindao.add(admin);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = admindao.getAdmin();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		admin.setName("����2");
		admindao.update(admin);
		list = admindao.getAdmin();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Admin u = new Admin();
		u = admindao.search("admin2");
		if (u != null)
			System.out.println("�飺" + u.getName());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		admindao.remove("admin3");

		list = admindao.getAdmin();
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).getName());

	}
}