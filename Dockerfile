FROM kdvolder/jdk8:latest
ARG JAR_FILE
ENV TZ=Asia/Shanghai
ENV LANG C.UTF-8
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /data/
ENV JAVA_OPTS="\
-server \
-Xmx1024m \
-Xms500m \
-XX:+UseParallelGC \
-XX:ParallelGCThreads=4 \
-XX:+UseParallelOldGC \
-XX:+UseAdaptiveSizePolicy \
-XX:+PrintGCDetails \
-XX:+PrintTenuringDistribution \
-XX:+PrintGCTimeStamps \
-XX:+HeapDumpOnOutOfMemoryError \
-XX:HeapDumpPath=/ \
-Xloggc:/data/logs/gc.log \
-XX:+UseGCLogFileRotation \
-XX:NumberOfGCLogFiles=5 \
-XX:GCLogFileSize=10M"


ADD target/${JAR_FILE} /${JAR_FILE}

EXPOSE 9900

RUN echo "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -Dlog4j2.formatMsgNoLookups=true -Dspring.profiles.active=uat -Dfile.encoding=utf-8 -jar /api-gate-way.jar" > start.sh && chmod 777 start.sh

CMD ./start.sh

