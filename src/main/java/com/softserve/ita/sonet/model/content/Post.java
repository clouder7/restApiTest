package com.softserve.ita.sonet.model.content;

import com.softserve.ita.sonet.model.Actor;
import com.softserve.ita.sonet.model.Image;
import com.softserve.ita.sonet.model.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "posts")
public class Post extends Content {

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Actor owner;

    @ManyToMany
    @JoinTable(
            name = "post_images",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> images;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> likes;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    protected Status status;

    public Post() {
        super();
    }

    @SuppressWarnings("unchecked")
    public <A extends Actor> A getOwner() {
        return (A) owner;
    }

    @SuppressWarnings("unchecked")
    public <A extends Actor> List<A> getLikes() {
        return (List<A>) likes;
    }

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("owner", getOwner().getId())
                .append("status",getStatus().name());
    }
}
