pid=`cat /tmp/app.pid`
echo "Killing PID $pid..."
kill -9 $pid
echo "Terminated PID $pid."


