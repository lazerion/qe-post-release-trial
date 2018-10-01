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
