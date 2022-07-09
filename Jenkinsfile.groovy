pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    stages {
        stage('build') {
            echo 'hi 777777777777777777'
            steps {
                sh 'mvn --version'
            }
        }
    }
}

