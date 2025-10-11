pipeline {
    agent any

    tools {
        maven 'Maven3'
    }

    triggers {
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Prajapati-HitenCode/practice_maven.git',
                    // credentialsId: 'github-credentials' // Make sure to create this in Jenkins
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ CI Passed: Build and Tests Successful'
        }
        failure {
            echo '❌ CI Failed: Check Build Logs'
        }
    }
}
