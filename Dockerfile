#镜像出处
FROM java:8
#维护者信息
MAINTAINER baojieren
#在容器的根目录中创建springBoot-baojie文件夹
#RUN mkdir -p /springBoot-baojie
#将本地项目jar包拷贝到Docker容器中的位置
ADD target/baojie-web-0.0.1.jar app.jar
#将本地的可执行文件拷贝到Docker容器中的根目录下
#COPY ./cmd.sh /
#给cmd.sh赋予可执行权限
#RUN chmod +x /cmd.sh
#对外暴漏的端口号
EXPOSE 8080
#开机启动
ENTRYPOINT ["java","-jar","app.jar"]