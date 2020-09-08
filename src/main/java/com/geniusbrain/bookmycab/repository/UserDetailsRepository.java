package com.geniusbrain.bookmycab.repository;

import com.geniusbrain.bookmycab.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
}
