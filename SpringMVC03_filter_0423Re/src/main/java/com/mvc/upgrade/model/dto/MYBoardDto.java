package com.mvc.upgrade.model.dto;

import java.util.Date;

public class MYBoardDto {

	private int myno;
	private String myname;
	private String mytitle;
	private String mycontetn;
	private Date mydate;
	
	public MYBoardDto() {
	}

	public MYBoardDto(int myno, String myname, String mytitle, String mycontetn, Date mydate) {
		super();
		this.myno = myno;
		this.myname = myname;
		this.mytitle = mytitle;
		this.mycontetn = mycontetn;
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

	public String getMycontetn() {
		return mycontetn;
	}

	public void setMycontetn(String mycontetn) {
		this.mycontetn = mycontetn;
	}

	public Date getMydate() {
		return mydate;
	}

	public void setMydate(Date mydate) {
		this.mydate = mydate;
	}

	@Override
	public String toString() {
		return "MYBoardDto [myno=" + myno + ", myname=" + myname + ", mytitle=" + mytitle + ", mycontetn=" + mycontetn
				+ ", mydate=" + mydate + "]";
	}
	
	
}
