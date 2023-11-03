package com.example.hackathon.communities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CommunityService {
    private List<Community> communities;

    private static CommunityService singleton;

    public static CommunityService getInstance() {
        if (singleton == null) {
            singleton = new CommunityService();
        }
        return singleton;
    }
    public CommunityService(){
        communities = new ArrayList<Community>();
        this.addCommunity(new Community("Cardiff", "Home to Cardiff University and Cardiff Castle"));
        this.addCommunity(new Community("Newport", "Connected to the Prince of Wales bridge"));
        this.addCommunity(new Community("Swansea", "Home to James"));
    }

    public List<Community> getAllCommunities(){
        return communities;
    }

    public Community getCommunity(Long id) {
        return communities
                .stream()
                .filter(community -> community.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addCommunity(Community community) {
        Long maxId = communities
                .stream()
                .mapToLong(Community::getId)
                .max()
                .orElse(0L);
        maxId++;
        community.setId(maxId);
        communities.add(community);
    }
}


