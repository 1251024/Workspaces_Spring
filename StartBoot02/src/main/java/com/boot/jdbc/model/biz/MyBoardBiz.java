package com.boot.jdbc.model.biz;

import java.util.List;

import com.boot.jdbc.model.dto.MyDto;

public interface MyBoardBiz {

	public List<MyDto> selectList();
	public MyDto selectOne(int myno);
	public int insert(MyDto dto);
	public int update(MyDto dto);
	public int delete(int myno);
}
