package com.member;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private String id;
	private String name;
	private String pw;
	private String birth;
	private String email;
	
	public MemberDTO() {}
	
	public MemberDTO(String id, String name, String pw, String birth, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.birth = birth;
		this.email = email;
	}


	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", name=" + name + ", pw=" + pw + ", birth=" + birth + ", email=" + email + "]";
	}


}
