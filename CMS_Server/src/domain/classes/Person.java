package domain.classes;

import domain.interfaces.Iperson;

import java.sql.Date;

public class Person implements Iperson {

    private int personID;
    private String _firstName;
    private String _lastName;
    private Date _dateOfBirth;
    private String _userId;
    private String _socialSecurityNumber;

//    public Collection<InternalTeamPOJO> getInternalTeamsByPersonId() {
//        return _internalTeamsByPersonId;
//    }
//
//    public void setInternalTeamsByPersonId(Collection<InternalTeamPOJO> internalTeamsByPersonId) {
//        _internalTeamsByPersonId = internalTeamsByPersonId;
//    }
//
//    private Collection<InternalTeamPOJO> _internalTeamsByPersonId;


    public Person() { }

    public Person(String firstName, String lastName, Date dateOfBirth, String userId, String socialSecurityNumber) {
        _firstName = firstName;
        _lastName = lastName;
        _dateOfBirth = dateOfBirth;
        _userId = userId;
        _socialSecurityNumber = socialSecurityNumber;
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

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
