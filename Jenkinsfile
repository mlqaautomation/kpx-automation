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

                    // HappyPath test
                    buildParallelMap.put('Billspay', {
                        echo "Approval needed to run HappyPath tests"
                        input message: 'Do you want to proceed with running billspay tests?', submitter: 'user'
                        try {
                            echo "Running Billspay test scripts"
                            bat "mvn clean test -DfileName=\"billspay.xml\""
                        } catch (err) {
                            echo 'Billspay stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "LUKAT"
//                             archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}_HappyPath.html", fingerprint: true
//                             junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
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
                            def suiteName = "LUKAT"
//                             archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}_Transactional.html", fingerprint: true
//                             junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
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
                            def suiteName = "LUKAT"
//                             archiveArtifacts artifacts: "Reports/${currentDate}/${suiteName}_Transactional.html", fingerprint: true
//                             junit skipPublishingChecks: true, testResults: 'target/surefire-reports/junitreports/*.xml'
                        }
                    })

                    // Negative test
                    buildParallelMap.put('sendout Tests', {
                        echo "Approval needed to run Negative tests"
                        input message: 'Do you want to proceed with running sendout tests?', submitter: 'user'
                        try {
                            echo "Running negative path test scripts"
                            bat "mvn clean test -DfileName=\"billspay.xml\""
                        } catch (err) {
                            echo 'Negative stage aborted'
                            return
                        }finally{
                            def currentDate = new Date().format('MM-dd-yyyy')
                            def suiteName = "LUKAT"
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