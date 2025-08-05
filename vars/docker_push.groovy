def call(String ImageName, String ImageTag, String dockerHubUser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerHubUser}/${ImageName}:${ImageTag}"
}
