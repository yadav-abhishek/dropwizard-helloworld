echo "Pulling lastest commits from Github..."

git pull

echo "Building the app now..."

mvn clean package

echo "Ready to deploy new jar"

