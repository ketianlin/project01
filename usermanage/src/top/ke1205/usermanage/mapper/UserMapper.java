package top.ke1205.usermanage.mapper;

import top.ke1205.usermanage.pojo.User;

import java.util.List;

public interface UserMapper {
    public User queryUserById(Long id);

    public Long queryTotal();

    public List<User> queryUserAll();

}
