#!groovy
@Library('utils')
import com.hazelcast.qe.Utils
import com.hazelcast.qe.Grabber

node() {
    stage ('Deploy Artifacts') {
        def grabber = new Grabber(this)
        grabber.grab('test')
        def utils = new Utils(this)
        utils.ssh("address")
    }
}
//
//pipeline {
//    agent any
//    options {
//        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
//    }
//    stages {
//        stage('Pipeline Start') {
//            steps {
//                script {
//                    def utils = new Utils(this)
//                    utils.ssh('test')
//                }
//            }
//
//        }
//    }
//}
//
