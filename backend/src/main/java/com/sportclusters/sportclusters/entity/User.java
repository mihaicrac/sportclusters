package com.sportclusters.sportclusters.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.*;

@Entity
@Table(name = "user")
public class User {

    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "username", length = 40, unique = true, nullable = false)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "firstname", length = 40)
    @NotNull
    @Size(min = 4, max = 50)
    private String firstname;

    @Column(name = "lastname", length = 40)
    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;

    @Column(name = "email", length = 254, unique = true,  nullable = false)
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "enabled", columnDefinition = "BIT(1)",  nullable = false)
    private Boolean enabled;

    @Column(name = "lastpasswordresetdate_utc")
    private ZonedDateTime lastPasswordResetDateUTC;

    @Column(name = "lastpasswordresetdate_sec")
    private Long lastPasswordResetDateSec;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    private List<Authority> authorities;


    @OneToMany(mappedBy = "owner")
    private Collection<Event> myEvents = new ArrayList<>();


//    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "user_event",
//            joinColumns = @JoinColumn(name = "id_joined_user"),
//            inverseJoinColumns = @JoinColumn(name = "id_event")
//    )
//    private Set<Event> joiningEvents = new HashSet<Event>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public ZonedDateTime getLastPasswordResetDateUTC() {
        return lastPasswordResetDateUTC;
    }

    public void setLastPasswordResetDateUTC(ZonedDateTime lastPasswordResetDateUTC) {
        this.lastPasswordResetDateUTC = lastPasswordResetDateUTC;
    }

    public Collection<Event> getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(Collection<Event> myEvents) {
        this.myEvents = myEvents;
    }

//    public Set<Event> getJoiningEvents() {
//        return joiningEvents;
//    }
//
//    public void setJoiningEvents(Set<Event> joiningEvents) {
//        this.joiningEvents = joiningEvents;
//    }

    public Long getLastPasswordResetDateSec() {
        return lastPasswordResetDateSec;
    }

    public void setLastPasswordResetDateSec(Long lastPasswordResetDateSec) {
        this.lastPasswordResetDateSec = lastPasswordResetDateSec;
    }


}