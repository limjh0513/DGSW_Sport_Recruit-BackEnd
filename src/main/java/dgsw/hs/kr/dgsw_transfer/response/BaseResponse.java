package dgsw.hs.kr.dgsw_transfer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseResponse<T> {
    private int code;
    private String message;
    private T data;
}