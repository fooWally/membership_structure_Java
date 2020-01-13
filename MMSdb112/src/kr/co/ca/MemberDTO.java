package kr.co.ca;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private int age;
	private String did;
	
	public MemberDTO() {}

	public MemberDTO(String id, String name, String did, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.did = did;
	}
	

	public void setDid(String did) {
		this.did = did;
	}
	public String getDid() {
		return did;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	@Override //hashcode equals 메서드- id만 선택 - id만 같으면 다 같은 객체로 인식
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
		return "id=" + id + ": " + name + ", " + age + ", " + did;
	}


	
	
}
