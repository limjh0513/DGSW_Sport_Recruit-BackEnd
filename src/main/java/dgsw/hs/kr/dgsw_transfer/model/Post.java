package dgsw.hs.kr.dgsw_transfer.model;

import dgsw.hs.kr.dgsw_transfer.request.WriteRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private int idx;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "personnel")
    private int personnel; // 인원 수

    @Column(name = "current_personnel")
    private int currentPersonnel; // 현재 인원 수

    @Column(name = "place")
    private String place;

    @Column(name = "writter")
    private int writter;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "category")
    private int category; // 카테고리

    @Column(name = "state")
    private int state; // 긴급, 종료

    @Column(name = "anonymous")
    private int anonymous; // 익명

    @Column(name = "hidden")
    private int hidden; // 신청 목록 숨김

    public Post(WriteRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.personnel = request.getPersonnel();
        this.currentPersonnel = 0;
        this.writter = request.getWritter();
        this.place = request.getPlace();
        this.time = Timestamp.valueOf(request.getTime() + ":00");
        this.category = request.getCategory();
        this.state = request.getState();
        this.anonymous = request.getAnonymous();
        this.hidden = request.getHidden();
    }
}
