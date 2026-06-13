package designpatternpracticeshrayansh.chainofresponsibility;

 abstract class LogProcessor {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FATAL = 4;
    int level;
    LogProcessor nextLoggerProcessor;
    public void setNextLogger (LogProcessor nextLogger) {
        this.nextLoggerProcessor = nextLogger;
    }
        public void logMessage(int level, String message) {
            if (this.level <= level) {
                write(message);
            }
// Pass to next handler in chain if exists
                if (this.nextLoggerProcessor != null) {
                    this.nextLoggerProcessor.logMessage(level, message);
                }
            }
                    abstract protected void write(String message);
}
// Concrete handler for DEBUG level
 class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("DEBUG: " + message);
    }
}
// Concrete handler for DEBUG level
// Concrete handler for DEBUG level
  class InfoLogProcessor extends LogProcessor {
     public InfoLogProcessor(int level) {
         this.level = level;
     }
         @Override
         protected void write (String message){
             System.out.println("INFO: " + message);
         }
     }

 class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor (int level) {
        this.level = level;
    }
        @Override
        protected void write (String message) {
            System.out.println("ERROR: " + message);
        }
    }

 class LoggerDemo {
    public static void main (String[] args) {
        LogProcessor logProcessor = getChain0fLoggers();
        System.out.println("Logging messages:");
        System.out.println("===== Logging DEBUG message =====");
        logProcessor.logMessage(LogProcessor.DEBUG, "This is a debug message");
                System.out.println("===== Logging INFO message =====");
        logProcessor.logMessage(LogProcessor.INFO, "This is an info message");
                System.out.println("===== Logging ERROR message =====");
         logProcessor.logMessage(LogProcessor.ERROR, "This is an error message");
                 System.out.println("===== Logging FATAL message =====");
                logProcessor.logMessage(LogProcessor.FATAL, "This is a fatal message");
    }
//        System. out.println("###### Chain of Responsibility Design
//                Pattern ######");
//                        / Get the chain of loggers
//                LogProcessor logProcessor = getChain0fLoggers:
//        System.out. printIn("Logging messages:");
//        System.out.println("===== Logging DEBUG message ====="); logProcessor. logMessage (LogProcessor.DEBUG,
//                "This is a debug
//                message"):
//                System.out.println("===== Logging INFO message ====="); logProcessor. logMessage (LogProcessor. INFO, "This is an info
//                message");
//                System.out.println("===== Logging ERROR message ====="); logProcessor. logMessage (LogProcessor.ERROR, "This is an error
//                message");
//                System.out.println ("===== Logging FATAL message ====="); logProcessor. logMessage (LogProcessor.FATAL, "This is a fatal
//                message");
         private static LogProcessor getChain0fLoggers() {//4
            LogProcessor errorLogger = new
                    ErrorLogProcessor (LogProcessor. ERROR); // 3
            LogProcessor infoLogger = new
                    InfoLogProcessor (LogProcessor.INFO); // 2
            LogProcessor debugLogger = new
                    DebugLogProcessor (LogProcessor. DEBUG); // 1

// Dynamic Chaining: DEBUG -> INFO -> ERROR -> FATAL
            debugLogger.setNextLogger(infoLogger);
            infoLogger.setNextLogger(errorLogger);
// fatallogger.nextLoggerProcessor is null; // Last logge
            return debugLogger; // Return the first LogProcessor in
        }
    }

