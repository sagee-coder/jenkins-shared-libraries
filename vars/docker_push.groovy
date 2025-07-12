def call(String dockerHubUser, String projectName, String imageTag) {
    echo 'This is pushing the image to Docker Hub'
    withCredentials([
        usernamePassword(
            credentialsId:'DockerHubCred',
            passwordVariable: 'dockerHubPass',
            usernameVariable: 'dockerHubUser'
        )
    ]){
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker image tag ${projectName}:${imageTag} ${dockerHubUser}/${projectName}:${imageTag}"
        sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
    }
}
