pipeline {
    agent any

    environment {
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    tools {
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Prajapati-HitenCode/practice_maven.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t hitenprajapati1774/my_jenkins_repo:%IMAGE_TAG% .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat 'docker tag hitenprajapati1774/my_jenkins_repo:%IMAGE_TAG% %USERNAME%/my_jenkins_repo:%IMAGE_TAG%'
                    bat 'echo %PASSWORD% | docker login -u %USERNAME% --password-stdin'
                    bat 'docker push hitenprajapati1774/my_jenkins_repo:%IMAGE_TAG%'
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                sshagent(credentials: ['ssh-server-cred']) {
                    bat '''
                        ssh -o StrictHostKeyChecking=no user@172.28.144.1 ^
                        "docker pull hitenprajapati1774/my_jenkins_repo:%IMAGE_TAG% && ^
                        docker stop my_jenkins_repo || true && ^
                        docker rm my_jenkins_repo || true && ^
                        docker run -d --name my_jenkins_repo -p 8080:8080 hitenprajapati1774/my_jenkins_repo:%IMAGE_TAG%"
                    '''
                }
            }
        }
    }

    post {
        success {
            echo '🚀 CD Done: App deployed to server!'
        }
        failure {
            echo '❌ Deployment failed. Check the logs!!'
        }
    }
}
