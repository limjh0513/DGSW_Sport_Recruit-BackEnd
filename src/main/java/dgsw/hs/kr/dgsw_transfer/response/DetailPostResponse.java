package dgsw.hs.kr.dgsw_transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class DetailPostResponse {
    private int idx;
    private String title;
    private String content;
    private int personal;
    private int currentPersonal;
    private String writter;
    private String writterImage;
    private Timestamp time;
    private int category; // 카테고리
    private int state; // 긴급
    private int hidden; // 신청 목록 숨김

    public DetailPostResponse(){

    }
}
