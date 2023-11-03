package com.example.hackathon.profile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileService {
    private HashMap<String, Profile> profiles;

    private static ProfileService singleton;

    public static ProfileService getInstance() {
        if (singleton == null) {
            singleton = new ProfileService();
        }
        return singleton;
    }
    public ProfileService(){

        profiles = new HashMap<String, Profile>();
        Profile admin = new Profile("admin@gmail.com", "admin");
        admin.setModerator();
        this.addProfile(admin);
    }

    public boolean profileExists(String email){
        if(profiles.containsKey(email)){
            return true;
        }
        return false;
    }

    public Long getProfileId(String email){
        if(profiles.containsKey(email)){
            return profiles.get(email).getId();
        }
        return null;
    }

    public Profile getProfileById(Long id) {
        return profiles.values()
                .stream()
                .filter(profile -> profile.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Profile getProfileByEmail(String email) {
        if(profiles.containsKey(email)){
            return profiles.get(email);
        }
        return null;
    }

    public void createProfile(String email, String username) {
        Long maxId = profiles.values()
                .stream()
                .mapToLong(Profile::getId)
                .max()
                .orElse(0L);
        maxId++;
        Profile newUser = new Profile(email, username);
        newUser.setId(maxId);
        profiles.put(email, newUser);
    }

    private void addProfile(Profile profile) {
        Long maxId = profiles.values()
                .stream()
                .mapToLong(Profile::getId)
                .max()
                .orElse(0L);
        maxId++;
        profile.setId(maxId);
        profiles.put(profile.getEmail(), profile);
    }

}
