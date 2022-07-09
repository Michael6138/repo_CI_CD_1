pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    stages {
        stage('build') {
            steps {
                readFile('C:\\Users\\Michael\\check_clone\\repo_CI_CD_1\\Jenkinsfile.groovy')
                sh 'mvn --version'
            }
        }
    }
}

