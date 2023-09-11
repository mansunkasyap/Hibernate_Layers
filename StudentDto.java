package Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StudentDto {
	@Id
	int sid;
	@Column(nullable = false)
	String sname;
	@Column(nullable = false, unique=true)
	String seid;
	@Column(nullable = false, unique = true)
	long mob;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSeid() {
		return seid;
	}
	public void setSeid(String seid) {
		this.seid = seid;
	}
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", sname=" + sname + ", seid=" + seid + ", mob=" + mob + "]";
	}
	
}

