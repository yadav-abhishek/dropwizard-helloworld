nohup java -jar target/dropwizard-helloworld-0.0.1-SNAPSHOT.jar server config/dev_config.yml > /tmp/console.log 2>&1&
echo $! > /tmp/app.pid
 
