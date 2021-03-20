
		package edu.mum.mumsched.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Account {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long Id;
	@NonNull
	private String email;
	@NonNull
	private String password;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [Id=" + Id + ", email=" + email + ", password=" + password + "]";
	}



//    @Enumerated(EnumType.STRING)
//    public Role role() {
//
//        return role;
//    }



}
