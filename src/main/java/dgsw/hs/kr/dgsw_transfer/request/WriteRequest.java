package dgsw.hs.kr.dgsw_transfer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class WriteRequest {
    private String title;
    private String content;
    private int personnel;
    private String place;
    private int writter;
    private Timestamp time;
    private int category;
    private int state;
    private int anonymous;
    private int hidden;
}
