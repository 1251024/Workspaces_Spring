package com.mvc.update.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mvc.update.model.dto.JDBCDto;

@Repository
public class JDBCDaoImpl implements JDBCDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	//1. interface 구현 방식
	@Override
	public List<JDBCDto> selectList() {
		
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		list = JdbcTemplate.query(SELECT_LIST_SQL, null, null, new RowMapper<JDBCDto>() {
		//쿼리문으로부터 pstm을 만들어서 rowmapper에 로우단위로 매핑시켜준다
			//SELECT_LIST_SQL로 요청하면 db에서 table을 준다  resultset while로 가여오는거처럼
			//RowMapper가 db랑 연결되서 테이블가져오는데, 로우하나하나를 가지고와서 리턴에 매핑 시켜줄거야
			
			//RowMapper: ResultSet의 행을 행별로 매핑하기 위해 사용하는 인터페이스입니다. sql예외처리는 jdbc템플릿이해준다.
			//result 오브젝트에 각 row별로 매핑을 해주며 예외처리를 걱정할필요가 없다. SQLException은 JdbcTemplate에서 잡아줄것이다
			//@repository는 dao에서 예외생기면 DataAccessException처리해주고,
			//RowMapper는 sql예외처리 jdbc템플릿이 해줘서 결국 jdbc 템플릿이 예외처리해줌
			//RowMapper는 jdbc의 4번 해주고 있는거, 125번은 jdbc템플릿이 해주는거
			 

			@Override
			public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
		});
		
		return list;
	}
	*/
	
	/*
	//2. 람다식
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		list = JdbcTemplate.query(SELECT_LIST_SQL, (rs, rowNUm)-> {
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		});

		return list;
	}
	//@FunctionalInterface:메소드가 하나인 인터페이스(변수)->{그에 대한 몸통},자바스크립트 화살표함수와 비슷함...
*/
	
	
	//3. inner class사용-아래 이너클래스메소드 만들어줘야 함(RowMapper한번에 많이 쓸 경우 이너클래스로 만들어서 사용)
	@Override
	public List<JDBCDto> selectList() {
		List<JDBCDto> list = new ArrayList<JDBCDto>();
		
		list = jdbcTemplate.query(SELECT_LIST_SQL, new MyMapper());

		return list;
	}
	
	@Override
	public JDBCDto selectOne(int seq) {
		JDBCDto dto = null;
		
		dto = jdbcTemplate.queryForObject(SELECT_ONE_SQL, new Object[] {seq}, new int[] {Types.INTEGER}, new MyMapper());
		
		return dto;
	}

	@Override
	public int insert(JDBCDto dto) {
		//jdbcTemplate.update();
		
		int res = 0;
		
		res = jdbcTemplate.update(INSERT_SQL, new Object[] {dto.getWriter(), dto.getTitle(), dto.getContent()});
		
		return res;
	}

	@Override
	public int update(JDBCDto dto) {
		int res = 0;
		
		res = jdbcTemplate.update(UPDATE_SQL, new Object[] {dto.getTitle(), dto.getContent()});
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		
		res = jdbcTemplate.update(DELETE_SQL, new int[] {Types.INTEGER});
		
		return res;
	}

	//inner class(row mapper를 상속받는 inner클래스
	private static final class MyMapper implements RowMapper<JDBCDto>{
		
		public JDBCDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			return new JDBCDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
		}
	}
}
