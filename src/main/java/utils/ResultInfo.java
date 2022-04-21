package utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultInfo {

    private Boolean success;  //是否操作成功
    private String message;   //操作的结果信息
    private Object data;   //额外的数据

    // 一个参数构造
    public ResultInfo(Boolean success) {
        this.success = success;
    }

    // 二个参数构造
    public ResultInfo(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // 三个参数构造
    public ResultInfo(Boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
