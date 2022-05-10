package cn.xiejx.ddtforwardhttp.util.tj;

import lombok.Data;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/05/10 09:55
 */
@Data
public class TjPredictDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 4340261310989122096L;
    private String username;
    private String password;
    private String typeId;
    private String typeName;
    private String softId;
    private String imgBase64;

    public TjPredictDto() {
    }

    public TjPredictDto(String username, String password, String typeId, String typeName, String softId, String imgBase64) {
        this.username = username;
        this.password = password;
        this.typeId = typeId;
        this.typeName = typeName;
        this.softId = softId;
        this.imgBase64 = imgBase64;
    }

    public List<NameValuePair> buildPair() {
        ArrayList<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("username", this.username));
        pairs.add(new BasicNameValuePair("password", this.password));
        pairs.add(new BasicNameValuePair("typeid", this.typeId));
        pairs.add(new BasicNameValuePair("typename", this.typeName));
        pairs.add(new BasicNameValuePair("softid", this.softId));
        pairs.add(new BasicNameValuePair("image", this.imgBase64));
        return pairs;
    }
}
