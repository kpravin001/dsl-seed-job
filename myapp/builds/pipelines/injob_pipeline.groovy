pipeline {
    agent {label 'test'}
    stages {
        stage('Clean Up'){
          steps{
            step([$class: 'WsCleanup'])
          }
        }
        stage('SCM') {
          agent {label 'master'}
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'PathRestriction', excludedRegions: '', includedRegions: '''myapp/.*
                ''']], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/bibekmantree/delete_dsl_mono.git']]])
            }
        }//end SCM
        stage('SCM_checkout_slave') {
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'PathRestriction', excludedRegions: '', includedRegions: '''myapp/.*
                ''']], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/bibekmantree/delete_dsl_mono.git']]])
            }
        }
        stage('Shell') {
            steps {
              container('test') {
                sh "ls -la"
                sh "whoami"
              }
            }
        }
         //stage ('Cleanup') {
           // steps {
             //   step([$class: 'WsCleanup']) 
            //}
        //}
    }

}
