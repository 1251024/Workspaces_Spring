package com.boot.jpa.model.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //javax.persistence로 임포트하기 //@Entity: 데이터로 관리하려고 하는 객체
@Table(name="MYBOARD") //javax.persistence로 임포트하기
public class JpaDto {

	@Id	//primary key
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO) //GeneratedValue는 시퀀스 =하이버네이트가 어떻게 값을 만들거냐는 전략 (auto는 지가 알아서 만들어주겠다)
	private int myno;
	
	@Column
	private String myname;
	
	@Column
	private String mytitle;
	
	@Column
	private String mycontent;
	
	@Temporal(TemporalType.DATE) //sysdate 자동으로 오늘 날짜 넣어주겠다(date는 연월일 잡아주는거, 그외 타임스템프 등 시분초까지 넣을 수 있는것도 있음)
	@Column(updatable = false)
	private Date mydate;
	
	
	public JpaDto() {
	}

	public JpaDto(int myno, String myname, String mytitle, String mycontent, Date mydate) {
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontent = mycontent;
		this.mydate = mydate;
	}

	public int getMyno() {
		return myno;
	}

	public void setMyno(int myno) {
		this.myno = myno;
	}

	public String getMyname() {
		return myname;
	}

	public void setMyname(String myname) {
		this.myname = myname;
	}

	public String getMytitle() {
		return mytitle;
	}

	public void setMytitle(String mytitle) {
		this.mytitle = mytitle;
	}

	public String getMycontent() {
		return mycontent;
	}

	public void setMycontent(String mycontent) {
		this.mycontent = mycontent;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}
	
	
	
}
