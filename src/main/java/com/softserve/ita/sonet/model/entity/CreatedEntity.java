package com.softserve.ita.sonet.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@MappedSuperclass
public abstract class CreatedEntity extends BaseEntity {

    @Column(name = "creation_time")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime creationTime;

    @Column(name = "update_time")
    @DateTimeFormat(pattern = "hh:mm:ss dd/MM/yyyy")
    protected LocalDateTime updateTime;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("creationTime", getCreationTime().format(DateTimeFormatter.ISO_DATE_TIME))
                .append("lastUpdateTime", getUpdateTime().format(DateTimeFormatter.ISO_DATE_TIME));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creationTime);
    }
}
