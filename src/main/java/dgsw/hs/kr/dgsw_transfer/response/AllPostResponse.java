package dgsw.hs.kr.dgsw_transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class AllPostResponse {
    private int idx;
    private String title;
    private String content;
    private int personal;
    private int currentPersonal;
    private String writter;
    private String writterImage;
    private Timestamp time;
    private int state;
    private int category;
    public AllPostResponse() {

    }
}
