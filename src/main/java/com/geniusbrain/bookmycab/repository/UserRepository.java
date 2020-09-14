package com.geniusbrain.bookmycab.repository;

import com.geniusbrain.bookmycab.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, String> {

}
