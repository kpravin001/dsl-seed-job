job('dsl_seed_myapp_builds') {
    scm {
        git {
            remote {
                    url('https://github.com/bibekmantree/seed_experiment.git')
             }
        }
    }
    triggers {
        upstream('dsl_seed_myapp', 'UNSTABLE')
    }
    wrappers {
        preBuildCleanup()
    }
    steps {
        dsl {
            external('./myapp/builds/jobs/builds_*.groovy')
            removeAction('DELETE')
            removeViewAction('DELETE')
        }
    }
}
