package main;

import java.util.List;

import DaoImplment.BlogDao;
import base.Vobase;
import vo.Blog;
import vo.Blog;

public class TestBlog {
	public static void main(String args[]) throws Exception {
		List<Blog> list = null;
		BlogDao blogdao = new BlogDao(); // ����
		System.out.println("1111111111111");
		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getZhaiyao());

		/////////////////////////////////// ��
		System.out.println("************************************\n����������Ĺ���");
		Blog blog = new Blog();
		blog.setId(2);
		blog.setInfos("1-infos");
		blog.setItid(1);
		blog.setPicurls("1-picurls");
		blog.setTime("1-time");
		blog.setTitle("1-title");
		blog.setType("1-type");
		blog.setZhaiyao("1-zhaiyao");

		boolean flag = blogdao.add(blog);
		System.out.println("�����Ƿ�ɹ�:" + flag);

		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println((list.get(i)).getZhaiyao());

		/////////////////////////////////// //��
		System.out.println("************************************\n������ԸĵĹ���");
		blog.setZhaiyao("ժҪ����");
		blogdao.update(blog);
		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getZhaiyao());

		/////////////////////////////////// //��
		System.out.println("************************************\n������Բ�Ĺ���");
		Blog u = new Blog();
		u = blogdao.search(2);
		if (u != null)
			System.out.println("�飺" + u.getZhaiyao());
		else
			System.out.println("���޴���");

		/////////////////////////////////// // //ɾ
		System.out.println("************************************\n�������ɾ�Ĺ���");
		blogdao.remove(2);

		list = blogdao.getBlog();
		for (int i = 0; i < list.size(); i++)
			System.out.println(( list.get(i)).getZhaiyao());

	}
}
