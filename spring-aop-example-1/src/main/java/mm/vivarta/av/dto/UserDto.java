package mm.vivarta.av.dto;

import mm.vivarta.av.entity.Address;
import mm.vivarta.av.entity.User;

public record UserDto(String userName, String name, Long contactNumber, AddressDto address) {

  public static UserDto map(User user) {
    if (user instanceof User(String userName, String name, Long contactNumber, Address address)) {
      if (address instanceof Address(String a1, String a2, Integer pin)) {
        return new UserDto(userName, name, contactNumber, new AddressDto(a1, a2, pin));
      }
      return new UserDto(userName, name, contactNumber, null);
    }
    return null;
  }

}
