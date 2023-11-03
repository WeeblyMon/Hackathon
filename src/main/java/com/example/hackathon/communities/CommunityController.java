package com.example.hackathon.communities;

import com.example.hackathon.profile.Profile;
import com.example.hackathon.profile.ProfileService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommunityController {
    //get all communities
    @GetMapping("/communities")
    public ModelAndView getCommunitiesPage(){
        ModelAndView modelAndView = new ModelAndView("/communities/communitiesList");
        modelAndView.addObject("communities", CommunityService.getInstance().getCommunities());
        return modelAndView;
    }

    //get join community form
    @GetMapping("/communities/{id}/join")
    public ModelAndView getJoinCommunityForm(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/communities/joinCommunityForm");
        //get community by id, and add to modelAndView
        CommunityService communityService = CommunityService.getInstance();
        Community community = communityService.getCommunity(id);
        modelAndView.addObject("community", community);
        modelAndView.addObject("profile", new Profile());
        return modelAndView;
    }

    @PostMapping("/communities/{id}/join") //post join community form
    public ModelAndView postJoinCommunityForm(@PathVariable Long id, @Valid @ModelAttribute("profile") Profile profile, BindingResult bindingResult, Model model){
        ProfileService allProfiles = ProfileService.getInstance();
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/communities/joinCommunityForm", model.asMap());
            return modelAndView;
        } else if(!allProfiles.profileExists(profile.getEmail())){ //check and get user if user exists from email
            ModelAndView modelAndView = new ModelAndView("profile/profileDoesntExist");
            return modelAndView;
        } else  {
            //get community by id from url //set user community to community
            allProfiles.getProfileByEmail(profile.getEmail()).setCommunity(CommunityService.getInstance().getCommunity(id));
            ModelAndView modelAndView = new ModelAndView("communities/thanks");
            return modelAndView;
        }
    }



}
