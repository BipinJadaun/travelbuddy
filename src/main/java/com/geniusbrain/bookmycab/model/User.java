package com.geniusbrain.bookmycab.model;


import com.geniusbrain.bookmycab.validation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

	@Id
	@NotBlank
	@Column(name = "user_Id", nullable = false, unique = true)
	String userId;

	@NotBlank
	@Size(min = 6)
	@Column(name = "password", nullable = false)
	String password;

	@NotBlank
	@Column(name = "full_name", nullable = false)
	String fullName;

	@NotBlank
	@Size(min = 10)
	@Column(name = "phone_no", nullable = false, unique = true)
	String phoneNo;

	@NotBlank
	@ValidEmail
	@Column(name = "mail_id", nullable = false, unique = true)
	String mailId;

	@Column(name = "wallet_money", nullable = false, unique = true)
	double walletMoney;

	//@OneToMany
	//List<Trip> bookings;

	public User() {
	}

	public User(String userId, String password, String fullName, String phoneNo, String mailId, double walletMoney) {
		this.userId = userId;
		this.password = password;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.mailId = mailId;
		this.walletMoney = walletMoney;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public double getWalletMoney() {
		return walletMoney;
	}
	public void setWalletMoney(double walletMoney) {
		this.walletMoney = walletMoney;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", password='" + password + '\'' +
				", fullName='" + fullName + '\'' +
				", phoneNo='" + phoneNo + '\'' +
				", mailId='" + mailId + '\'' +
				", walletMoney=" + walletMoney +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(phoneNo, user.phoneNo) &&
				Objects.equals(mailId, user.mailId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNo, mailId);
	}
}
