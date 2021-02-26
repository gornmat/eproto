package com.demo.eproto.repository;

import com.demo.eproto.model.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

    Optional<ImageFile> findByIdParent(Long idParent);
}
