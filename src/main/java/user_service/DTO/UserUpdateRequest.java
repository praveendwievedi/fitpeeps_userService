package user_service.DTO;

public record UserUpdateRequest(
        String firstName,
        String lastName,
        String email,
        String password
) {
}
