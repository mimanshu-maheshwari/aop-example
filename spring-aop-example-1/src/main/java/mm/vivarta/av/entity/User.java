package mm.vivarta.av.entity;

import mm.vivarta.av.dto.AddressDto;
import mm.vivarta.av.dto.UserDto;

public record User(String userName, String name, Long contactNumber, Address address) {
  public static User map(UserDto userDto) {
    if (userDto instanceof UserDto(String userName, String name, Long contactNumber, AddressDto addressDto)) {
      if (addressDto instanceof AddressDto(String a1, String a2, Integer pin)) {
        return new User(userName, name, contactNumber, new Address(a1, a2, pin));
      }
      return new User(userName, name, contactNumber, null);
    }
    return null;
  }
}
