How the deployer works?
=======================

1. Root API - http://x.x.x.x:9000/
2. Redeploy API - http://x.x.x.x:9000/redeploy/{api-key}


 
 ------------
| deployer.sh | 1.Run Deployer
 ------------
      |  
      V
 -------------             3.HTTP POST                   ---------------------    2.git push origin master    o
| deployer.py | <-------------------------------------- | Github.com WebHooks | <--------------------------- /|\ 
 -------------                                           ---------------------                               / \
      |
      |
      V
  ---------          ----------         ----------------
 | stop.sh |  --->  | build.sh |  -->  | run-forever.sh |
  ---------          ----------         ----------------

                       
stop.sh 
--get the current running java process PID from /tmp/app.pid
--kill -9 {PID}

build.sh
--git pull
--mvn clean package

run-forever.sh
--nohup java -jar xxxxxxx
--save new PID in /tmp/app.pid

