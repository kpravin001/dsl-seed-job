pipeline {
    agent { label 'master'}
    stages {
        stage('SCM') {
            steps { 
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'PathRestriction', excludedRegions: '', includedRegions: '''yourapp/.*
                ''']], submoduleCfg: [], userRemoteConfigs: [[ url: 'https://github.com/bibekmantree/delete_dsl_mono.git']]])
            }
        }//end SCM
        
         //stage ('Cleanup') {
           // steps {
             //   step([$class: 'WsCleanup']) 
            //}
        //} 
    }

}
