package domain.classes;

import domain.interfaces.Iperson;

import java.sql.Date;

public class Person implements Iperson {
    private int _personId;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private String _userId;
    private String _socialSecurityNumber;


    @Override
    public int getPersonId() {
        return _personId;
    }

    @Override
    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Override
    public String getFirstName() {
        return _firstName;
    }

    @Override
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    @Override
    public String getLastName() {
        return _lastName;
    }

    @Override
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    @Override
    public Date getDateOfBirth() {
        return _dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        _dateOfBirth = dateOfBirth;
    }

    @Override
    public String getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(String userId) {
        _userId = userId;
    }

    @Override
    public String getSocialSecurityNumber() {
        return _socialSecurityNumber;
    }

    @Override
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        _socialSecurityNumber = socialSecurityNumber;
    }

}
