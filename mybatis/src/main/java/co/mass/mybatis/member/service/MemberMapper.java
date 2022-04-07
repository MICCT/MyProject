package co.mass.mybatis.member.service;

import java.util.List;

public interface MemberMapper { 
	
	//mybatis mapper ���� �ÿ��� �������̽�
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);


}