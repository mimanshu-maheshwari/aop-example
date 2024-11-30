package mm.vivarta.av.service;

import mm.vivarta.av.dto.UserDto;
import mm.vivarta.av.exception.UserException;

import java.util.List;

public interface UserService {
  public UserDto getUserById(String userName) throws UserException;
  public List<UserDto> getUserByName(String name) throws UserException;
  public List<UserDto> getUserByPinCode(Integer pin) throws UserException;
}
