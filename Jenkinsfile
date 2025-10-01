pipeline {
    agent any
    tools {
        jdk 'JDK 21'           // The exact name of your JDK tool configured in Jenkins Global Tools
        maven 'my_maven'    // Your Maven tool name
    }
    stages {
        stage('Build') {
            steps {
                script {
                    // Get the path of the installed JDK tool
                    def javaHome = tool name: 'JDK 21', type: 'jdk'
                    def mavenHome = tool name: 'my_maven', type: 'maven'

                    // Set JAVA_HOME and update PATH for the build step
                    withEnv([
                        "JAVA_HOME=${javaHome}",
                        "PATH=${javaHome}\\bin;${mavenHome}\\bin;${env.PATH}"
                    ]) {
                        bat 'mvn clean install'
                    }
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    def javaHome = tool name: 'JDK 21', type: 'jdk'
                    def mavenHome = tool name: 'Maven 3.8.4', type: 'maven'

                    withEnv([
                        "JAVA_HOME=${javaHome}",
                        "PATH=${javaHome}\\bin;${mavenHome}\\bin;${env.PATH}"
                    ]) {
                        bat 'mvn test'
                    }
                }
            }
        }
    }
}
