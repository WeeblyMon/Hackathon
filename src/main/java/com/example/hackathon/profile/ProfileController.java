package com.example.hackathon.profile;

import jakarta.validation.Valid;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    //get user create profile form
    @GetMapping("/profile/signup")
    public ModelAndView getCreateProfileForm(){
        ModelAndView modelAndView = new ModelAndView("profile/createProfileForm");
        modelAndView.addObject("profile", new Profile());
        return  modelAndView;
    }

    //post user create profile form
    @PostMapping("/profile/signup")
    public ModelAndView postCreateProfileForm(@Valid @ModelAttribute("profile") Profile profile, BindingResult bindingResult, Model model) {
        ProfileService profileService = ProfileService.getInstance();
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("/profile/createProfileForm", model.asMap());
            return modelAndView;
        } else if(profileService.profileExists(profile.getEmail())){ //check and get user if user exists from email
            ModelAndView modelAndView = new ModelAndView("profile/profileAlreadyExists");
            return modelAndView;
        } else  {
            profileService.createProfile(profile.getEmail(), profile.getUsername());
            ModelAndView modelAndView = new ModelAndView("profile/thanks");
            return modelAndView;
        }
    }

    //get user view profile form
    @GetMapping("/profile")
    public ModelAndView getViewProfileForm(){
        ModelAndView modelAndView = new ModelAndView("/profile/viewProfileForm");
        modelAndView.addObject("profile", new Profile());
        return modelAndView;
    }

    //post user view profile form
    @PostMapping("/profile")
    public ModelAndView postViewProfileForm(@Valid @ModelAttribute("profile") Profile profile, BindingResult bindingResult, Model model) {
        ProfileService profileService = ProfileService.getInstance();
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("profile/viewProfileForm", model.asMap());
            return modelAndView;
        } else if(!profileService.profileExists(profile.getEmail())){ //check and get user if user exists from email
            ModelAndView modelAndView = new ModelAndView("profile/profileDoesntExist");
            return modelAndView;
        } else  {
            ModelAndView modelAndView = new ModelAndView("profile/viewProfile");
            modelAndView.addObject("profile", profileService.getProfileByEmail(profile.getEmail()));
            return modelAndView;
        }
    }

    //get user view profile
    @GetMapping("/profile/{id}")
    public ModelAndView getProfile(@PathVariable Long id){
        ProfileService profileService = ProfileService.getInstance();
        ModelAndView modelAndView = new ModelAndView("profile/viewProfile");
        modelAndView.addObject("profile", profileService.getProfileById(id));
        return modelAndView;
    }
}
