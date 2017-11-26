package com.sportclusters.sportclusters.entity;

import com.sportclusters.sportclusters.security.model.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "EVENT")
public class Event {

    @Id
 //   @Column(name = "ID")
 //   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
 //   @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID", columnDefinition = "CHAR(32)")
    private UUID id;


    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;


    @Column(name = "MAXPLAYERSNUMBER")
    private Integer maxPlayersNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="IDUSER")
    @NotNull
    private User owner;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "EVENT_LOCATION",
            joinColumns = @JoinColumn(name = "IDEVENT"),
            inverseJoinColumns = @JoinColumn(name ="IDLOCATION", nullable = false))
    private Location location;


    @ManyToMany(mappedBy = "joiningEvents")
    protected Set<User> joinedUsers = new HashSet<>();


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Event)){
            return false;
        }


        Event other = (Event)obj;
        if(this.getOwner() == null || other.getOwner() == null
                || this.getDate() == null || other.getDate() == null){
            return false;
        }

        if(this.getOwner().equals(other.getOwner())
                && this.getDate().equals(other.getDate())){
            return true;
        }

        return false;

    }


    @Override
    public int hashCode() {
        String str = this.getOwner().getUsername() + this.getDate().toString();
        return str.hashCode();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<User> getJoinedUsers() {
        return joinedUsers;
    }

    public void setJoinedUsers(Set<User> joinedUsers) {
        this.joinedUsers = joinedUsers;
    }
}
