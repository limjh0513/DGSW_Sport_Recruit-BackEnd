package dgsw.hs.kr.dgsw_transfer.model;

import dgsw.hs.kr.dgsw_transfer.request.ApplyRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "apply")
public class Apply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "grade")
    private int grade;

    @Column(name = "room")
    private int room;

    @Column(name = "number")
    private int number;

    @Column(name = "name")
    private String name;

    @Column(name = "apply_time")
    private Timestamp applyTime;

    @Column(name = "state")
    private int state;

    @Column(name = "postIdx")
    private int postIdx;

    @Column(name = "userIdx")
    private int userIdx;

    public Apply(ApplyRequest it) {
        this.grade = it.getGrade();
        this.room = it.getRoom();
        this.number = it.getNumber();
        this.name = it.getName();
        this.applyTime = Timestamp.valueOf(LocalDateTime.now());
        this.state = 0;
        this.postIdx = it.getPostIdx();
        this.userIdx = it.getUserIdx();
    }
}
