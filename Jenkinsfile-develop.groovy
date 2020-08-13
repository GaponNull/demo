#!groovy

pipeline {
    agent any

    stages {
        stage('clean_workspace_and_checkout_source') {
            steps {
                sh "docker-machine rm default"
            }
        }
        stage('Build app') {
            agent {
                dockerfile {
                    filename "ci/Dockerfile.build"
                }
            }

            steps {
                echo 'Build success'
            }
        }
        stage('Build & Test app') {
            steps {
                echo "Start building application"
                sh './gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                echo 'Start testing application'
                sh './gradlew test'
            }
        }
    }
}