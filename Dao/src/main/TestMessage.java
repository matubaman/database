package main;

import java.util.List;

import DaoImplment.MessageDao;
import vo.Message;

public class TestMessage {
	public static void main(String args[]) throws Exception {
		List<Message> list = null;
		MessageDao vodao = new MessageDao(); // ����
		System.out.println("1111111111111");
		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Message vo = new Message();
		vo.setId(2);
		vo.setInfos("info1");
		vo.setReply("reply1");
		vo.setState("state1");
		vo.setUid(1);

		boolean flag = vodao.add(vo);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		vo.setInfos("info����");
		vodao.update(vo);
		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Message u = new Message();
		u = vodao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getInfos());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		vodao.remove(2);

		list = vodao.getMessage();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

	}
}
