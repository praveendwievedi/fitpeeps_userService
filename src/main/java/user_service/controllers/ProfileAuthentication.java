package user_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import user_service.DTO.UserLimitedDetails;
import user_service.models.User;
import user_service.services.ProfileServices;

import java.util.Optional;

@RestController
@RequestMapping("/users/auth")
@RequiredArgsConstructor
public class ProfileAuthentication {
    private final ProfileServices userServices;

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserDeatails(@PathVariable Long id){
        Optional<?> user=userServices.checkForUser(id);
//        User foundUser=user.ifPresent().get();
        if(user.isEmpty())return new ResponseEntity<>("Not Found",HttpStatus.OK);
        User foundUser= (User) user.get();
        UserLimitedDetails result=new UserLimitedDetails(foundUser.getName(),foundUser.getEmail(),foundUser.getId());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
