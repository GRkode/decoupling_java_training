package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    private Logger logger1;
    private Logger logger2;

    public CompositeLogger(Logger logger1, Logger loger2){
        this.logger1 = logger1;
        this.logger2 = loger2;
    }

    @Override
    public void log(String message) {
        logger1.log(message);
        logger2.log(message);
    }
}
