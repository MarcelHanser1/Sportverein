package rmi.servants;

import program.CompetitionHandler;
import rmi.dto.CompetitionDTO;
import rmi.dto.TeamDTO;
import rmi.interfaces.CompetitionRemotable;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CompetitionServant extends UnicastRemoteObject implements CompetitionRemotable, Serializable {

    private static final long serialVersionUID = 215648486;

    private CompetitionHandler _competitionHandler = new CompetitionHandler();

    protected CompetitionServant() throws RemoteException {
        super();
    }


    @Override
    public void addNewCompetition(CompetitionDTO competition) throws RemoteException {
        _competitionHandler.addNewCompetition(competition);
    }

    @Override
    public List<CompetitionDTO> getAllCompetitions() {
        return _competitionHandler.getAllCompetitions();
    }

    @Override
    public CompetitionDTO addTeamsToCompetitionDTO(CompetitionDTO competitionDTO) {
        return _competitionHandler.addTeamsToCompetitionDTO(competitionDTO);
    }

    @Override
    public List<TeamDTO> getTeamsfromCompetitionDto(CompetitionDTO competitionDTO) {
        return _competitionHandler.getTeamsfromCompetitionDto(competitionDTO);
    }

    @Override
    public void updateCompetition(CompetitionDTO competitionDTO) {
        _competitionHandler.updateCompetition(competitionDTO);
    }

    @Override
    public void insertCompetition(CompetitionDTO competitionDTO) {
        _competitionHandler.insertCompetition(competitionDTO);
    }

    @Override
    public void addTeam(CompetitionDTO competitionDTO) {
        _competitionHandler.addTeam(competitionDTO);
    }

    @Override
    public void deleteCompetition(CompetitionDTO competitionDTO) {
        _competitionHandler.deleteCompetition(competitionDTO);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return _competitionHandler.getAllTeams();
    }
}
