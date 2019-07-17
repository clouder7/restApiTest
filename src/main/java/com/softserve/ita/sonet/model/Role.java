package com.softserve.ita.sonet.model;

import com.softserve.ita.sonet.model.entity.BaseEntity;
import lombok.*;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "name", unique = true, nullable = false)
    private String name;


    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    public Role(String name){
        this.name = name;
    }

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator().append("name",name);
    }
}
