package com.example.hackathon.listingdetailpage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.example.hackathon.listings.ItemListing.ItemListing;
import com.example.hackathon.listings.service.ListingPageService;

// import ch.qos.logback.core.model.Model;

@Controller
public class listingPageDetailController {
    // @GetMapping("/listingdetails")
    // public String pageListingDetail(Model model) {
    //     List<ItemListing> items = new ArrayList<>();
    //     items.add(new ItemListing((long) 283, "john@gmail.com", "canada", "toys", "extra toys for sale", "pickup", false));
    //     items.add(new ItemListing((long) 283, "john@gmail.com", "canada", "toys", "extra toys for sale", "pickup", false));
    //     items.add(new ItemListing((long) 283, "john@gmail.com", "canada", "toys", "extra toys for sale", "pickup", false));
    //     items.add(new ItemListing((long) 283, "john@gmail.com", "canada", "toys", "extra toys for sale", "pickup", false));
    //     model.addAttribute("items", items);
    //     return "listingDetails";
    // }
    @GetMapping("/listings/{id}")
    public ModelAndView getListingPageDetails(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/listings/listingDetails");
            // get instance of listing service
            ItemListing listing = ListingPageService.getInstance().getListingById(id);
            //search the listings service for the listing using the id
            modelAndView.addObject("item", listing);
            //add the listing object to the model and view
            return modelAndView;
    }
}
