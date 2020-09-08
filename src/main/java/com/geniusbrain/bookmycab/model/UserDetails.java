package com.geniusbrain.bookmycab.model;


import com.geniusbrain.bookmycab.validation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "user_Details")
public class UserDetails {

	@Id
	@NotBlank
	@Column(name = "user_Id")
	String userId;

	@NotBlank
	@Column(name = "full_name")
	String fullName;

	@NotBlank
	@Size(min = 10)
	@Column(name = "phone_no")
	String phoneNo;

	@NotBlank
	@ValidEmail
	@Column(name = "mail_id")
	String mailId;

	@Column(name = "wallet_money")
	double walletMoney;

//@OneToMany
	//List<Trip> bookings;

	public UserDetails() {
	}

	public UserDetails(String userId, String fullName, String phoneNo, String mailId, double walletMoney) {
		this.userId = userId;
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
		return "UserDetails{" +
				"userId='" + userId + '\'' +
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
		UserDetails userDetails = (UserDetails) o;
		return Objects.equals(phoneNo, userDetails.phoneNo) &&
				Objects.equals(mailId, userDetails.mailId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(phoneNo, mailId);
	}
}
