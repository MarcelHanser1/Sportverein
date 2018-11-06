package persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class LineUpPersonPOJOPK implements Serializable {
    private int _personId;
    private int _compId;

    @Column(name = "personID")
    @Id
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Column(name = "compID")
    @Id
    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineUpPersonPOJOPK that = (LineUpPersonPOJOPK) o;
        return _personId == that._personId &&
                _compId == that._compId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_personId, _compId);
    }
}
