package com.mostafa.librarysystem.repo;

import com.mostafa.librarysystem.entities.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Long> {
}
