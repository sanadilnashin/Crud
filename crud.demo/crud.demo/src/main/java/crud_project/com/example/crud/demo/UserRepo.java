package crud_project.com.example.crud.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Integer>{
}
