package persistence.pojo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

public class RolePersonPOJOPK implements Serializable {
    private int _roleId;
    private int _personId;

    @Column(name = "roleID")
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public int getRoleId() {
        return _roleId;
    }

    public void setRoleId(int roleId) {
        _roleId = roleId;
    }

    @Column(name = "personID")
    @Id
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePersonPOJOPK that = (RolePersonPOJOPK) o;
        return _roleId == that._roleId &&
                _personId == that._personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_roleId, _personId);
    }
}
