def runParallel = true
def buildStages

pipeline {
    agent {
        label 'albert'
    }

    stages {
         stage('Maven Clean Compile'){
              steps{
                  bat "mvn clean compile"
              }
         }

        stage('Run Tests Scripts') {
            steps {
                script {
                    def buildParallelMap = [:]

                    buildParallelMap.put('Billspay', {
                        echo "Approval needed to run HappyPath tests"
                        input message: 'Do you want to proceed with running bills pay tests?', submitter: 'user'
                        try {
                            echo "Running Billspay test scripts"
                            bat "mvn clean test -DfileName=\"billspay.xml\""
                        } catch (err) {
                            echo 'Billspay stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "BILLSPAY"
                            archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}.html", fingerprint: true
                            junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                        }
                    })

                    buildParallelMap.put('Payout Tests', {
                        echo "Approval needed to run Transactional tests"
                        input message: 'Do you want to proceed with running payout tests?', submitter: 'user'
                        try {
                            echo "Running payout test scripts"
                            bat "mvn clean test -DfileName=\"payout.xml\""
                        } catch (err) {
                            echo 'payout stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "PAYOUT"
                            archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}.html", fingerprint: true
                            junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                        }
                    })

                    buildParallelMap.put('Wallet Services Tests', {
                        echo "Approval needed to run Transactional tests"
                        input message: 'Do you want to proceed with running walletservices tests?', submitter: 'user'
                        try {
                            echo "Running Wallet Services test scripts"
                            bat "mvn clean test -DfileName=\"walletservices.xml\""
                        } catch (err) {
                            echo 'payout stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "WALLET SERVICE"
                            archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}.html", fingerprint: true
                            junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                        }
                    })

                    buildParallelMap.put('sendout Tests', {
                        echo "Approval needed to run Negative tests"
                        input message: 'Do you want to proceed with running send out tests?', submitter: 'user'
                        try {
                            echo "Running negative path test scripts"
                            bat "mvn clean test -DfileName=\"sendout.xml\""
                        } catch (err) {
                            echo 'Negative stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "SENDOUT"
                            archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}.html", fingerprint: true
                            junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                        }
                    })

                    if (runParallel) {
                        parallel buildParallelMap
                    } else {
                        for (build in buildParallelMap.values()) {
                            build.call()
                        }
                    }
                }
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}