package mm.vivarta.av.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ArgLoggingServiceImpl {
  private static final Logger log = LoggerFactory.getLogger(ArgLoggingServiceImpl.class.getName());
  public void processInput(String ...args){
    log.debug("Passed {} arguments in command line", args.length);
    for (int i = 0; i < args.length; i++){
      log.debug("{}: {}", (i + 1), args[i]);
    }
  }
}
