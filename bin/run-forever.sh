echo "run-forever.sh:: Start running the app..."
nohup java -jar target/dropwizard-helloworld-0.0.1-SNAPSHOT.jar server config/dev_config.yml > /tmp/console.log 2>&1&
# save the PID in a temp file
echo $! > /tmp/app.pid
echo "run-forever.sh:: Successfully started the app"
