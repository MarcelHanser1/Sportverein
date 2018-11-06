package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "League", schema = "dbo", catalog = "Vereinsdatenbank")
public class LeaguePOJO {
    private int _leagueId;
    private String _leagueName;
    private Collection<TeamPOJO> _teamsByLeagueId;

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "leagueID")
    public int getLeagueId() {
        return _leagueId;
    }

    public void setLeagueId(int leagueId) {
        _leagueId = leagueId;
    }

    @Basic
    @Column(name = "leagueName")
    public String getLeagueName() {
        return _leagueName;
    }

    public void setLeagueName(String leagueName) {
        _leagueName = leagueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeaguePOJO that = (LeaguePOJO) o;
        return _leagueId == that._leagueId &&
                Objects.equals(_leagueName, that._leagueName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_leagueId, _leagueName);
    }

    @OneToMany(mappedBy = "leagueByLeagueId")
    public Collection<TeamPOJO> getTeamsByLeagueId() {
        return _teamsByLeagueId;
    }

    public void setTeamsByLeagueId(Collection<TeamPOJO> teamsByLeagueId) {
        _teamsByLeagueId = teamsByLeagueId;
    }
}
