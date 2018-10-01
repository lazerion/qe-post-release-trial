package com.hazelcast.qe

class Utils implements Serializable {
    def steps
    Utils(steps) {this.steps = steps}
    def ssh(args) {
        steps.echo 'Utils : SSH to download machine'
        def rand = new Randomizer().randomize()
        steps.echo rand
        steps.sh 'ls -ll'
    }
}
