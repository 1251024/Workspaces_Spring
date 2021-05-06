package com.mvc.update.model.dao;

import java.util.List;

import com.mvc.update.model.dto.JDBCDto;

public interface JDBCDao {

	String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
						   + " FROM JDBCBOARD "
						   + " ORDER BY SEQ DESC ";
	String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE "
					      + " FROM JDBCBOARD "
					      + " WHERE SEQ = ? ";
	String INSERT_SQL = " INSERT INTO JDBCBOARD "
					  + " VALUES (JDBCSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	String UPDATE_SQL = " UPDATE JDBCBOARD "
					  + " SET TITLE =?, CONTENT = ? "
					  + " WHERE SEQ = ? ";
	String DELETE_SQL = " DELETE FROM JDBCBOARD "
					  + " WHERE SEQ = ? ";
	
	public List<JDBCDto> selectList();
	public JDBCDto selectOne(int seq);
	public int insert(JDBCDto dto);
	public int update(JDBCDto dto);
	public int delete(int seq);
	
}












