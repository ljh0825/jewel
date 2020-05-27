package com.jewel.member.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jewel.common.dao.AbstractDAO;


@Repository("joinDAO")
public class JoinDAO extends AbstractDAO{
	
	public int selectIdCheck(Map<String, Object> map) throws Exception{
		return (Integer)selectOne("member.selectIdCheck",map);
	}
	public void insertMember(Map<String, Object> map) throws Exception {
		insert("member.insertMember",map);
	}
	public int selectNickCheck(Map<String, Object> map) throws Exception{
		return (Integer) selectOne("member.selectNickCheck",map);
	}
}