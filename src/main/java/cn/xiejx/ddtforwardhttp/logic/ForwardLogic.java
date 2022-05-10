package cn.xiejx.ddtforwardhttp.logic;

import cn.xiejx.cacher.Cacher;
import cn.xiejx.cacher.CacherBuilder;
import cn.xiejx.ddtforwardhttp.util.tj.TjHttpUtil;
import cn.xiejx.ddtforwardhttp.util.tj.TjPredictDto;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * There is description
 *
 * @author sleepybear
 * @date 2022/05/10 10:31
 */
@Component
@Slf4j
public class ForwardLogic {
    public static final Random RANDOM = new Random();
    private static final String WAITING = "waiting";

    private Cacher<Integer, String> cacher;

    @PostConstruct
    public void init() {
        cacher = new CacherBuilder<Integer, String>().delay(30, TimeUnit.SECONDS).build();
    }

    public Integer submitPredict(TjPredictDto tjPredictDto) {
        int r = RANDOM.nextInt(100000);
        cacher.set(r, WAITING, 60 * 1000L);
        new Thread(() -> predict(tjPredictDto, r)).start();
        return r;
    }

    public void predict(TjPredictDto tjPredictDto, Integer r) {
        log.info("[{}] 接收到请求...", r);
        long begin = System.currentTimeMillis();
        String tjResponse = TjHttpUtil.getTjResponse(tjPredictDto);
        long end = System.currentTimeMillis();
        long timeCost = end - begin;
        log.info("[{}] 请求耗时：{} 毫秒，结果：{}", r, timeCost, tjResponse);
        cacher.set(r, tjResponse, 60 * 1000L);
    }

    public String getPredict(Integer id) {
        String s = cacher.get(id);
        if (s == null) {
            log.info("[{}] 没有识别结果", id);

        } else if (WAITING.equals(s)) {
            log.info("[{}] 还在识别中...", id);
        } else {
            log.info("[{}] 识别结果：{}", id, s);

        }
        return s;
    }
}
