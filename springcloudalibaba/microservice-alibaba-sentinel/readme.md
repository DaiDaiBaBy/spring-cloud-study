随着微服务的流行，服务和服务之间的稳定性变得越来越重要
Sentinel 以流量为切入点，从流量控制、熔断降级、系统负载保护等多个维度保护服务的稳定性

下载一个 sentinel-dashboard-1.8.1.jar
# 启动命令
java -Dserver.port=9191 -Dsentinel.dashboard.auth.username=sentinel -Dsentinel.dashboard.auth.password=sentinel -jar sentinel-dashboard-1.8.1.jar

# 监听端口
server.port=9191
# 设置控制台登录的用户名和密码
sentinel.dashboard.auth.username=sentinel
sentinel.dashboard.auth.password=sentinel

# 启动完sentinel控制台，说明已经成功部署，安装启动服务， 则可以开始接入应用服务

默认监控所有访问接口