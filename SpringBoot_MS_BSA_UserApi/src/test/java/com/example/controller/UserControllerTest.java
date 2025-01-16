package com.example.controller;

import com.example.dto.DtoToUserEntity;
import com.example.dto.UserLoginRequestDto;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.TokenUtility;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @Mock
    private TokenUtility tokenUtility;

    @Test
    void testUserRegistration_Success() throws Exception {
        // Arrange
        DtoToUserEntity dto = new DtoToUserEntity();
        dto.setFirstName("Saurabh");
        dto.setLastName("Nimje");
        dto.setDob(LocalDate.parse("1993-06-23"));
        dto.setEmail("saurabhnimje02@example.com");
        dto.setPassword("saurabh@123");
        dto.setRole("ADMIN");

        when(userService.userRegistration(any(DtoToUserEntity.class)))
                .thenReturn("User registered successfully");

        // Act & Assert
        mockMvc.perform(post("/user/userRegistration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"firstName\":\"Saurabh\",\"lastName\":\"Nimje\",\"dob\":\"1993-06-23\",\"email\":\"saurabhnimje02@example.com\",\"password\":\"saurabh@123\",\"role\":\"ADMIN\"}"))
                .andExpect(status().isCreated())
                .andExpect(content().string("User registered successfully"));

        verify(userService, times(1)).userRegistration(any(DtoToUserEntity.class));
    }

    @Test
    void testAuthenticateUser_Success() throws Exception {
        // Arrange
        UserLoginRequestDto requestDto = new UserLoginRequestDto();
        requestDto.setEmail("test@example.com");
        requestDto.setPassword("password123");

        User mockUser = new User();
        mockUser.setUserId(1L);
        mockUser.setRole("ADMIN");

        when(userService.loginService(any(UserLoginRequestDto.class))).thenReturn(Optional.of(mockUser));
        when(tokenUtility.createToken(mockUser.getUserId(), mockUser.getRole())).thenReturn("mockToken");

        // Act & Assert
        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\",\"password\":\"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"token\":\"mockToken\"}"));

        verify(userService, times(1)).loginService(any(UserLoginRequestDto.class));
        verify(tokenUtility, times(1)).createToken(mockUser.getUserId(), mockUser.getRole());
    }

    @Test
    void testAuthenticateUser_InvalidCredentials() throws Exception {
        // Arrange
        UserLoginRequestDto requestDto = new UserLoginRequestDto();
        requestDto.setEmail("test@example.com");
        requestDto.setPassword("wrongPassword");

        when(userService.loginService(any(UserLoginRequestDto.class))).thenReturn(Optional.empty());

        // Act & Assert
        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\",\"password\":\"wrongPassword\"}"))
                .andExpect(status().isAccepted())
                .andExpect(content().string("User NOT login"));

        verify(userService, times(1)).loginService(any(UserLoginRequestDto.class));
        verifyNoInteractions(tokenUtility);
    }

    @Test
    void testAuthenticateUser_ExceptionThrown() throws Exception {
        // Arrange
        UserLoginRequestDto requestDto = new UserLoginRequestDto();
        requestDto.setEmail("test@example.com");
        requestDto.setPassword("password123");

        when(userService.loginService(any(UserLoginRequestDto.class))).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        mockMvc.perform(post("/user/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"email\":\"test@example.com\",\"password\":\"password123\"}"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("An error occurred during login: Database error"));

        verify(userService, times(1)).loginService(any(UserLoginRequestDto.class));
        verifyNoInteractions(tokenUtility);
    }
}
