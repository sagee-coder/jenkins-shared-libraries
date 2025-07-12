def call(String dockerHubUser, String projectName, String imageTag){
  echo "This is building the code"
  sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} ."
}
