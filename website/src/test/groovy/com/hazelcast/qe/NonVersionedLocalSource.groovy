package com.hazelcast.qe

import com.lesfurets.jenkins.unit.global.lib.SourceRetriever
import groovy.transform.CompileStatic

@CompileStatic
class NonVersionedLocalSource implements SourceRetriever {
    String sourceURL

    NonVersionedLocalSource(String source) {
        this.sourceURL = source
    }

    @Override
    List<URL> retrieve(String repository, String branch, String targetPath) throws IllegalStateException {
        def sourceDir = new File(sourceURL).toPath().toFile()
        if (sourceDir.exists()) {
            return [sourceDir.toURI().toURL()]
        }
        throw new IllegalStateException("Directory $sourceDir.path does not exists")
    }

    static NonVersionedLocalSource nonVersionedLocalSource(String source) {
        new NonVersionedLocalSource(source)
    }

    @Override
    String toString() {
        return "LocalSource{" +
                "sourceURL='" + sourceURL + '\'' +
                '}'
    }
}
