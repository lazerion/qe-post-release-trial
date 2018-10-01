package com.hazelcast.qe

import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.rules.TemporaryFolder

import java.nio.file.Paths

import static com.hazelcast.qe.NonVersionedLocalSource.nonVersionedLocalSource
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library

class UtilsIntegrationTest extends BasePipelineTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder()
    @Rule
    public ExpectedException expectedException = ExpectedException.none()

    private String sharedLibs

    @Override
    @Before
    void setUp() throws Exception {
        def path = Paths.get("/Users/baris/work/qe-post-release-trial/utils")
        sharedLibs = path.toFile().toURL().getFile()
        scriptRoots += '/website'
        super.setUp()
        binding.setVariable('scm', [branch: 'master'])
    }

    @Test
    void libraryUtils() throws Exception {
        def library = library().name('utils')
                .defaultVersion('master')
                .allowOverride(true)
                .implicit(false)
                .targetPath(sharedLibs)
                .retriever(nonVersionedLocalSource(sharedLibs))
                .build()

        helper.registerSharedLibrary(library)
        try {
            runScript("pipeline.groovy")
            printCallStack()
        } catch (e) {
            e.printStackTrace()
            throw e
        }
    }
}
