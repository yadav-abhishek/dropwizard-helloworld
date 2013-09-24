echo "build.sh::Pulling the lastest commit from Github..."

git pull

echo "build.sh::Running Maven build now..."

mvn clean package

echo "build.sh::A new jar is now ready to deploy."

