#!groovy

pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }

    options {
        disableConcurrentBuilds()
    }

    stages {
        stage('Cleanup') {
            steps {
                sh './gradlew clean'
            }
        }

        stage('PWD, Sonar rules, Code coverage') {
            steps {
                echo 'will add later'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Build') {
            steps {
                sh 'docker build -t hrs-configuration-service .'

                script {
                    docker.withRegistry("912601565515.dkr.ecr.eu-central-1.amazonaws.com/hrs-configuration-service:latest") {
                        dockerImage.push()
                    }
                }
//                sh 'aws ecr get-login-password --region eu-central-1 | docker login --username AWS --password-stdin 912601565515.dkr.ecr.eu-central-1.amazonaws.com/hrs-configuration-service:latest'
            }
        }

//        stage('Push to ECR') {
//            steps {
//                sh 'docker tag hrs-configuration-service:latest 912601565515.dkr.ecr.eu-central-1.amazonaws.com/hrs-configuration-service:latest'
///               sh 'docker push 912601565515.dkr.ecr.eu-central-1.amazonaws.com/hrs-configuration-service:latest'
//            }
//        }
    }
}
