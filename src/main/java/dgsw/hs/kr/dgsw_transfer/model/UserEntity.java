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
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userIdx")
    private int userIdx;

    @Column(name = "userId")
    private String id;

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

    @Column(name = "profileImage")
    private String image;

    public UserEntity(String id, String pw, int grade, int room, int number, String name, String image) {
        this.id = id;
        this.pw = pw;
        this.grade = grade;
        this.room = room;
        this.number = number;
        this.name = name;
        this.image = image;
    }
}
