package domain.interfaces;

import java.sql.Date;

public interface Icompetition {

    String getLocation();
    void setLocation(String location);

    Date getStartDate();
    void setStartDate(Date startDate);
}
