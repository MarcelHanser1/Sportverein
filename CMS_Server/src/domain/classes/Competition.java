package domain.classes;

import domain.interfaces.Icompetition;

import java.sql.Date;

public class Competition implements Icompetition {

    private String _location;
    private Date _startDate;

    public Competition() {

    }

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

}
