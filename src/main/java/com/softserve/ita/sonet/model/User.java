package com.softserve.ita.sonet.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name="actor_id")
public class User extends Actor {

    private String lastName;

    private String firstName;

    private String email;

    private String password;

    private String city;

    private String country;

    private String planet;

    @ManyToMany
    @JoinTable(
            name = "follows",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<User> followers;

    @ManyToMany(mappedBy = "followers")
    private List<User> following;

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups;

    @OneToMany(mappedBy = "creator")
    private List<Group> createdGroups;

    @ManyToMany
    @JoinTable(
            name = "user_chats",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "chat_id")
    )
    private List<Chat> chats;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("email", getEmail())
                .append("city", getCity())
                .append("country", getCountry())
                .append("planet", getPlanet())
                .append("firstName", getFirstName())
                .append("lastName", getLastName());
    }
}
