package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {


    public static Logger getLogger(String name) {
        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("logs.txt");
        Predicate<String> condition = message -> message.contains("simulation");
        Logger filteredLogger = new FilteredLogger(fileLogger, condition);
        Logger contextualLogger = new ContextualLogger(name, filteredLogger);
        return new CompositeLogger(contextualLogger, consoleLogger);
    }
}
