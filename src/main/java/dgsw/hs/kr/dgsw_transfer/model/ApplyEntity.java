package dgsw.hs.kr.dgsw_transfer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "apply")
public class ApplyEntity {
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

    @Column(name = "applyTime")
    private Timestamp applyTime;

    @Column(name = "state")
    private int state;

    @Column(name = "postIdx")
    private int postIdx;
}
