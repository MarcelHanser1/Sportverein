package domain.classes;

public class Team {




    private int _teamID;
    private String _teamName;
    private Sport _Sport;
    private League _league;

    public Team() {

    }



    public Team (int teamID) {
        _teamID = teamID;
    }

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
        return _teamID;
    }

    public void setTeamID(int teamID) {
        _teamID = teamID;
    }
}
