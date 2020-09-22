pipeline {
    agent any
    stages {
        stage('Clean Up'){
          steps{
            step([$class: 'WsCleanup'])
          }
        }
        stage('SCM') {
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/bibekmantree/flask_ps_sanjay.git']]])
            }
        }//end SCM
        
         //stage ('Cleanup') {
           // steps {
             //   step([$class: 'WsCleanup']) 
            //}
        //}
    }

}
