package crud_project.com.example.crud.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerUser {
    @Autowired
    ServiceUser serviceUser;

    @PostMapping("/user")
    ResponseEntity<User> createUser(@Valid @RequestBody User user)
    {
        return new ResponseEntity(serviceUser.createUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/Find")
    ResponseEntity<List<User>> findAllUser()
    {
        return ResponseEntity.ok(serviceUser.findAllUser());
    }

    @GetMapping("/find/{id}")
    ResponseEntity<User> findByUser(@PathVariable int id)
    {
        return ResponseEntity.ok(serviceUser.findByUser(id));
    }

    @GetMapping("/user/clearcache")
    String clearCache()
    {
        serviceUser.clearCache();
        return "data cleared";
    }
    @DeleteMapping("/user/{id}")
    ResponseEntity<User> deleteUserById(@PathVariable int id)
    {
        return ResponseEntity.ok(serviceUser.deleteById(id));
    }

}
