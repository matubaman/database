package main;

import java.util.List;

import DaoImplment.ShopcarDao;
import vo.Shopcar;

public class TestShopcar {
	public static void main(String args[]) throws Exception {
		List<Shopcar> list = null;
		ShopcarDao vodao = new ShopcarDao(); // ����
		System.out.println("1111111111111");
		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Shopcar vo = new Shopcar();
		vo.setId(2);
		vo.setName("name1");
		vo.setItid(1);
		vo.setUid(1);
		boolean flag = vodao.add(vo);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		vo.setName("name����");
		vodao.update(vo);
		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Shopcar u = new Shopcar();
		u = vodao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getName());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		vodao.remove(2);

		list = vodao.getShopcar();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
