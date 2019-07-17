package com.softserve.ita.sonet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class NamedEntity extends CreatedEntity {

    private String name;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("name", getName());
    }
}
