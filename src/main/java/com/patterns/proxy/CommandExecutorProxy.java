package com.patterns.proxy;

public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String userName, String password) {
        if ("nayan".equalsIgnoreCase(userName) && "1234".equals(password))
            this.isAdmin = true;
        executor = new CommandExecutorImpl();
    }

    public void runCommand(String cmd) throws Exception {
        if (isAdmin) {
            executor.runCommand(cmd);
        } else {
            if (cmd.trim().startsWith("rm")) {
                throw new Exception("removed command can not be executed. Permission denied!");
            } else {
                executor.runCommand(cmd);
            }
        }
    }
}
