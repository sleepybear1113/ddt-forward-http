package cn.xiejx.ddtforwardhttp.controller;

import cn.xiejx.ddtforwardhttp.logic.ForwardLogic;
import cn.xiejx.ddtforwardhttp.util.http.HttpHelper;
import cn.xiejx.ddtforwardhttp.util.http.HttpRequestMaker;
import cn.xiejx.ddtforwardhttp.util.http.HttpResponseHelper;
import cn.xiejx.ddtforwardhttp.util.tj.TjHttpUtil;
import cn.xiejx.ddtforwardhttp.util.tj.TjPredictDto;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/05/10 09:40
 */
@RestController
@Slf4j
public class ForwardController {
    @Resource
    private ForwardLogic forwardLogic;

    @RequestMapping("/ddt/predict")
    public Integer submitPredict(HttpServletRequest request,
                    @RequestParam("username") String username,
                    @RequestParam("password") String password,
                    @RequestParam("typeid") String typeId,
                    @RequestParam("typename") String typeName,
                    @RequestParam("softid") String softId,
                    @RequestParam("image") String imgBase64) {
        TjPredictDto tjPredictDto = new TjPredictDto(username, password, typeId, typeName, softId, imgBase64);
        return forwardLogic.submitPredict(tjPredictDto);
    }

    @RequestMapping("/ddt/getPredict")
    public String getPredict(Integer id) {
        return forwardLogic.getPredict(id);
    }
}
