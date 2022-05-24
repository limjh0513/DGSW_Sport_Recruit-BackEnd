package dgsw.hs.kr.dgsw_transfer.response;

import dgsw.hs.kr.dgsw_transfer.model.Apply;
import dgsw.hs.kr.dgsw_transfer.model.Post;

import java.sql.Timestamp;

public class MyAllApplyResponse {
    private int idx;
    private int state;
    private int postIdx;
    private int userIdx;
    private String title;
    private int personnel;
    private int currentPersonnel;
    private int postState;

    public MyAllApplyResponse(Apply it, Post p) {
        this.idx = it.getIdx();
        this.state = it.getState();
        this.postIdx = it.getPostIdx();
        this.userIdx = it.getUserIdx();
        this.title = p.getTitle();
        this.personnel = p.getPersonnel();
        this.currentPersonnel = p.getCurrentPersonnel();
        this.postState = p.getState();
    }
}
