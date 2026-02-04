pipeline {
    agent any

    environment {
        IMAGE_NAME = "maven-test-runner"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/shiva2devops/TestFramework.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE_NAME% .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                bat 'docker run --rm %IMAGE_NAME%'
            }
        }
    }

    post {
        always {
            bat 'docker system prune -f'
        }
    }
}
