package com.example.hackathon.listings.service;

import com.example.hackathon.listings.ItemListing.ItemListing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.example.hackathon.profile.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;


@Data
@AllArgsConstructor
public class ListingPageService {

    private List<ItemListing> listings;

    private static ListingPageService singleton;

    public static ListingPageService getInstance(){
        if(singleton == null){
            singleton = new ListingPageService();
        }
        return singleton;
    }

    public ListingPageService() {
        this.listings = new ArrayList<>();
        this.addListing(new ItemListing("marley@gmail.com", "Cardiff", "Toy Tooth", "Are you looking for a fun and educational way to teach your little ones about the importance of oral hygiene? Look no further than the SmileGuard™ Tooth Buddy – the toothbrushing companion that will make dental care an adventure!", "looking for t-shirt",
                false));
        this.addListing(new ItemListing("mary@gmail.com", "Cardiff", "Acid Gun", "I am willing to offer my Acid Gun in exchange for your Acid Blaster X-2000. My Acid Gun is a similarly entertaining toy that shoots colorful, harmless \"acid\" balls and provides hours of amusement. I believe that by swapping these items, we can both enjoy a change of pace and have fun exploring each other's toys.", "I baby clothes want, girl clothes pink i like",
                false));
        this.addListing(new ItemListing("ley@gmail.com", "Cardiff", "Superman Shirt", "Look no further than the Superman Baby Shirt – the perfect way to ignite your little one's imagination and set them on a path to heroism from the very beginning! ", "Looking for Acid Blaster 9000",
                false));
    }

    public List<ItemListing> getListings() {
        
        return listings;
    }

    public ItemListing getListingById(Long id) {
        return listings
                .stream()
                .filter(listing -> listing.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

//    public void addListing(ItemListing itemListing){
//        this.listings.add(itemListing);
//    }

    public void addListing(ItemListing itemListing) {
        Long maxId = listings
                .stream()
                .mapToLong(ItemListing::getId)
                .max()
                .orElse(0L);
        maxId++;
        itemListing.setId(maxId);
        this.listings.add(itemListing);
    }

}
