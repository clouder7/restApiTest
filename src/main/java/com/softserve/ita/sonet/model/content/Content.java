package com.softserve.ita.sonet.model.content;

import com.softserve.ita.sonet.model.Actor;
import com.softserve.ita.sonet.model.entity.CreatedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class Content extends CreatedEntity {

    @Type(type = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Actor creator;

    @SuppressWarnings("unchecked")
    public <A extends Actor> A getCreator() {
        return (A) creator;
    }

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("text", getText())
                .append("creator", getCreator().getId());
    }
}
