package com.ensa.ecom.dao;


import com.ensa.ecom.entities.Colors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource
public interface ColorsRepository extends JpaRepository<Colors, Long> {

        void deleteColorById(Long id);
        Optional<Colors> findById(Long id);
}
