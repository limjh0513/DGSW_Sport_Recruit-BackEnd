package dgsw.hs.kr.dgsw_transfer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    private String id;
    private String password;
    private int grade;
    private int room;
    private int number;
    private String name;
    private String profileImage;
}
