package mm.vivarta.av.exception;

import mm.vivarta.av.constant.ExceptionMessage;

public class UserException extends Exception {

  public UserException(ExceptionMessage message){
    super(message.getMessage());
  }

}
