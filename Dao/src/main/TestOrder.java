package main;

import java.util.List;

import DaoImplment.OrderDao;
import vo.Order;

public class TestOrder {
	
	public static void main(String args[]) throws Exception {
		List<Order> list = null;
		OrderDao vodao = new OrderDao(); // ����
		System.out.println("1111111111111");
		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Order vo = new Order();
		vo.setId(2);
		vo.setInfos("info1");
		vo.setUid(1);
		vo.setItid(1);

		boolean flag = vodao.add(vo);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		vo.setInfos("info����");
		vodao.update(vo);
		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Order u = new Order();
		u = vodao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getInfos());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		vodao.remove(2);

		list = vodao.getOrder();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

	}
}
