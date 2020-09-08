package com.geniusbrain.bookmycab.repository;

import com.geniusbrain.bookmycab.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
