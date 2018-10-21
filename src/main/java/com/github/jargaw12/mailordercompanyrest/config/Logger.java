package com.github.jargaw12.mailordercompanyrest.config;

public class Logger {
    public java.util.logging.Logger logger;
    private static Logger ourInstance = new Logger();

    public static Logger getInstance() {
        return ourInstance;
    }

    private Logger() {
    }
}
