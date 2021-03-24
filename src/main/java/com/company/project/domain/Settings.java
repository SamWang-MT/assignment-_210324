package com.company.project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Settings {
    @JsonProperty
    private List<JukeboxSetting> settings;
}
