package com.softserve.ita.sonet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "groups")
public class Group extends Actor {

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToMany(mappedBy = "groups")
    private List<User> members;


    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("name", getName())
                .append("description", getDescription())
                .append("creator", creator.getId());
    }
}
