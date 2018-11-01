package domain.classes;

public class Team {

    private int TeamID;
    private String _teamName;
    private Sport _Sport;
    private League _league;

    public String getTeamName() {
        return _teamName;
    }

    public void setTeamName(String teamName) {
        _teamName = teamName;
    }

    public Sport getSport() {
        return _Sport;
    }

    public void setSport(Sport sport) {
        _Sport = sport;
    }

    public League getLeague() {
        return _league;
    }

    public void setLeague(League league) {
        _league = league;
    }

    public int getTeamID() {
        return TeamID;
    }

    public void setTeamID(int teamID) {
        TeamID = teamID;
    }
}
