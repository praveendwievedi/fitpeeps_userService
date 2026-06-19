package user_service.DTO;

import java.time.LocalDate;

public record UserRequest(String name,String email,String password,LocalDate birthDate) { }
