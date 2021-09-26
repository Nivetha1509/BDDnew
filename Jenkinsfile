pipeline{
	agent any
	tools{
	maven 'apache-maven-3.8.1'
	}
	stages{
		stage('checkout'){
			steps{
				git 'https://github.com/Nivetha1509/BDDnew.git'
			}
		}
		stage('mvn Test'){
			steps{
				bat 'mvn --version'
			}
		}
		stage('Build'){
			steps{
				bat 'mvn clean install'
			}
		}
		stage('Hello'){
			steps{
				echo 'Hello World from Jenkins and Github!'
			}
		}
              stage('send notification'){
                    steps {
                                mail to:'nivethas120@gmail.com',
                                body :"Build Success ${env.BUILD_URL}",
                                subject:"Passed ${currentBuild.fullDisplayName}"
                      }
		}  
             
		
	}
}