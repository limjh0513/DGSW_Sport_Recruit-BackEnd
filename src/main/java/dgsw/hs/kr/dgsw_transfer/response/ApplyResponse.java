package dgsw.hs.kr.dgsw_transfer.response;

import dgsw.hs.kr.dgsw_transfer.model.Apply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class ApplyResponse {
    private int idx;
    private int grade;
    private int room;
    private int number;
    private String name;
    private Timestamp time;
    private int state;
    private int postIdx;
    private int userIdx;

    public ApplyResponse(Apply it) {
        this.idx = it.getIdx();
        this.grade = it.getGrade();
        this.room = it.getRoom();
        this.number = it.getNumber();
        this.name = it.getName();
        this.time = it.getApplyTime();
        this.state = it.getState();
        this.postIdx = it.getPostIdx();
        this.userIdx = it.getUserIdx();
    }
}
