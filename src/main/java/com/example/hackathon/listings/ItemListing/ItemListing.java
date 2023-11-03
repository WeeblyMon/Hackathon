package com.example.hackathon.listings.ItemListing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemListing {

    private long id;

    private String email;

    private String location;

    private String itemName;

    private String itemDescription;

    private String notesForTrade;

    private Boolean subscribe;

    public ItemListing(String email, String location, String itemName, String itemDescription, String notesForTrade,Boolean subscribe) {


        this.id = 0L;
        this.email = email;
        this.location = location;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.notesForTrade = notesForTrade;
        this.subscribe = subscribe;
    }

    public ItemListing(String string, String email2, String location2, String itemName2, String itemDescription2,
            String notesForTrade2, boolean subscribe2) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getNotesForTrade() {
        return notesForTrade;
    }


    public void setNotesForTrade(String notesForTrade) {
        this.notesForTrade = notesForTrade;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }
}
