package dgsw.hs.kr.dgsw_transfer.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplyRequest {
    private int grade;
    private int room;
    private int number;
    private String name;
    private int postIdx;
    private int userIdx;
}
