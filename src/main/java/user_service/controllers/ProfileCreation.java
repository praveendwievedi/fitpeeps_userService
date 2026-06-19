package user_service.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user_service.DTO.ProfileResponse;
import user_service.DTO.UpdateProfileResponse;
import user_service.DTO.UserRequest;
import user_service.DTO.UserUpdateRequest;
import user_service.models.User;
import user_service.services.ProfileServices;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ProfileCreation {
    private final ProfileServices profileServices;

    @PostMapping("/register")
    public ResponseEntity<?> createProfile(@RequestBody UserRequest request){
        System.out.println("hello");
        System.out.println(request);
        ProfileResponse profile=profileServices.createUserProfile(request);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UserUpdateRequest request){
        if(profileServices.checkForUser(id).isEmpty())return new ResponseEntity<>("User Not Found",HttpStatus.OK);
//        if(profileServices.checkForUser(userId).get().getId()!=req)
        UpdateProfileResponse user=profileServices.updateUserProfile(request,id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
