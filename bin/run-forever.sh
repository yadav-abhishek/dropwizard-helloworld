echo "run-forever.sh:: Start running the app..."
nohup ./bin/run.sh 0<&- &> /tmp/app.log &
# save the PID in a temp file
echo $! > /tmp/app.pid
echo "run-forever.sh:: Successfully started the app"
