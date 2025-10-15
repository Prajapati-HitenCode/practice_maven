pipeline {
    agent any

    stages {
        stage('Test SSH Connection') {
            steps {
                sshagent(['ssh-server-cred']) {
                    bat 'ssh -v -o StrictHostKeyChecking=no user@172.28.144.1 echo ok'
                }
            }
        }
    }
}
