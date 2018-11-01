package domain.classes;

public class Sport {
    public String getSportName() {
        return _sportName;
    }

    public void setSportName(String sportName) {
        _sportName = sportName;
    }

    public int getSportId() {
        return _sportId;
    }

    public void setSportId(int sportId) {
        _sportId = sportId;
    }

    private int _sportId;
    private String _sportName;
    private int _deptId;


}
