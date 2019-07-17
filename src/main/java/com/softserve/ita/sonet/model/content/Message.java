package com.softserve.ita.sonet.model.content;

import com.softserve.ita.sonet.model.Channel;
import com.softserve.ita.sonet.model.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.core.style.ToStringCreator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "messages")
public class Message extends Content {

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    protected Status status;

    @Override
    protected ToStringCreator getToStringCreator() {
        return super.getToStringCreator()
                .append("channel", getChannel().getId())
                .append("status",getStatus().name());
    }
}
