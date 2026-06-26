package user_service.DTO;

public record UserResponse(
        Long userId,
        String userName,
        String firstName,
        String lastName,
        String email,
        String password
) {
}
