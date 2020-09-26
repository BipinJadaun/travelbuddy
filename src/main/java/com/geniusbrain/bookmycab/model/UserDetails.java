package com.geniusbrain.bookmycab.model;


import com.geniusbrain.bookmycab.validation.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user_Details")
public class UserDetails {

	@Id
	@NotBlank
	@Column(name = "user_Id", nullable = false, unique = true)
	String userId;

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

	@Past
	@Column(name = "birth_Date", nullable = false)
	private Date birthDate;

	@Column(name = "wallet_money")
	double walletMoney;

	public UserDetails() {
	}

	public UserDetails(String userId, String fullName, String phoneNo, String mailId, Date birthDate, double walletMoney) {
		this.userId = userId;
		this.fullName = fullName;
		this.phoneNo = phoneNo;
		this.mailId = mailId;
		this.birthDate = birthDate;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
				", birthDate='" + birthDate + '\'' +
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
