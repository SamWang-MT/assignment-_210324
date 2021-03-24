package com.company.project.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class MockDbEntity {

    @JsonProperty
    private Settings settings;
    @JsonProperty
    private List<Jukebox> jukes;

    @JsonIgnore
    public List<JukeboxSetting> getJukeboxSettings() {
        return settings.getSettings();
    }
    

    
    
    
}
