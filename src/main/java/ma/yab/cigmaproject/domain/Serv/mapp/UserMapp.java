package ma.yab.cigmaproject.domain.Serv.mapp;

import ma.yab.cigmaproject.Input.model.User;
import ma.yab.cigmaproject.domain.dataTobject.UserDatatobject;

public class UserMapp {

    public static UserDatatobject mapToDTO(User user){
        UserDatatobject userDatatobject = new UserDatatobject();
        userDatatobject.setId(user.getId());
        userDatatobject.setFullName(user.getFullName());
        userDatatobject.setEmail(user.getEmail());
        return userDatatobject;
    }


    public static User mapToEntity(UserDatatobject userDatatobject){
        User user = new User();
        user.setFullName(userDatatobject.getFullName());
        user.setEmail(userDatatobject.getEmail());
        return user;
    }
}
