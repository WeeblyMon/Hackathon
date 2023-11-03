package com.example.hackathon.communities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Community {
    private Long id;
    private String name;
    private String description;

    public Community(String name, String description){
        this.id = 0L;
        this.name = name;
        this.description = description;
    }

    public Community(){
        this.id = 0L;
        this.name = "";
        this.description = "";
    }
}
