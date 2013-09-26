How Deployer works?

Deployer API - http://x.x.x.x:9000/redeploy/xxxx

 -------------              HTTP POST                      -----------------------
 | deployer.py | <---------------------------------------- | Github.com's WebHooks |
 -------------                                             -----------------------
      |
      |
      |
 -------------          ---------          ----------         ----------------
 | deployer.sh |  --->  | stop.sh |  --->  | build.sh |  -->  | run-forever.sh |
 -------------          ---------          ----------         ----------------

                       
- stop.sh 
---kill -9 {PID}

- build.sh
---git pull
---mvn clean package

- run-forever.sh
---nohup ./bin/run.sh

