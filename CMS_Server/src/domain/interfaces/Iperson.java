package domain.interfaces;

import java.sql.Date;

public interface Iperson {

    int getPersonId();

    void setPersonId(int personId);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    String getUserId();

    void setUserId(String userId);

    String getSocialSecurityNumber();

    void setSocialSecurityNumber(String socialSecurityNumber);
}
