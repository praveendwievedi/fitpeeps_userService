package user_service.DTO;

import java.time.LocalDate;

public record UserPersoalDetails(
        String userName,
        String firstName,
        String lastName,
        Integer age,
        String gender,
        String email,
        LocalDate birthDate
) {
}
