def call(String url, String branch){
  echo "Cloning the github repo: ${url} with ${branch} branch"
  git url: "${url}", branch: "${branch}"
  echo "Code Cloning Successfully"
}
