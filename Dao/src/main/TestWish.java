package main;

import java.util.List;

import DaoImplment.WishDao;
import vo.Wish;

public class TestWish {
	public static void main(String args[]) throws Exception {
		List<Wish> list = null;
		WishDao vodao = new WishDao(); // ����
		System.out.println("1111111111111");
		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Wish vo = new Wish();
		vo.setId(2);
		vo.setName("name1");
		vo.setItid(1);
		vo.setUid(1);
		boolean flag = vodao.add(vo);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		vo.setName("name����");
		vodao.update(vo);
		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Wish u = new Wish();
		u = vodao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getName());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		vodao.remove(2);

		list = vodao.getWish();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getName());

	}
}
