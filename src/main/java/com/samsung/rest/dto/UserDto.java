package com.samsung.rest.dto;

import com.samsung.domain.Genre;
import com.samsung.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    private String name;

    private String password;

    private String phone;

    private String city;

    public static User toDomainObject(UserDto userDto) {

        return new User(userDto.getId(), userDto.getName(), userDto.getPassword(), userDto.getPhone(), userDto.getCity());
    }

    public static UserDto toDto(User user) {

        return new UserDto(user.getId(), user.getName(), user.getPassword(), user.getPhone(), user.getCity());
    }

}