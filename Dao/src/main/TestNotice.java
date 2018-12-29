package main;

import java.util.List;

import DaoImplment.NoticeDao;
import vo.Notice;

public class TestNotice {
	public static void main(String args[]) throws Exception {
		List<Notice> list = null;
		NoticeDao vodao = new NoticeDao(); // ����
		System.out.println("1111111111111");
		list = vodao.getNotice();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Notice vo = new Notice();
		vo.setId(2);
		vo.setInfos("info1");
		vo.setTime("2018-12-29");
		vo.setTitle("title1");

		boolean flag = vodao.add(vo);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = vodao.getNotice();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		vo.setInfos("info����");
		vodao.update(vo);
		list = vodao.getNotice();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Notice u = new Notice();
		u = vodao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getInfos());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		vodao.remove(2);

		list = vodao.getNotice();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getInfos());

	}
}
