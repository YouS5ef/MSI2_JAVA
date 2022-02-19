package ma.yab.cigmaproject.domain.Serv.implement;

import ma.yab.cigmaproject.Input.model.User;
import ma.yab.cigmaproject.Input.Storage.UserStorage;
import ma.yab.cigmaproject.domain.dataTobject.UserDatatobject;
import ma.yab.cigmaproject.domain.dataTobject.UserResponse;
import ma.yab.cigmaproject.domain.Serv.UserService;
import ma.yab.cigmaproject.domain.Serv.mapp.UserMapp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplement implements UserService {

    private UserStorage userStorage;

    public UserServiceImplement(UserStorage userRepository) {
          this.userStorage = userRepository;
    }

    @Override
    public UserDatatobject createUser(UserDatatobject userDto) {

        User user = UserMapp.mapToEntity(userDto);
        User newUser = userStorage.save(user);


        UserDatatobject userResponse = UserMapp.mapToDTO(newUser);
        return userResponse;
    }

    @Override
    public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();


        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = userStorage.findAll(pageable);


        List<User> listOfUsers = users.getContent();

        List<UserDatatobject> content= listOfUsers.stream().map(user -> UserMapp.mapToDTO(user)).collect(Collectors.toList());

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNo(users.getNumber());
        userResponse.setPageSize(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());

        return userResponse;
    }


}