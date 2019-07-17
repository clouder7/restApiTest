package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.entity.CreatedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "chats")
public class Chat extends CreatedEntity {

    @ManyToMany(mappedBy = "chats")
    private List<User> members;

    @OneToMany(mappedBy = "chat")
    private List<Channel> channels;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
