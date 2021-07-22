pipeline{
    agent any

    tools{
        maven 'maven-3'
    }
    stages{
        stage('Compile and clean'){
            steps{
                sh "mvn clean compile"
            }
        }

        stage('Build jar') {
            steps {
                sh "mvn package"
            }
        }

        stage('Build Docker image'){
            steps {

                sh 'docker build -t  615372917774.dkr.ecr.ap-south-1.amazonaws.com/jenkin:1.0.0 .'
            }
        }

        stage('Push to ECR'){

            steps {
                script{
                    sh 'aws ecr get-login-password --region ap-south-1 | docker login --username AWS --password-stdin 615372917774.dkr.ecr.ap-south-1.amazonaws.com'
                    sh 'docker push 615372917774.dkr.ecr.ap-south-1.amazonaws.com/jenkin:1.0.0'
                }
            }
        }

         stage('stop previous containers') {
            steps {
              sh 'docker ps -f name=myContainer -q | xargs --no-run-if-empty docker container stop'
              sh 'docker container ls -a -f name=myContainer -q | xargs -r docker container rm'
            }
         }

        stage('Docker Run') {
            steps{
                script {
                    sh 'docker run -p 8082:8080 --rm --name myContainer 615372917774.dkr.ecr.ap-south-1.amazonaws.com/jenkin:1.0.0'
                }
            }
        }

        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}