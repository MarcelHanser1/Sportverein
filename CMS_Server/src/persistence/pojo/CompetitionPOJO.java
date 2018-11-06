package persistence.pojo;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Competition", schema = "dbo", catalog = "Vereinsdatenbank")
@FetchProfile(name = "eager", fetchOverrides = {
        @FetchProfile.FetchOverride(entity = CompetitionPOJO.class, association = "setAllTeams", mode = FetchMode.JOIN)
})
public class CompetitionPOJO {

    private int _compId;
    private String _location;
    private Date _startDate;
    private Collection<CompetitionTeamPOJO> _competitionTeamsByCompId;
    private Collection<LineUpPersonPOJO> _lineUpPeopleByCompId;
    private Collection<TeamCompResultPOJO> _teamCompResultsByCompId;
    private List<TeamPOJO> _allteams;

    @Id
    // @GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "compID")
    public int getCompId() {
        return _compId;
    }

    public void setCompId(int compId) {
        _compId = compId;
    }

    @Basic
    @Column(name = "compName")
    public String getCompName() {
        return _compName;
    }

    public void setCompName(String compName) {
        _compName = compName;
    }



    @Basic
    @Column(name = "location")
    public String getLocation() {
        return _location;
    }

    public void setLocation(String location) {
        _location = location;
    }

    @Basic
    @Column(name = "startDate")
    public Date getStartDate() {
        return _startDate;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompetitionPOJO that = (CompetitionPOJO) o;
        return _compId == that._compId &&
                Objects.equals(_location, that._location) &&
                Objects.equals(_startDate, that._startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_compId, _location, _startDate);
    }

    @OneToMany(mappedBy = "competitionByCompId")
    public Collection<CompetitionTeamPOJO> getCompetitionTeamsByCompId() {
        return _competitionTeamsByCompId;
    }

    public void setCompetitionTeamsByCompId(Collection<CompetitionTeamPOJO> competitionTeamsByCompId) {
        _competitionTeamsByCompId = competitionTeamsByCompId;
    }

    @OneToMany(mappedBy = "competitionByCompId")
    public Collection<LineUpPersonPOJO> getLineUpPeopleByCompId() {
        return _lineUpPeopleByCompId;
    }

    public void setLineUpPeopleByCompId(Collection<LineUpPersonPOJO> lineUpPeopleByCompId) {
        _lineUpPeopleByCompId = lineUpPeopleByCompId;
    }

    @OneToMany(mappedBy = "competitionByCompId")
    public Collection<TeamCompResultPOJO> getTeamCompResultsByCompId() {
        return _teamCompResultsByCompId;
    }

    public void setTeamCompResultsByCompId(Collection<TeamCompResultPOJO> teamCompResultsByCompId) {
        _teamCompResultsByCompId = teamCompResultsByCompId;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "CompetitionTeam", joinColumns= {@JoinColumn(name="compID")},  inverseJoinColumns= {@JoinColumn(name="teamID")})
    public List<TeamPOJO> getAllteams() {
        return _allteams;
    }

    public void setAllteams(List<TeamPOJO> allteams) {
        _allteams = allteams;
    }

    private String _compName;
}
