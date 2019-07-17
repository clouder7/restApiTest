package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.content.Message;
import com.softserve.ita.sonet.model.entity.NamedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "channels")
public class Channel extends NamedEntity {

    private String description;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @OneToMany(mappedBy = "channel")
    private List<Message> messages;
}
