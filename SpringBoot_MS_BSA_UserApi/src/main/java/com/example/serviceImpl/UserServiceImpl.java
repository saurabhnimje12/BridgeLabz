package com.example.serviceImpl;

import com.example.dto.DtoToUserEntity;
import com.example.dto.UserEntityToDto;
import com.example.dto.UserLoginRequestDto;
import com.example.entity.User;
import com.example.exception.CustomiseException;
import com.example.repo.UserRepo;
import com.example.service.UserService;
import com.example.utils.EmailUtils;
import com.example.utils.TokenUtility;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;
    @Autowired
    public TokenUtility tokenUtility;
    @Autowired
    private EmailUtils emailUtils;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @CircuitBreaker(name = "userCircuitBreaker",fallbackMethod = "userRegistrationFallback")
    @Override
    public String userRegistration(DtoToUserEntity dtoToUserEntity) {
        User user = dtoToUserConverter(dtoToUserEntity);
        if(userRepo.findByEmail(user.getEmail()).isPresent()){
            return "User Already Exist | Please, Try with Different Email";
        }
        user.setRegistrationDate(LocalDate.now());
        user.setUpdateDate(LocalDate.now());
        userRepo.save(user);
        emailUtils.sendEmail(user.getEmail(), "Book Store Application", "Hello, "+user.getFirstName()+" Welcome To Book Store Application, Your Registration was Successfully!!!" );
        return "User Added Successfully!!";
    }

    public String userRegistrationFallback(Exception exception){
        return "Please Try After Some Time!!";
    }

    @Override
    public Optional<User> loginService(UserLoginRequestDto userLoginRequestDto) {
        return userRepo.findByEmailAndPassword(userLoginRequestDto.getEmail(), userLoginRequestDto.getPassword());
    }

    @Override
    public UserEntityToDto getUser(Long userId) {
        return userToDtoConverter(userRepo.findById(userId).orElseThrow(() -> new CustomiseException("User Not Found with this Token!! ")));
    }

    @Override
    public String updateUser(Long userId, DtoToUserEntity dtoToUserEntity) {
        User user = userRepo.findById(userId).orElseThrow(() -> new CustomiseException("User Not Found with this Token!!"));

        User userConverter = dtoToUserConverter(dtoToUserEntity);

        user.setFirstName(userConverter.getFirstName());
        user.setLastName(userConverter.getLastName());
        user.setDob(userConverter.getDob());
        user.setUpdateDate(LocalDate.now());
        user.setEmail(userConverter.getEmail());
        user.setPassword(userConverter.getPassword());
        user.setRole(userConverter.getRole());
        userRepo.save(user);
        return "User Updated Successfully!!";
    }

    @Override
    public String deleteUser(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new CustomiseException("User Not Found with this Token!! "));
        userRepo.deleteById(user.getUserId());
        return "User Deleted Successfully!!";
    }

    @Override
    public List<UserEntityToDto> getAllUser() {
        List<User> list = userRepo.findAll();
        return list.stream().map(this::userToDtoConverter).collect(Collectors.toList());
    }

    @Override
    public Long tokenToId(String authorization) {
        return tokenUtility.getEmpIdFromToken(authorization);
    }


    private User dtoToUserConverter(DtoToUserEntity dtoToUserEntity) {
        User user = new User();
        user.setFirstName(dtoToUserEntity.getFirstName());
        user.setLastName(dtoToUserEntity.getLastName());
        user.setDob(dtoToUserEntity.getDob());
        user.setEmail(dtoToUserEntity.getEmail());
        user.setPassword(dtoToUserEntity.getPassword());
        user.setRole(dtoToUserEntity.getRole());
        return user;
    }

    private UserEntityToDto userToDtoConverter(User user) {
        UserEntityToDto userEntityToDto = new UserEntityToDto();
        userEntityToDto.setUserId(user.getUserId());
        userEntityToDto.setFirstName(user.getFirstName());
        userEntityToDto.setLastName(user.getLastName());
        userEntityToDto.setDob(user.getDob());
        userEntityToDto.setRegistrationDate(user.getRegistrationDate());
        userEntityToDto.setUpdateDate(user.getUpdateDate());
        userEntityToDto.setEmail(user.getEmail());
        userEntityToDto.setPassword(user.getPassword());
        userEntityToDto.setRole(user.getRole());
        return userEntityToDto;
    }
}

