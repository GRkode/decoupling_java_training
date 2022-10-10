package fr.lernejo.logger;

public class LoggerFactory {


    public static Logger getLogger(String name) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("logging.txt");
        return new CompositeLogger(consoleLogger, fileLogger);
    }
}
