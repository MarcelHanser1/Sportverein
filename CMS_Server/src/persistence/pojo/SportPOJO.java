package persistence.pojo;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Sport", schema = "dbo", catalog = "Vereinsdatenbank")
public class SportPOJO {
    private int _sportId;
    private String _sportName;
    private int _deptId;
    private DepartmentPOJO _departmentByDeptId;
    private Collection<TeamPOJO> _teamsBySportId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "sportID")
    public int getSportId() {
        return _sportId;
    }

    public void setSportId(int sportId) {
        _sportId = sportId;
    }

    @Basic
    @Column(name = "sportName")
    public String getSportName() {
        return _sportName;
    }

    public void setSportName(String sportName) {
        _sportName = sportName;
    }

    @Basic
    @Column(name = "deptID")
    public int getDeptId() {
        return _deptId;
    }

    public void setDeptId(int deptId) {
        _deptId = deptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportPOJO sportPOJO = (SportPOJO) o;
        return _sportId == sportPOJO._sportId &&
                _deptId == sportPOJO._deptId &&
                Objects.equals(_sportName, sportPOJO._sportName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_sportId, _sportName, _deptId);
    }

    @ManyToOne
    @JoinColumn(name = "deptID", referencedColumnName = "deptID", nullable = false, updatable = false, insertable = false)
    public DepartmentPOJO getDepartmentByDeptId() {
        return _departmentByDeptId;
    }

    public void setDepartmentByDeptId(DepartmentPOJO departmentByDeptId) {
        _departmentByDeptId = departmentByDeptId;
    }

    @OneToMany(mappedBy = "sportBySportId", fetch = FetchType.EAGER)
    public Collection<TeamPOJO> getTeamsBySportId() {
        return _teamsBySportId;
    }

    public void setTeamsBySportId(Collection<TeamPOJO> teamsBySportId) {
        _teamsBySportId = teamsBySportId;
    }
}
