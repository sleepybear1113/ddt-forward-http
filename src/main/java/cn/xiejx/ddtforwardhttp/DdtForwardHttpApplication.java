package cn.xiejx.ddtforwardhttp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * @author sleepybear
 */
@SpringBootApplication
@Slf4j
public class DdtForwardHttpApplication {

    public static void main(String[] args) {
        System.out.println("Java Spring Boot 项目开始启动，请稍后...");
        ConfigurableApplicationContext context = SpringApplication.run(DdtForwardHttpApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        System.out.println("如果你会使用 Java，可以在当前文件夹下找到 jar 包，该应用由这个 jar 包打包成 exe。你也可以直接使用 java -jar ddt.jar 来直接运行，需要使用 java 17。");
        System.out.println("该项目代码极为简单，可以在 GitHub 上找到源代码：https://github.com/sleepybear1113/ddt-forward-http");
        System.out.println("该程序完全免费。");
        System.out.println("==================================================");
        System.out.println("该程序的路径结构如下：app 路径下是项目 exe 启动才需要的配置文件");
        System.out.println("app 路径下是项目 exe 启动才需要的配置文件。");
        System.out.println("runtime 目录下是 Java 17 所需的运行环境。你也可以下载 Java 17 相关 JDK 覆盖。");
        System.out.println("ddt.jar 则是主项目文件，由 Java 工程打包。");
        System.out.println("logs 是项目的日志输出文件夹。");
        System.out.println("exe 文件则是启动 ddt.jar 的入口。");
        System.out.println("==================================================");
        System.out.println("如果这个对你有帮助，那么可以请我吃个冰棍，喝个可乐，喝杯奶茶");
        System.out.printf("微信：http://127.0.0.1:%s/images/wx.jpg%n", environment.getProperty("server.port"));
        System.out.printf("支付宝：http://127.0.0.1:%s/images/zfb.jpg%n", environment.getProperty("server.port"));
        System.out.println("==================================================");
        System.out.println("项目启动完成，请保持持续运行。若要停止可以直接关闭窗口或者使用 Ctrl + C 发送中止指令。");
    }

}
