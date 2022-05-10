package cn.xiejx.ddtforwardhttp.util.tj;

import cn.xiejx.ddtforwardhttp.util.http.HttpHelper;
import cn.xiejx.ddtforwardhttp.util.http.HttpRequestMaker;
import cn.xiejx.ddtforwardhttp.util.http.HttpResponseHelper;
import org.apache.http.client.config.RequestConfig;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/05/10 10:25
 */
public class TjHttpUtil {
    private static final String TJ_PREDICT_URL = "http://api.ttshitu.com/predict";

    public static String getTjResponse(TjPredictDto tjPredictDto) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setConnectTimeout(1000 * 5)
                .setSocketTimeout(1000 * 30)
                .build();

        HttpRequestMaker requestMaker = HttpRequestMaker.makePostHttpHelper(TJ_PREDICT_URL);
        requestMaker.setConfig(requestConfig);

        HttpHelper httpHelper = new HttpHelper(requestMaker);

        httpHelper.setUrlEncodedFormPostBody(tjPredictDto.buildPair());
        HttpResponseHelper responseHelper = httpHelper.request();
        return responseHelper.getResponseBody();
    }
}
