pipelineJob('myapp_git_pipeline') {
    logRotator {
        numToKeep(7)
    }
    properties {
        githubProjectUrl('https://github.com/bibekmantree/azure_terraform_jenkins.git')
    }
    triggers {
        githubPush()
        //scm('H/4 * * * *')
    }
    definition {
		cpsScm {
			scm {
				git {
					remote {
						github("bibekmantree/azure_terraform_jenkins", "https")
						credentials("github")
					}
					branch("*/master")
				}
			}
			scriptPath("Jenkinsfile")
		}
	}
    
}