package persistence.pojo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LineUpPerson", schema = "dbo", catalog = "Vereinsdatenbank")
@IdClass(LineUpPersonPOJOPK.class)
public class LineUpPersonPOJO {
    private int _personId;
    private int _teamId;
    private int _compId;
    private PersonPOJO _personByPersonId;
    private InternalTeamPOJO _internalTeamByTeamId;
    private CompetitionPOJO _competitionByCompId;

    @Id
    @Column(name = "personID")
    public int getPersonId() {
        return _personId;
    }

    public void setPersonId(int personId) {
        _personId = personId;
    }

    @Basic
    @Column(name = "teamID")
    public int getTeamId() {
        return _teamId;
    }

    public void setTeamId(int teamId) {
        _teamId = teamId;
    }

    @Id
    @Column(name = "compID")
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
        LineUpPersonPOJO that = (LineUpPersonPOJO) o;
        return _personId == that._personId &&
                _teamId == that._teamId &&
                _compId == that._compId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_personId, _teamId, _compId);
    }

    @ManyToOne
    @JoinColumn(name = "personID", referencedColumnName = "personID", nullable = false, updatable = false, insertable = false)
    public PersonPOJO getPersonByPersonId() {
        return _personByPersonId;
    }

    public void setPersonByPersonId(PersonPOJO personByPersonId) {
        _personByPersonId = personByPersonId;
    }

    @ManyToOne
    @JoinColumn(name = "teamID", referencedColumnName = "teamID", nullable = false, updatable = false, insertable = false)
    public InternalTeamPOJO getInternalTeamByTeamId() {
        return _internalTeamByTeamId;
    }

    public void setInternalTeamByTeamId(InternalTeamPOJO internalTeamByTeamId) {
        _internalTeamByTeamId = internalTeamByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "compID", referencedColumnName = "compID", nullable = false, updatable = false, insertable = false)
    public CompetitionPOJO getCompetitionByCompId() {
        return _competitionByCompId;
    }

    public void setCompetitionByCompId(CompetitionPOJO competitionByCompId) {
        _competitionByCompId = competitionByCompId;
    }
}
