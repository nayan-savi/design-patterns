package com.patterns.proxy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProxyPatternTest {


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void adminTest() {
        CommandExecutor executor = new CommandExecutorProxy("nayan", "1234");
        try {
            executor.runCommand("ls -ltr");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void removeAdminTest() {
        CommandExecutor executor = new CommandExecutorProxy("nayan", "1234");
        try {
            executor.runCommand("rm -f proxy.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void removeNonAdminTest() {
        CommandExecutor executor = new CommandExecutorProxy("demo", "124");
        try {
            executor.runCommand("rm -f proxy.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void nonAdminTest() {
        CommandExecutor executor = new CommandExecutorProxy("test", "134");
        try {
            executor.runCommand("ls -ltr");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
