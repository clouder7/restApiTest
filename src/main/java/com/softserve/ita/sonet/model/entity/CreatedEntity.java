package com.softserve.ita.sonet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class CreatedEntity extends BaseEntity {

    @PrePersist
    public void beforeSave(){
        creationTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
    }

    @Column(name = "creation_time")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime creationTime ;


    @Column(name = "update_time")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime updateTime;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("creationTime", getCreationTime())
                .append("lastUpdateTime", getUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationTime);
    }
}
