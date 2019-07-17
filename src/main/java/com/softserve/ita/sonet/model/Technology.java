package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "technologies")
public class Technology extends BaseEntity {

    private String name;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("name", getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
