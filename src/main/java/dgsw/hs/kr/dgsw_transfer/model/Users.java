package dgsw.hs.kr.dgsw_transfer.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private int userIdx;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "password")
    private String pw;

    @Column(name = "grade")
    private int grade;

    @Column(name = "room")
    private int room;

    @Column(name = "number")
    private int number;

    @Column(name = "name")
    private String name;

    @Column(name = "profile_image")
    private String image;

    public Users(String id, String pw, int grade, int room, int number, String name, String image) {
        this.userId = id;
        this.pw = pw;
        this.grade = grade;
        this.room = room;
        this.number = number;
        this.name = name;
        this.image = image;
    }

    public Users(){}
}
