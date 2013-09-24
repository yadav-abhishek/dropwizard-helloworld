pid=`cat /tmp/app.pid`
echo "stop.sh::Killing PID $pid..."
kill -9 $pid
echo "stop.sh::Terminated PID $pid."


