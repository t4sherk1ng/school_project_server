package com.samsung.rest.controller;

import com.samsung.domain.Author;
import com.samsung.domain.User;
import com.samsung.rest.dto.AuthorDto;
import com.samsung.rest.dto.UserDto;
import com.samsung.service.AuthorService;
import com.samsung.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserDto createNewUser(@RequestBody UserDto userDto) {

        User user = userService.insert(UserDto.toDomainObject(userDto));
        return UserDto.toDto(user);
    }

    @GetMapping("/user")
    public List<UserDto> getAllUsers() {

        return userService
                .getAll()
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable int id) {

        return UserDto.toDto(userService.getById(id));
    }

    @GetMapping("/user/name")
    public UserDto getAuthorByName(@RequestParam String name) {

        return UserDto.toDto(userService.getByName(name));
    }

    @PostMapping("/user/{id}/name")
    public UserDto updateUserById(
            @PathVariable int id,
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String phone,
            @RequestParam String city
    ) {

        return UserDto.toDto(
                userService.update(id, name, password, phone, city)
        );
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable int id) {

        userService.deleteById(id);
    }

}