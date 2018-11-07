package domain.classes;

import java.sql.Date;
import java.util.List;

public class Competition implements domain.interfaces.Icompetition {

    private int _compId;
    private String _compName;
    private String _location;
    private Date _startDate;
    private List<Team> _teamList;


    public String getCompName() {
        return _compName;
    }

    public void setCompName(String compName) {
        _compName = compName;
    }

    public List<Team> getTeamList() {
        return _teamList;
    }

    public void setTeamList(List<Team> teamList) {
        _teamList = teamList;
    }

    public Competition() {}

    public Competition(String location, Date startDate) {
        _location = location;
        _startDate = startDate;
    }

    @Override
    public String getLocation() { return  _location; }

    @Override
    public void setLocation(String location) { _location = location; }

    @Override
    public Date getStartDate() { return  _startDate; }

    @Override
    public void setStartDate(Date startDate) { _startDate = startDate; }

    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }
}
