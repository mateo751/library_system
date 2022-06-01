package com.library.system.librarysystem.repositories;

<<<<<<< Updated upstream:library-system-main/library-system/src/main/java/com/library/system/librarysystem/repositories/LoginRepository.java
import com.library.system.librarysystem.models.Login;
=======
import java.util.List;

import com.library.system.librarysystem.models.Autor;
>>>>>>> Stashed changes:library-system-main/library-system/src/main/java/com/library/system/librarysystem/repositories/AutorRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< Updated upstream:library-system-main/library-system/src/main/java/com/library/system/librarysystem/repositories/LoginRepository.java
public interface  LoginRepository extends JpaRepository<Login,Long> {
    
=======
public interface  AutorRepository extends JpaRepository<Autor,Long> {
    public List<Autor> findByTitle (String criteria);
>>>>>>> Stashed changes:library-system-main/library-system/src/main/java/com/library/system/librarysystem/repositories/AutorRepository.java
}
