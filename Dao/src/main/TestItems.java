package main;

import java.util.List;

import DaoImplment.BlogDao;
import DaoImplment.ItemsDao;
import vo.Blog;
import vo.Items;

public class TestItems {
	public static void main(String args[]) throws Exception {
		List<Items> list = null;
		ItemsDao itemsdao = new ItemsDao(); // ����
		System.out.println("1111111111111");
		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Items item = new Items();
		item.setBrand("brand1");
		item.setId(2);
		item.setInfos("info1");
		item.setName("name1");
		item.setNo("user1");
		item.setPrice(4.4);
		item.setType("type1");
		item.setUrls("urls1");
		
		boolean flag = itemsdao.add(item);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		item.setName("���ֲ���");
		itemsdao.update(item);
		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Items u = new Items();
		u = itemsdao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getName());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		itemsdao.remove(2);

		list = itemsdao.getItems();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
