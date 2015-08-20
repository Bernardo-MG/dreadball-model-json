package com.wandrell.tabletop.dreadball.model.json.team;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.team.Team;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface TeamMixin<U extends Unit> extends Team<U> {

    @Override
    @JsonProperty("cheerleaders")
    public Integer getCheerleaders();
    @Override
    @JsonProperty("dice")
    public Integer getDice();
    @Override
    @JsonProperty("players")
    public Map<Integer, U> getPlayers();
    @Override
    @JsonProperty("valoration")
    public Integer getValoration();

}
