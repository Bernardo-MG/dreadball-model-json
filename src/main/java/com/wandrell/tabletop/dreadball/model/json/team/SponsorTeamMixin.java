package com.wandrell.tabletop.dreadball.model.json.team;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wandrell.tabletop.dreadball.model.faction.Sponsor;
import com.wandrell.tabletop.dreadball.model.team.SponsorTeam;
import com.wandrell.tabletop.dreadball.model.unit.Unit;

@JsonAutoDetect(getterVisibility = JsonAutoDetect.Visibility.NONE,
        isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public interface SponsorTeamMixin extends SponsorTeam, TeamMixin<Unit> {

    @Override
    @JsonProperty("medibots")
    public Integer getMediBots();

    @Override
    @JsonProperty("sabotage_cards")
    public Integer getSabotageCards();

    @Override
    @JsonProperty("special_move_cards")
    public Integer getSpecialMoveCards();

    @Override
    @JsonProperty("sponsor")
    public Sponsor getSponsor();

    @Override
    @JsonProperty("wagers")
    public Integer getWagers();
    
}
