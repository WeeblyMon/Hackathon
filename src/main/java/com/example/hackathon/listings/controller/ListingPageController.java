package com.example.hackathon.listings.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.hackathon.listings.ItemListing.ItemListing;
import com.example.hackathon.listings.service.ListingPageService;
@Controller
class ListingPageController {
    @GetMapping(value = { "/listing", "/listings" })
    public ModelAndView showListPage() {
        ModelAndView modelAndView = new ModelAndView("listings/listings");
        List<ItemListing> listings = ListingPageService.getInstance().getListings();
        modelAndView.addObject("listings", listings);
        return modelAndView;
    }
//
//    @RequestMapping("/add")
//    public ModelAndView addListing() {
//        ModelAndView mav = new ModelAndView("")
//    }

//    @GetMapping("/listings")
//    public ModelAndView getListings() {
//        ModelAndView mvc = new ModelAndView("listings");
//        List<ItemListing> itemListings = formService.getItemListings();
//        mvc.addObject("listings", itemListings);
//        return mvc;
//    }
}
