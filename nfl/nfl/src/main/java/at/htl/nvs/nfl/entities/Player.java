package at.htl.nvs.nfl.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "PLAYER")
@NamedQueries({
        @NamedQuery(name = "Player.delete", query = "delete from Player p where p.playerId = :id"),
        @NamedQuery(name = "Player.getById", query = "select p from Player p where p.playerId = :id"),
        @NamedQuery(name = "Player.getAll", query = "select p from Player p"),
        @NamedQuery(name = "Player.getFromTeam", query = "select p from Player p where p.team.teamId = :id")
})
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAYER_ID")
    private Long playerId;

    @Column(name = "PLAYER_NAME")
    private String playerName;

    @Column(name = "PLAYER_POSITION")
    private String position;

    @Column(name = "ENTER_DATE")
    private Date enterDate;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID_FK")
    private Team team;

    //region Constructor
    public Player(String playerName, Team team) {
        this.setPlayerName(playerName);
        this.setTeam(team);
    }

    public Player() {

    }
    //endregion

    //region Getter Setter
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
    //endregion
}
