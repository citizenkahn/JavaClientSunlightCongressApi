package com.github.citizenkahn.sunlight;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestName;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by pkahn on 10/9/2016.
 */
public class TestBase {
    Date now = new Date();
    String hostName;

    @Rule
    public TestName name = new TestName();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    public TestBase() {
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostName = "UnknownHost";
        }
    }

    /**
     *
     * @param fileName beneath resources
     * @return file object for test file
     */
    public File getTestFile(String fileName) {
        return new File("src/test/resources/" + fileName);
    }
    /**
    /**
     * @return Unique Name for creating pages on test wikis etc
     */
    public String getUniqueName() {
        return "${hostName}-${now.getTime()}-${name.getMethodName()}";
    }

    /**
     * Create empty dir for test (build/testdata/class-method
     * @return File for testdir
     */
    protected  File createEmptyTestDir() {
        return createEmptyTestDir(getClass().getName() + "-" + name.getMethodName());
    }

    /**
     * Empty test directory
     * @param testName to use for testdir name
     * @return File for testdir
     */
    protected File createEmptyTestDir(String testName) {
        File testDir = new File("build/testdata/" + testName);
        if (testDir.exists())
        {
            testDir.delete();
        }
        testDir.getParentFile().mkdirs();
        return testDir;
    }

}
