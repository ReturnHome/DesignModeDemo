package com.weconex.designmodedemo.action13_责任链模式;

/**
 * Created by lifeng on 2018/2/6.
 * @desc 责任链模式
 *  注:为请求创建一个接受者对象的链
 */

public class ChainResponsibilityPattern {

    public static void test(){
        AbstractLogger logger = getChainOfLogger();

        logger.logMessage(AbstractLogger.INFO, "This is an information.");
        logger.logMessage(AbstractLogger.DEBUG, "This is an DEBUG information.");
        logger.logMessage(AbstractLogger.ERROR, "This is an ERROR information.");
    }

    private static AbstractLogger getChainOfLogger(){
        AbstractLogger errorLogger =  new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger =  new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
        return errorLogger;
    }
}

/*** 示例:
 * 创建抽象类 AbstractLogger，带有详细的日志记录级别;
 * 我们创建三种类型的记录器，
 * 都扩展了 AbstractLogger。每个记录器消息的级别是否属于自己的级别，
 * 如果是则相应地打印出来，否则将不打印并把消息传给下一个记录器 ***/

abstract class AbstractLogger{
    public static int INFO = 1;

    public static int DEBUG = 2;

    public static int ERROR = 3;

    protected int level;

    //责任链的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level,String message){
        if(this.level <= level) {
            write(message);
        }
        
        if(nextLogger != null) {
            nextLogger.logMessage(level,message);
        }
    }

    protected abstract void write(String message);
}

/**
 * 创建拓展了该记录器的实体类
 */
class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard console logger:" + message);
    }
}

class ErrorLogger extends AbstractLogger{
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error logger:" + message);
    }
}

class FileLogger extends AbstractLogger{

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File logger:" + message);
    }
}