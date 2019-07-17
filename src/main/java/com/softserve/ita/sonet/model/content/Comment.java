package com.softserve.ita.sonet.model.content;

import com.softserve.ita.sonet.model.Actor;
import com.softserve.ita.sonet.model.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "comments")
public class Comment extends Content {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToMany
    @JoinTable(
            name = "comment_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> likes;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    protected Status status;

    public Comment() {
        super();
    }


    @SuppressWarnings("unchecked")
    public <A extends Actor> List<A> getLikes() {
        return (List<A>) likes;
    }

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("post", getPost().getId());
    }
}
