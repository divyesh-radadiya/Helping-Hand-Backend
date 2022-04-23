pipeline {
	agent any
    stages {
         stage('1. Git Pull ') {
            steps {
				 git url: 'https://github.com/divyesh-radadiya/Helping-Hand.git', branch: 'master',
                 credentialsId: 'git-divyesh-radadiya'
            }
        }
        stage('2. React Build') {
            steps {
                sh 'npm install'
            }
        }
        stage('3. Docker Image') {
            steps {
                script {
                    imageName = docker.build "divyeshradadiya/helpinghand-forntend:latest"
                }
            }
        }
        stage('4. Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'jenkins-docker') {
                        imageName.push()
                    }
                }
            }
        }
        stage('5. Git Pull') {
            steps {
				 git url: 'https://github.com/divyesh-radadiya/Helping-Hand-Backend.git', branch: 'master',
                 credentialsId: 'git-divyesh-radadiya'
            }
        }
        stage('6. Maven Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('7. Maven Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('8. Docker Image') {
            steps {
                script {
                    imageName = docker.build "divyeshradadiya/helpinghand-backend:latest"
                }
            }
        }
        stage('9. Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'jenkins-docker') {
                        imageName.push()
                    }
                }
            }
        }

        stage('10. Ansible Deploy') {
            steps {

                ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible/inventory', playbook: 'ansible/playbook.yml'

            }
        }


    }
}