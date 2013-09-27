How the deployer works?
=======================

1. Root API - http://x.x.x.x:9000/
2. Redeploy API - http://x.x.x.x:9000/redeploy/{api-key}


 -------------              HTTP POST                      ---------------------    git push origin master    o
| deployer.py | <---------------------------------------- | Github.com WebHooks | <------------------------- /|\ 
 -------------                                             ---------------------                             / \
      |
      |
      V
  -------------          ---------          ----------         ----------------
 | deployer.sh |  --->  | stop.sh |  --->  | build.sh |  -->  | run-forever.sh |
  -------------          ---------          ----------         ----------------

                       
stop.sh 
--kill -9 {PID}

build.sh
--git pull
--mvn clean package

run-forever.sh
--nohup java -jar 

