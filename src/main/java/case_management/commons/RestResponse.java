package case_management.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestResponse {
    private int status;
    private Object data;
    private String message;

    public RestResponse(HttpStatus status, Object data, String message) {
        this.status = status.value();
        this.data = data;
        this.message = message;
    }

    public static RestResponse success(Object data) {
        return new RestResponse(HttpStatus.OK,data,"");
    }

    public static RestResponse error(String message) {
        return new RestResponse(HttpStatus.OK,null,message);
    }
}
