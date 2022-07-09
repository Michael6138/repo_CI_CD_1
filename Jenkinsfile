pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
//     stage('read') {
//         steps {
//             script {
//                 def data = readFile(file: 'C:\\Users\\Michael\\.jenkins\\workspace\\https-michael@script\\1e93aa97472824a8d03dc5c14528a1f2228c590faacc3ba632c1253d4a6a7412\\Jenkinsfile')
//                 println(data)
//             }
//         }
//     }
    stages {
        stage('build') {
            echo 'hi 777777777777777777'
            steps {
                sh 'mvn --version'
            }
        }
    }
}

