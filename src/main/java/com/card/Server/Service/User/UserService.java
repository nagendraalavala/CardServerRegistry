package com.card.Server.Service.User;

import com.card.Server.Entity.User.UserEntity;
import com.card.Server.Repository.User.UserRepository;
import com.card.Server.types.User.UserDAO;
import com.card.Server.types.User.UserDTO;
import com.card.Server.types.User.UserResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepo;
    private ModelMapper modelMapper;
    private UserDAO userDAO;
    private UserDTO userDTO;
    private UserResponse userResponse;
    private UserEntity userEntity;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
        this.modelMapper = new ModelMapper();
        this.userDAO = new UserDAO();
        this.userDTO = new UserDTO();
        this.userResponse = new UserResponse();
        this.userEntity = new UserEntity();
    }

    public ResponseEntity<Object> saveUser(UserDTO userDTO)
    {
        UserEntity userInfo = modelMapper.map(userDTO, UserEntity.class);
        logger.info("UserInfo mapped to entity" + userInfo );
        UserEntity checkUserName = userRepo.findByuserName(userInfo.getUserName());
        if(checkUserName == null)
        {
            if(!userInfo.getUserPassword().equals(userInfo.getUserConfirmPassword()))
            {
                return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password and ConfirmPassword Not Matched");
            }
            else {
                logger.info("Inside else");
                userInfo.setStatus("Active");
                userRepo.save(userInfo);
                logger.info("Userinfo saved in db");
                userDAO.setMessage("Thanks for creating the account. Please confirm your email address");
            }
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username Already Exist. Please try new one");
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(userDAO);
    }

    public List<UserResponse> findAllUsers() {
        List<UserEntity> userEntitys = userRepo.findAll();
        logger.info(String.valueOf("userEntity: " + userEntity));
        List<UserResponse> response = userEntitys.stream().map(userEntity ->modelMapper.map(userEntity, UserResponse.class)).collect(Collectors.toList());
        logger.info("Response: " + response);
        return response;
    }

    public Object findUserById(Long id)
    {
        Optional<UserEntity> getUser = userRepo.findById(id);
        UserEntity entity = getUser.get();
        if(getUser.isPresent())
        {
            UserResponse userResponse = modelMapper.map(entity, UserResponse.class);
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not Found");
        }
    }


}
