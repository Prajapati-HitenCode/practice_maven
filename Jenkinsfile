pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-cred')
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
                bat 'docker build -t myapp:latest .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-cred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
                    bat 'echo $PASSWORD | docker login -u $USERNAME --password-stdin'
                    bat 'docker tag hitenprajapati1774/my_jenkins_repo:latest'
                    bat 'docker push hitenprajapati1774/my_jenkins_repo:latest'
                }
            }
        }

        stage('Deploy to Server') {
            steps {
                sshagent(credentials: ['ssh-server-cred']) {
                    bat 'ssh -o StrictHostKeyChecking=no user@server "docker pullhitenprajapati1774/my_jenkins_repo:latest && docker stop my_jenkins_repo || true && docker rm my_jenkins_repo || true && docker run -d --name my_jenkins_repo -p 8080:8080 hitenprajapati1774/my_jenkins_repo:latest"'
                }
            }
        }
    }
    echo "your-access-token" | docker login -u your-username --password-stdin
    post {
        success {
            echo '🚀 CD Done: App deployed to server!'
        }
        failure {
            echo '❌ Deployment failed. Check the logs!!'
        }
    }
}
