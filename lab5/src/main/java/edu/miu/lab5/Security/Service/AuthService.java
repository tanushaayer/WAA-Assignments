package edu.miu.lab5.Security.Service;

import edu.miu.lab5.Dto.LoginRequest;
import edu.miu.lab5.Dto.LoginResponse;
import edu.miu.lab5.Dto.RefreshTokenRequest;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
