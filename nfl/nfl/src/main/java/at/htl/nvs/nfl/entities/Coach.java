package at.htl.nvs.nfl.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "COACH")
@NamedQueries({
        @NamedQuery(name = "Coach.delete", query = "delete from Coach c where c.coachId = :Id"),
        @NamedQuery(name = "Coach.getById", query = "select c from Coach c where c.coachId = :id"),
        @NamedQuery(name = "Coach.getAll", query = "select c from Coach c")
})
public class Coach implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COACH_ID")
    private Long coachId;

    @Column(name = "COACH_NAME")
    private String coachName;

    @Column(name = "POSITION")
    private String position;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID_FK")
    private Team team;

    //region Constructors
    public Coach(String coachName, String position, Team team) {
        this.setCoachName(coachName);
        this.setPosition(position);
        this.setTeam(team);
    }

    public Coach() {

    }
    //endregion

    //region Getter Setter
    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
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

    public void setTeam(Team teamIdFk) {
        this.team = teamIdFk;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }
    //endregion
}