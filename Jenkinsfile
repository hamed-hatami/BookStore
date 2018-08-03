pipeline {
    agent any
    tools {
            maven 'Maven 3.5.0'
            jdk 'jdk8'
        }
    stages {
        stage ('Checkout') {
          steps {
            git 'https://github.com/javaee5/BookStore.git'
          }
        }
        stage('Build') {
            steps {
                sh 'mvn package'
            }
        }
    }
}