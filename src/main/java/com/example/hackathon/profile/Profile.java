package com.example.hackathon.profile;

import com.example.hackathon.communities.Community;
import com.example.hackathon.listings.ItemListing.ItemListing;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Profile {
    private Long id;
    @NotEmpty(message = "Email is required") private String email;
    @NotEmpty(message = "Username is required") private String username;
    private List<ItemListing> listings;
    private Community community;
//    private List<Event> events;
//
//    private List<ListingTradeRequest> requests;

    private boolean moderator;

    public void addListing(ItemListing listing){
        this.listings.add(listing);
    }
//    public void addEvent(Event event) {this.events.add(event);}

    public void setCommunity(Community community){this.community = community;}
//
//    public ListingTradeRequest getRequest(Long id) {
//        return requests
//                .stream()
//                .filter(request -> request.getId().equals(id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public void removeRequest(ListingTradeRequest request) {
//        requests.remove(request);
//    }
//
//    public void addRequest(ListingTradeRequest request) {
//        Long maxId = requests
//                .stream()
//                .mapToLong(ListingTradeRequest::getId)
//                .max()
//                .orElse(0L);
//        maxId++;
//        request.setId(maxId);
//        requests.add(request);
//    }
    public Profile(){
        this.moderator = false;
        this.id = 0L;
        this.username = "";
        this.email = "";
        this.community = new Community();
    }
    public Profile(String email, String username) {
        this.moderator = false;
        this.id = 0L;
        this.username = username;
        this.email = email;
        this.listings = new ArrayList<>();
//        this.events = new ArrayList<>();
        this.community = new Community();
    }
    public void setModerator(){
        if(!moderator) {
            this.moderator = true;
        }
    }
}
