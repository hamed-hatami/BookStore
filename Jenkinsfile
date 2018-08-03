pipeline {

    agent any

    tools {
        maven 'apache-maven-3.5.0'
    }

    stage ('Checkout') {
          steps {
            git url:'https://github.com/javaee5/BookStore.git'
          }
        }
    stage('Build') {
            steps {
                sh 'mvn package'
            }
        }

}