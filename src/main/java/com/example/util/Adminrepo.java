package com.example.util;

import com.example.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Adminrepo extends JpaRepository<Admin, Integer> {
}


