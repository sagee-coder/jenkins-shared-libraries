def call(String projectName, String imageTag) {
    echo 'This is pushing the image to Docker Hub'
    withCredentials([
        usernamePassword(
            credentialsId:'DockerHubCred',
            passwordVariable: 'dockerHubPass',
            usernameVariable: 'dockerHubUser'
        )
    ]){
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker push ${env.dockerHubUser}/${projectName}:${imageTag}"
    }
}
