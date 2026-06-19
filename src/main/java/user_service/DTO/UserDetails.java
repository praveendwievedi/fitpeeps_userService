package user_service.DTO;

import java.time.LocalDate;
import java.util.UUID;

public record UserDetails(long id,String name,String email,LocalDate birthDate) {
}
