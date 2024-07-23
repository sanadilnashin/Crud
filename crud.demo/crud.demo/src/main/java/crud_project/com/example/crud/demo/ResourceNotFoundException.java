package crud_project.com.example.crud.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
     int fieldValue;
    public ResourceNotFoundException(String user, String id, int id1) {
        super(String.format("%s not found %s:",user,id,id1));
        this.resourceName=user;
        this.fieldName=id;
        this.fieldValue=id1;
    }
}
