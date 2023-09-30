package com.consumer.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consumer.registration.model.*;

public interface Repository extends JpaRepository<User,String> {

}
