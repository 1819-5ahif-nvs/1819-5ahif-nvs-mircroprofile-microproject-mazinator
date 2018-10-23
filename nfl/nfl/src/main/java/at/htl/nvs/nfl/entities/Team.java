package at.htl.nvs.nfl.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TEAM")
@NamedQueries({
        @NamedQuery(name = "Team.delete", query = "delete from Team t where t.teamId = :id"),
        @NamedQuery(name = "Team.getByName", query = "select t from Team t where t.teamName = :name"),
        @NamedQuery(name = "Team.getById", query = "select t from Team t where t.teamId = :id"),
        @NamedQuery(name = "Team.getAll", query = "select t from Team t")
})
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "TEAM_NAME")
    private String teamName;

    @Column(name = "WINS")
    private int wins;

    @Column(name = "LOSSES")
    private int losses;

    //region Constructors
    public Team(String teamName, int wins, int losses) {
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
    }

    public Team() {

    }
    //endregion

    //region Getter Setter
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public Long getTeamId() {
        return teamId;
    }
    //endregion
}
