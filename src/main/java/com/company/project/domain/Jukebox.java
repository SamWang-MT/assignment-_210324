package com.company.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Jukebox {

	@JsonProperty
	private String id;
	@JsonProperty
	private String model;
	@JsonProperty
	private List<JukeboxComponent> components;

	/**
	 * a set of sets for components
	 */
	@JsonIgnore
	public Set<String> getComponentsNamesSet() {
		Set<String> rt = new HashSet<String>();
		for (JukeboxComponent component : components) {
			rt.add(component.getName());
		}
		return rt;
	}
}
