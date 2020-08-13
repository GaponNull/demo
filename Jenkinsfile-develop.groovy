#!groovy

pipeline {
    agent any

    stages {
        stage('Build app') {
            steps {
                print "Start building application"
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