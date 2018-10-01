package com.hazelcast.qe

@Grab('org.apache.commons:commons-lang3:3.7')

class Grabber implements Serializable {
    def steps

    Grabber(steps) { this.steps = steps }

    def grab(args) {
        steps.echo 'Grabbing'
    }
}
