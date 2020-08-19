#!groovy

pipeline {
    agent none

    triggers {
        pollSCM '* * * * *'
    }

    options {
        disableConcurrentBuilds()
    }

    stages {
        stage('Cleanup') {
            agent { label 'dev' }
            steps {
                sh './gradlew clean'
            }
        }

        stage('PWD, Sonar rules, Code coverage') {
            agent { label 'dev' }
            steps {
                echo 'will add later'
            }
        }

        stage('Test') {
            agent { label 'dev' }
            steps {
                sh './gradlew test'
            }
        }

        stage('Build') {
            agent { label 'dev' }
            steps {
                sh './gradlew build'
            }
        }
    }
}
