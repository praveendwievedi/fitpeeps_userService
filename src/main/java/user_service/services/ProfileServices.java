package user_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import user_service.DTO.ProfileResponse;
import user_service.DTO.UpdateProfileResponse;
import user_service.DTO.UserRequest;
import user_service.DTO.UserUpdateRequest;
import user_service.models.User;
import user_service.repos.UserRepo;

import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProfileServices {
    private final UserRepo userRepo;

    public ProfileResponse helpConverting(User request){
        return new ProfileResponse(request.getName(),request.getId());
    }

    // create User profile
    public ProfileResponse createUserProfile(UserRequest request){
        User user=new User();
        user.setName(request.name());
        user.setBirthDate(request.birthDate());
        user.setEmail(request.email());
        User savedUser=userRepo.save(user);
        return helpConverting(savedUser);
    }
    // update the user profile
    public UpdateProfileResponse updateUserProfile(UserUpdateRequest request, long userId){
        Optional<User> existedUser=checkForUser(userId);
        User user=existedUser.get();
        user.setEmail(request.email());
        return new UpdateProfileResponse(user.getName(),user.getEmail(),user.getId());
    }

    // authenticating user
    public Optional<User> checkForUser(long userId){
        Optional<User> existingUser=userRepo.findById(userId);
        return existingUser;
    }

    // deletetion of user
    public Optional<?> deleteUser(Long userId){
        Optional<User> user=userRepo.findById(userId);
        userRepo.deleteById(userId);
        return user;
    }
}
