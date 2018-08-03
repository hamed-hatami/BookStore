pipeline {
   agent any
   stages {
    stage ('Checkout') {
          steps {
            git url:'https://github.com/javaee5/BookStore.git'
          }
        }
    stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
   }

}