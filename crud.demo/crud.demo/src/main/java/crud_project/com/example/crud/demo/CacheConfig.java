package crud_project.com.example.crud.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {
    @Autowired
    CacheManager cacheManager;
    @Autowired
    ServiceUser serviceUser;

    @PostConstruct
     public void preLoadCache()
     {
         Cache cache= cacheManager.getCache("applicationCache");
         System.out.println("initializing Cache");
         List<User> userList= serviceUser.findAllUser();
         for (User u:userList)
         {
             cache.put(u.getId(),u);
         }
     }

}
