package com.techelevator.model;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Event {
    int id;
    String eventName;
    int breweryId;
    String breweryName;
    LocalDate eventDate;
    Time begins;
    Time ends;
    String desc;
    boolean is21Up;
    List<Category> categories;

    public Event() {}

    public Event(int id, String eventName, int breweryId, String breweryName, LocalDate eventDate, Time begins, Time ends, String desc, boolean is21Up, List<Category> categories) {
        this.id = id;
        this.eventName = eventName;
        this.breweryId = breweryId;
        this.breweryName = breweryName;
        this.eventDate = eventDate;
        this.begins = begins;
        this.ends = ends;
        this.desc = desc;
        this.is21Up = is21Up;
        this.categories = categories;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBreweryId() {
        return breweryId;
    }

    public void setBreweryId(int breweryId) {
        this.breweryId = breweryId;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Time getBegins() {
        return begins;
    }

    public void setBegins(Time begins) {
        this.begins = begins;
    }

    public Time getEnds() {
        return ends;
    }

    public void setEnds(Time ends) {
        this.ends = ends;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isIs21Up() {
        return is21Up;
    }

    public void setIs21Up(boolean is21Up) {
        this.is21Up = is21Up;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public void addCategory(Category category) {
        this.categories.add(category);
    }
}
