package com.softserve.ita.sonet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    protected ToStringCreator getToStringCreator() {
        return new ToStringCreator(this)
                .append("id", getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof BaseEntity)) {
            return false;
        }

        BaseEntity entity = (BaseEntity) obj;
        return Objects.equals(id, entity.id);
    }

    @Override
    public String toString() {
        return getToStringCreator().toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
