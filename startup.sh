IMPULSE_PID=impulse_pid
# 启动admin
if [ -f "$IMPULSE_PID" ] && kill -0 $(cat "$IMPULSE_PID"); then
	echo "=========进程在运行。。。准备杀死"
	PID="$(cat "$IMPULSE_PID")"
	kill -9 $PID
	rm -rf "$IMPULSE_PID"
	echo "=========进程kill完成,准备启动==========="
fi
nohup java -jar -Xms200m -Xmx256m  impulse/target/impulse-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod>> logs/nohup.out 2>&1 & echo $! > $IMPULSE_PID
echo "=========启动完成========="
