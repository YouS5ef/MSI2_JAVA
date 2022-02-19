package ma.yab.cigmaproject.domain.Serv;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import ma.yab.cigmaproject.UnitTest;
import ma.yab.cigmaproject.domain.Serv.implement.UserServiceImplement;
import ma.yab.cigmaproject.domain.Serv.mapp.UserMapp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import ma.yab.cigmaproject.Input.model.User;
import ma.yab.cigmaproject.Input.Storage.UserStorage;
import ma.yab.cigmaproject.domain.dataTobject.UserDatatobject;
import ma.yab.cigmaproject.domain.dataTobject.UserResponse;

class UserServiceTest extends UnitTest {

    @Mock
    private UserStorage userRepo;
    
    private UserService userService;
    
    private UserDatatobject userDto;
    private User user;
    
    @Override
	protected void setup() {
		userService = new UserServiceImplement(userRepo);
		this.userDto = random.nextObject(UserDatatobject.class);
		this.user = UserMapp.mapToEntity(userDto);
	}
    
    @Test
    public void testCreateUser()  {
    	when(userRepo.save(user)).thenReturn(user);  
    	UserDatatobject secondUserDatatobject = userService.createUser(userDto);
        assertNotNull(userRepo);
        assertNotNull(secondUserDatatobject);
        Assertions.assertThat(userDto.getFullName()).isEqualTo(secondUserDatatobject.getFullName());
        
    }

    @Test
    public void testGetAll()  {
    	List<User> users = new ArrayList<User>();
    	users.add(user);
    	PageImpl<User> pageUsers = new PageImpl<User>(users);
    	
        when(userRepo.findAll(Mockito.any(Pageable.class))).thenReturn(pageUsers);  
        UserResponse response = userService.getAllUsers(0, 10, "id", "asc");
        assertNotNull(response);
        Assertions.assertThat(response.getContent().size()).isEqualTo(1);
        Assertions.assertThat(response.getContent().get(0).getFullName()).isEqualTo(userDto.getFullName());
    }

	
}
