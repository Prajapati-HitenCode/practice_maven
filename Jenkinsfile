pipeline {
    agent any
    tools {
        jdk 'JDK 21' // The name you gave in Global Tool Configuration
        maven 'my_maven' // if you want to specify Maven version
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
