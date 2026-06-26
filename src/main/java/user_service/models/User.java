package user_service.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(unique = true)
    private String userName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(unique = true)
    private String email;
    private LocalDate birthDate;
    private String password;
    @Column(length = 2048)
    private String refreshToken;
    
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        this.updatedAt=LocalDateTime.now();
        this.createdAt=LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt=LocalDateTime.now();
    }
}
