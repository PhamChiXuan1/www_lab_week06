package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(length = 15)
    private String mobile;
    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50, unique = true)
    private String email;
    @Lob
    @Column(columnDefinition = "text")
    private String intro;
    @Lob
    @Column(columnDefinition = "text")
    private String profile;
    @Column(nullable = false)
    private Instant registeredAt;
    @Column(length = 32, nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private Instant lastLogin;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts=new LinkedHashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<PostComment> comments=new LinkedHashSet<>();

    public User(String mobile, String firstName, String middleName, String lastName, String email, String intro, String profile, Instant registeredAt, String passwordHash, Instant lastLogin) {
        this.mobile = mobile;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.intro = intro;
        this.profile = profile;
        this.registeredAt = registeredAt;
        this.passwordHash = passwordHash;
        this.lastLogin = lastLogin;
    }
}
