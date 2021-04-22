package com.mvc.upgrade.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.upgrade.model.dao.MYBoardDao;
import com.mvc.upgrade.model.dto.MYBoardDto;


@Service
public class MYBoardBizImpl implements MYBoardBiz {

	@Autowired
	private MYBoardDao dao;
	
	@Override
	public List<MYBoardDto> selectList() {
		return null;
	}

	@Override
	public MYBoardDto selectOne(int myno) {
		return null;
	}

	@Override
	public int insert(MYBoardDto dto) {
		return 0;
	}

	@Override
	public int update(MYBoardDto dto) {
		return 0;
	}

	@Override
	public int delete(int myno) {
		return 0;
	}

}
