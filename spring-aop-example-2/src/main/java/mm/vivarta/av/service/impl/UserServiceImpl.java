package mm.vivarta.av.service.impl;

import mm.vivarta.av.constant.ExceptionMessage;
import mm.vivarta.av.dto.UserDto;
import mm.vivarta.av.exception.UserException;
import mm.vivarta.av.repository.UserRepository;
import mm.vivarta.av.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDto getUserById(String userName) throws UserException {
    if (Objects.isNull(userName) || userName.isBlank()) {
      throw new UserException(ExceptionMessage.USER_NAME_INVALID);
    }
    return userRepository.findUserById(userName).map(UserDto::map).orElseThrow(() -> new UserException(ExceptionMessage.USER_NAME_NOT_FOUND));
  }

  @Override
  public List<UserDto> getUserByName(String name) throws UserException {
    if (Objects.isNull(name) || name.isBlank()) {
      throw new UserException(ExceptionMessage.NAME_INVALID);
    }
    var users = userRepository.findUserByName(name).stream().map(UserDto::map).toList();
    if (users.isEmpty()) {
      throw new UserException(ExceptionMessage.NAME_NOT_FOUND);
    }
    return users;
  }

  @Override
  public List<UserDto> getUserByPinCode(Integer pin) throws UserException {
    if (Objects.isNull(pin)) {
      throw new UserException(ExceptionMessage.PIN_INVALID);
    }
    var users = userRepository.findUserByPinCode(pin).stream().map(UserDto::map).toList();
    if (users.isEmpty()) {
      throw new UserException(ExceptionMessage.PIN_NOT_FOUND);
    }
    return users;
  }

}
