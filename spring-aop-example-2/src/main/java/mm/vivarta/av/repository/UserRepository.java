package mm.vivarta.av.repository;

import mm.vivarta.av.entity.Address;
import mm.vivarta.av.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class UserRepository {
  public final static List<User> USERS = List.of(
    new User("johndoe", "John Doe", 1234567890L, new Address("Street 1", "Street 2", 123455)),
    new User("janedoe", "Jane Doe", 9876543210L, new Address("Avenue A", "Block B", 678910)),
    new User("alexsmith", "Alex Smith", 1231231234L, new Address("Boulevard X", "Lane Y", 456789)),
    new User("emilywhite", "Emily White", 9871234567L, new Address("Main Road", "Corner St", 369147)),
    new User("michaelbrown", "Michael Brown", 7894561230L, new Address("Park Ave", "Suite 5", 321456)),
    new User("sarahgreen", "Sarah Green", 6547893210L, new Address("Lakeview", "Apt 101", 654123)),
    new User("davidjohnson", "David Johnson", 3216549870L, new Address("Hilltop", "Floor 2", 147258)),
    new User("laurablue", "Laura Blue", 8529637410L, new Address("Riverside", "Block C", 258369)),
    new User("roberthall", "Robert Hall", 7418529630L, new Address("Oak Street", "Unit 3", 159753)),
    new User( "karenblack", "Karen Black", 3692581470L, new Address("Elm Street", "House 20", 753159)),
    new User( "stevenking", "Steven King", 9517538520L, new Address("Maple Ave", "Villa 6", 159753)),
    new User( "nataliered", "Natalie Red", 1478523690L, new Address("High Street", "Flat B2", 321789)),
    new User( "jameswalker", "James Walker", 9638527410L, new Address("Broadway", "Building 12", 741963)),
    new User( "carolinegray", "Caroline Gray", 7891234560L, new Address("Beach Road", "Cottage 5", 852741)),
    new User( "kevinwright", "Kevin Wright", 6543219870L, new Address("Green Lane", "Apt 3B", 369852)),
    new User( "rachelmiller", "Rachel Miller", 8527419630L, new Address("Sunset Blvd", "Suite 7", 147369)),
    new User( "charlesdavis", "Charles Davis", 7419638520L, new Address("Pine Street", "Unit 4A", 159753)),
    new User( "meganbrown", "Megan Brown", 9637418520L, new Address("Willow Lane", "Apt 2C", 147258)),
    new User( "danielclark", "Daniel Clark", 1473698520L, new Address("Cherry Road", "House 10", 369852)),
    new User( "oliviaparker", "Olivia Parker", 3697418520L, new Address("Cedar Lane", "Villa 1", 741258))
  );

  public Optional<User> findUserById(String userName) {
    return USERS.stream().filter(user -> userName.equals(user.userName())).findFirst();
  }

  public List<User> findUserByName(String name) {
      return USERS.stream().filter(user -> name.equals(user.name())).toList();
  }

  public List<User> findUserByPinCode(Integer pin) {
    if (Objects.nonNull(pin)) {
      return USERS.stream().filter(user -> user.address().pinCode().equals(pin)).toList();
    }
    return List.of();
  }

}
