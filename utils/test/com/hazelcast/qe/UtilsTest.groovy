package com.hazelcast.qe


class UtilsTest extends GroovyTestCase {
    private Utils utils

    void testShouldGenerateRandom() {
        println "testing"
        def steps = [echo: { text -> println text },
                     sh  : { text -> println text }]
        utils = new Utils(steps)
        utils.ssh('host-address')
    }
}
