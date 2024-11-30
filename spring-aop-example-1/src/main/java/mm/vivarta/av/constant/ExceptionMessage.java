package mm.vivarta.av.constant;

import lombok.Getter;

@Getter
public enum ExceptionMessage {

  USER_NAME_INVALID("User name can't be null"),
  USER_NAME_NOT_FOUND("User name can't be null"),
  NAME_INVALID("Name is invalid"),
  NAME_NOT_FOUND("Couldn't find any user with name"),
  PIN_NOT_FOUND("Couldn't find any user in given pin code"),
  PIN_INVALID("Given pin code is invalid");

  private final String message;
  private ExceptionMessage(String message) {
    this.message = message;
  }

}
