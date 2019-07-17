package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.entity.CreatedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "images")
public class Image extends CreatedEntity {

    @Type(type = "text")
    private String url;

    @Enumerated(EnumType.STRING)
    @Column(name="image_status")
    protected Status status;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("url", getUrl())
                .append("status",getStatus().name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }
}
