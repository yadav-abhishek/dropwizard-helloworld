echo "run.sh::Running the app"
java -jar target/dropwizard-helloworld-0.0.1-SNAPSHOT.jar server config/dev_config.yml
# save the PID in a temp file
echo $! > /tmp/app.pid
pid=$!
echo "run.sh::The app PID is $pid"   
