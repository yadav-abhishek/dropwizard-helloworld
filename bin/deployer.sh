echo "deployer.sh::Start running deployer..."
nohup python bin/deployer.py $1 ./bin/stop.sh ./bin/build.sh ./bin/run-forever.sh > /tmp/deployer.log 2>&1&
echo "deployer.sh::Finished" 
