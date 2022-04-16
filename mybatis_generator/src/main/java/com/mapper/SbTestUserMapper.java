package springboot10.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import springboot10.pojo.SbTestUser;
import springboot10.pojo.SbTestUserExample;

public interface SbTestUserMapper {
    long countByExample(SbTestUserExample example);

    int deleteByExample(SbTestUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SbTestUser record);

    int insertSelective(SbTestUser record);

    List<SbTestUser> selectByExample(SbTestUserExample example);

    SbTestUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SbTestUser record, @Param("example") SbTestUserExample example);

    int updateByExample(@Param("record") SbTestUser record, @Param("example") SbTestUserExample example);

    int updateByPrimaryKeySelective(SbTestUser record);

    int updateByPrimaryKey(SbTestUser record);
}