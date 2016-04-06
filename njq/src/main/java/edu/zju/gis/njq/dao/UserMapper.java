package edu.zju.gis.njq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.zju.gis.njq.entity.User;

public interface UserMapper {
	@Delete({
	 "delete from user_test", 
		"where id = #{0}" 
	})
	int deleteByPrimaryKey(Integer id);

	@Insert({ "insert into user_test (id, name, ", "password)",
			"values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ", "#{password,jdbcType=VARCHAR})" })
	int insert(User record);

	int insertSelective(User record);

	@Select({ "select", "id, name, password", "from user_test", "where id = #{id,jdbcType=INTEGER}" })
	@ResultMap("BaseResultMap")
	User selectByPrimaryKey(Integer id);

	@Select({ "select * from user_test ",
		"limit #{1} offset #{0}" 
	})
	@ResultMap("BaseResultMap")
	List<User> selectAllUsers(Integer offset, Integer rows);

	@Select({ "select count(*) from user_test" })
	int selectCountUsers();

	int updateByPrimaryKeySelective(User record);

	@Update({ "update user_test", "set name = #{name,jdbcType=VARCHAR},", "password = #{password,jdbcType=VARCHAR}",
			"where id = #{id,jdbcType=INTEGER}" })
	int updateByPrimaryKey(User record);
}