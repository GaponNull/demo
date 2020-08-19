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
                sh './gradlew build'
            }
        }
    }
}
