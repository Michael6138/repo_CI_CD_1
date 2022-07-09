pipeline {
    stages {
        stage('build') {
            echo 'Hi1'
        }

        stage('deploy') {
            echo 'H2'
        }
    }
}