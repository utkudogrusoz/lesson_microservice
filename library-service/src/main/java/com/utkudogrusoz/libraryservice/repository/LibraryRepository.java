package com.utkudogrusoz.libraryservice.repository;

import com.utkudogrusoz.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,String> {
}
