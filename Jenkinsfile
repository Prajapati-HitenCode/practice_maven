pipeline {
    agent any
    tools {
        jdk 'jdk21' // The name you gave in Global Tool Configuration
        maven 'Maven 3.8.4' // if you want to specify Maven version
    }

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
