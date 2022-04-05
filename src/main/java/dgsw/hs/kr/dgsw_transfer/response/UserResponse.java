package dgsw.hs.kr.dgsw_transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private int grade;
    private int room;
    private int number;
    private String name;
    private String profileImage;
}
