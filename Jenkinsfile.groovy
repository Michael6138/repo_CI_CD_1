//pipeline {
//    stages {
//        stage('build') {
//            echo 'Hi1'
//        }
//
//        stage('deploy') {
//            echo 'H2'
//        }
//    }
//}

node("Remote node"){
    stage("readFile"){
        readFile("Jenkinsfile.groovy")

    }
}