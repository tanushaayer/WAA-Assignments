package edu.miu.lab5.Dto;

import edu.miu.lab5.Entity.Role;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class LoginRequest {
    private String email;
    private String password;
}
