package com.sportclusters.sportclusters.entity;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;


@Entity
@Table(name = "LOCATION")
public class Location {

    @Id
//    @Column(name = "ID")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_seq")
//    @SequenceGenerator(name = "location_seq", sequenceName = "location_seq", allocationSize = 1)

    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "ID", columnDefinition = "CHAR(32)")
    private UUID id;

    @Column(name = "LATITUDE")
    @NotNull
    private Float latitude;


    @Column(name = "LONGITUDE")
    @NotNull
    private Float longitude;


    @Column(name = "NAME")
    private String name;


    @OneToMany(mappedBy = "location")
    protected Set<Event> events = new HashSet<>();


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Location)){
            return false;
        }

        Location other = (Location)obj;

        if(this.getLatitude() == null || this.getLongitude() == null ||
                other.getLatitude() == null || other.getLongitude() == null){
            return false;
        }

        if(this.getLatitude().equals(other.getLatitude()) &&
                this.getLongitude().equals(other.getLongitude())){
            return true;
        }

        return false;

    }


    @Override
    public int hashCode() {
        String str = this.getLatitude().toString()+this.getLongitude().toString();
        return str.hashCode();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }


}
