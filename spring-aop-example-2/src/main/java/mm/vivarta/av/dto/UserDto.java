package mm.vivarta.av.dto;

import mm.vivarta.av.entity.Address;
import mm.vivarta.av.entity.User;

import java.util.Objects;

public record UserDto(String userName, String name, Long contactNumber, AddressDto address) {

  public static UserDto map(User user) {
    return new UserDto(user.userName(), user.name(), user.contactNumber(), Objects.isNull(user.address())? null :  new AddressDto(user.address().addressLine1(), user.address().addressLine2(), user.address().pinCode()));
  }

}
