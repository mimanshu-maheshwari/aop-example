package mm.vivarta.av.entity;

import mm.vivarta.av.dto.AddressDto;
import mm.vivarta.av.dto.UserDto;

public record User(String userName, String name, Long contactNumber, Address address) {
  public static User map(UserDto userDto) {
    return new User(
      userDto.userName(),
      userDto.name(),
      userDto.contactNumber(),
      null == userDto.address()
        ? null
        : new Address(
          userDto.address().addressLine1(),
          userDto.address().addressLine2(),
          userDto.address().pinCode()));
  }
}
