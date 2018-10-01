package com.hazelcast.qe

import org.apache.commons.lang3.RandomStringUtils

class Randomizer {
    Randomizer() {
    }
    def randomize(){
        return RandomStringUtils.randomAlphabetic(42)
    }
}
