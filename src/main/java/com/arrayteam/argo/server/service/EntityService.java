package com.arrayteam.argo.server.service;


import org.springframework.data.jpa.repository.JpaRepository;


public class EntityService<R extends JpaRepository<T, ID>, T, ID> {
}
