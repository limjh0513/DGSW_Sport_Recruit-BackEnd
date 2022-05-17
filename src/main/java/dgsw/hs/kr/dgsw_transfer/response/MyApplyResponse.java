package dgsw.hs.kr.dgsw_transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MyApplyResponse {
    private int idx;
    private int state;

    public MyApplyResponse() {
        idx = -1;
        state = -1;
    }
}
