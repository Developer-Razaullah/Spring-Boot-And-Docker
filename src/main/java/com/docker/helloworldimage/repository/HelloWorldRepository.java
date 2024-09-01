package com.docker.helloworldimage.repository;

import com.docker.helloworldimage.entity.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloWorldRepository extends JpaRepository<HelloWorld, Long> {
}
