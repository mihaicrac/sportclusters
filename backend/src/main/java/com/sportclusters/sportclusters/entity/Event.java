package com.sportclusters.sportclusters.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@Table(name = "EVENT")
public class Event {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ID", columnDefinition = "CHAR(32)")
    private UUID id;


    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date date;


    @Column(name = "MAX_PLAYERS_NUMBER")
    private Integer maxPlayersNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_OWNER")
    @NotNull
    private User owner;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_LOCATION")
    private Location location;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_EVENTTYPE")
    private EventType eventType;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserEvent> joinedUsers = new ArrayList<>();


    public void addUser(User user, Integer userGuests) {
        UserEvent userEvent = new UserEvent();
        userEvent.setEvent(this);
        userEvent.setUser(user);
        userEvent.setGuestsNumber(userGuests);
        joinedUsers.add(userEvent);
    }

    public void removeUser(User user) {
        for (Iterator<UserEvent> iterator = joinedUsers.iterator();
             iterator.hasNext(); ) {
            UserEvent userEvent = iterator.next();

            if (userEvent.getEvent().equals(this) &&
                    userEvent.getUser().equals(user)) {
                iterator.remove();
                userEvent.setEvent(null);
                userEvent.setUser(null);
            }
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!date.equals(event.date)) return false;
        if (!owner.equals(event.owner)) return false;
        return location.equals(event.location);
    }

    @Override
    public int hashCode() {
        int result = date.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + location.hashCode();
        return result;
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

    public Integer getMaxPlayersNumber() {
        return maxPlayersNumber;
    }

    public void setMaxPlayersNumber(Integer maxPlayersNumber) {
        this.maxPlayersNumber = maxPlayersNumber;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public List<UserEvent> getJoinedUsers() {
        return joinedUsers;
    }

    public void setJoinedUsers(List<UserEvent> joinedUsers) {
        this.joinedUsers = joinedUsers;
    }
}
