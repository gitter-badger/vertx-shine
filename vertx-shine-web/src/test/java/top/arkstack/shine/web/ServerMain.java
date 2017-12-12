package top.arkstack.shine.web;

import io.vertx.core.Vertx;
import top.arkstack.shine.web.verticle.RouterHandlerFactory;
import top.arkstack.shine.web.verticle.VerticleLauncher;
import top.arkstack.shine.web.vertx.DeployVertxServer;

import java.io.IOException;

/**
 * test 入口
 *
 * @author 7le
 * @since v1.0.0
 */
public class ServerMain {

    public static void main(String[] args) {
        //开启集群 如果不需要集群 就注释掉这句代码
        VerticleLauncher.isCluster = true;
        VerticleLauncher.getStandardVertx(Vertx.vertx(), v -> {
            try {
                DeployVertxServer.startDeploy(new RouterHandlerFactory("top.arkstack.shine.web", "shine")
                        .createRouter(), "top.arkstack.shine.web", 7777);
            } catch (IOException e) {
                System.out.println("启动失败: " + e.getMessage());
            }
        });
    }
}