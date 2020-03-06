package top.ke1205.usermanage.mapper;

import org.apache.ibatis.annotations.Param;
import top.ke1205.usermanage.pojo.User;

import java.util.List;

public interface UserMapper {
    public User queryUserById(Long id);

    public Long queryTotal();

    public List<User> queryUserAll();

    public int insertUser(User user);

    public int updateUser(User user);

    public int deleteUsersByIds(@Param("ids") List<Long> ids);
}
