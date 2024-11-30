package mm.vivarta.av.controller;

import mm.vivarta.av.dto.UserDto;
import mm.vivarta.av.exception.UserException;
import mm.vivarta.av.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(path = "/{userName}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDto> getUserById(@PathVariable("userName") String userName) throws UserException {
    return ResponseEntity.ok(userService.getUserById(userName));
  }

  @GetMapping(path = "/name/{name}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserDto>> getUserByName(@PathVariable("name") String name) throws UserException {
    return ResponseEntity.ok(userService.getUserByName(name));
  }

  @GetMapping(path = "/address/pin/{pin}", produces = APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserDto>> getUserByPin(@PathVariable("pin") Integer pin) throws UserException {
    return ResponseEntity.ok(userService.getUserByPinCode(pin));
  }

}
