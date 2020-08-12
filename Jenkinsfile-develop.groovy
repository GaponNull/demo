#!groovy

pipeline {
    agent none

    stages {
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