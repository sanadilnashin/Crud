package crud_project.com.example.crud.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service

public class ServiceUser {
    @Autowired
    UserRepo userRepo;
    User createUser(@RequestBody User user)
    {
        User user1=new User();
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        return userRepo.save(user1);
    }

    public List<User> findAllUser() {
        return userRepo.findAll();
    }
    @Cacheable(value = "applicationCache",key = "#id")
    public User findByUser(int id) {
        return userRepo.findById(id)
                .orElseThrow((()->new ResourceNotFoundException("user","id",id)));
    }
    @CacheEvict(value = "applicationCache",allEntries = true)
    public void clearCache()
    {
        System.out.println("clear cache");
    }

    public User deleteById(int id) {
        User user=findByUser(id);
         userRepo.deleteById(id);
         return user;
    }
}
