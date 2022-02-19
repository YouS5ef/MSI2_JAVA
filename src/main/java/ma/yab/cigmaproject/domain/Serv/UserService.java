package ma.yab.cigmaproject.domain.Serv;

import ma.yab.cigmaproject.domain.dataTobject.UserDatatobject;
import ma.yab.cigmaproject.domain.dataTobject.UserResponse;

public interface UserService {

    UserDatatobject createUser(UserDatatobject userDatatobject);

    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
