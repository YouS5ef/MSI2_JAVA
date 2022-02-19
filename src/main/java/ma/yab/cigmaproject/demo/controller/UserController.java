package ma.yab.cigmaproject.demo.controller;

import ma.yab.cigmaproject.domain.dataTobject.UserDatatobject;
import ma.yab.cigmaproject.domain.dataTobject.UserResponse;
import ma.yab.cigmaproject.domain.Serv.UserService;
import ma.yab.cigmaproject.demo.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create blog user rest api
    @PostMapping
    public ResponseEntity<UserDatatobject> createUser(@RequestBody UserDatatobject userDatatobject){
        return new ResponseEntity<>(userService.createUser(userDatatobject), HttpStatus.CREATED);
    }

    // get all users rest api
    @GetMapping
    public UserResponse getAllUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }

}