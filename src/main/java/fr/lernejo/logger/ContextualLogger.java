package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{

    private String classname;
    private Logger delegateLogger;
    private String callerClass;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    public ContextualLogger (String classname,Logger logger){
        this.delegateLogger = logger;
        this.classname = classname;
    }
    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(formatter) + " " + classname + ": " + message);
    }
}
