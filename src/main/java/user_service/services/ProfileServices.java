package user_service.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import user_service.DTO.UserDetails;
import user_service.DTO.UserResponse;
import user_service.DTO.UserRequest;
import user_service.DTO.UserUpdateRequest;
import user_service.models.Gender;
import user_service.models.User;
import user_service.repos.UserRepo;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProfileServices {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    public UserResponse convertToUserResponse(User request){
        return new UserResponse(
                request.getUserId(),
                request.getUserName(),
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword()
        );
    }

    public UserDetails convetToUserDetails(User user){
        return new UserDetails(
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    // create User profile
    public UserResponse createUserProfile(UserRequest request){
        User user=new User();
        user.setUserName(request.userName());
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName() == null ? "" : request.lastName());
        user.setBirthDate(request.birthDate());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setGender(request.gender()== null ? Gender.UNKNOWN : Gender.valueOf(request.gender().toUpperCase()));
        User savedUser=userRepo.save(user);
        return convertToUserResponse(savedUser);
    }
    // update the user profile
    public UserResponse updateUserProfile(UserUpdateRequest request, Long userId){
        Optional<User> existedUser=getUserDetailsById(userId);
        User user=existedUser.get();
        user.setPassword(request.password() == null ? user.getPassword() :passwordEncoder.encode(request.password()));
        user.setEmail(request.email() == null ? user.getEmail() : request.email());
        user.setLastName(request.lastName()==null ? user.getLastName() : request.lastName());
        user.setFirstName(request.firstName()==null ? user.getFirstName() : request.firstName());
        return convertToUserResponse(user);
    }

    // deletetion of user
    public UserResponse deleteUser(Long userId){
        Optional<User> user=getUserDetailsById(userId);
        userRepo.deleteById(userId);
        return convertToUserResponse(user.get());
    }

    public Optional<User> getUserDetailsById(Long userId) {return userRepo.findById(userId);}

    public Optional<UserDetails> findUserByEmail(String email) {
        return userRepo.findByEmail(email).map(this::convetToUserDetails);
    }

    public Optional<UserDetails> findUserByUseName(String userName) {
        return userRepo.findByUserName(userName).map(this::convetToUserDetails);
    }
}
