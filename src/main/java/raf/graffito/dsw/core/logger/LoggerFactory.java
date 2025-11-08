package raf.graffito.dsw.core.logger;

import raf.graffito.dsw.core.ApplicationFramework;
import raf.graffito.dsw.core.messageGenerator.Message;
import raf.graffito.dsw.core.messageGenerator.MessageGenerator;

public class LoggerFactory {
   public Logger createLogger(String loggertype)
   {
       if(loggertype.equals("fileLogger"))
       {
           return new FileLogger();
       }
       else if(loggertype.equals("consoleLogger")) return new ConsoleLogger();
       else
       {
           ApplicationFramework.getInstance().getMg().generateError("Pogresan logger kako??");
          return null;
       }
   }

}
