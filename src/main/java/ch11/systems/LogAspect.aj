package ch11.systems;

import java.util.logging.Logger;

public aspect LogAspect {

	Logger log = Logger.getLogger("LogAspect");

	pointcut publicMethodExecuted(): execution(public * Account.*(..));


	before(): publicMethodExecuted() {
       log.info(String.format("Enters on method: %s. \n", thisJoinPoint.getSignature()));

        Object[] arguments = thisJoinPoint.getArgs();
        for (int i =0; i < arguments.length; i++){
            Object argument = arguments[i];
            if (argument != null){
                log.info(String.format("With argument of type %s and value %s. \n", argument.getClass().toString(), argument));
            }
        }
        log.info(String.format("Exits method: %s. \n", thisJoinPoint.getSignature()));
    }

}
