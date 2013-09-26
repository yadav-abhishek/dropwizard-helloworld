echo "run-forever.sh:: Start running the app..."
nohup ./bin/run.sh 0<&- &> /tmp/app.log &
echo "run-forever.sh:: Successfully started the app"
