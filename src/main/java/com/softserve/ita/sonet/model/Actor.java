package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.content.Comment;
import com.softserve.ita.sonet.model.content.Post;
import com.softserve.ita.sonet.model.entity.CreatedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "actors")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Actor extends CreatedEntity {

    private String nickname;

    @OneToOne
    @JoinColumn(
            name = "logo_id",
            referencedColumnName = "id"
    )

    private Image logo;

    @OneToOne
    @JoinColumn(
            name = "avatar_id",
            referencedColumnName = "id"
    )
    private Image avatar;

    @OneToOne
    @JoinColumn(
            name = "background_id",
            referencedColumnName = "id"
    )
    private Image background;

    @ManyToMany
    @JoinTable(
            name = "actor_images",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private List<Image> images;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    protected Status status;

    @OneToMany(mappedBy = "owner")
    private List<Post> ownPosts;

    @OneToMany(mappedBy = "creator")
    private List<Post> createdPosts;

    @OneToMany(mappedBy = "creator")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "actor_technology",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private List<Technology> technologies;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actor_role",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("nickname", getNickname())
                .append("logo", getLogo().getUrl())
                .append("avatar", getAvatar().getUrl())
                .append("background", getBackground().getUrl())
                .append("roles",getRoles())
                .append("status",getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, creationTime, updateTime);
    }
}
