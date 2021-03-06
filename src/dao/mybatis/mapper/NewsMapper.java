package dao.mybatis.mapper;

import dao.mybatis.model.News;
import dao.mybatis.model.NewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int countByExample(NewsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int deleteByExample(NewsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int insert(News record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int insertSelective(News record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	List<News> selectByExample(NewsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	News selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int updateByExampleSelective(@Param("record") News record,
			@Param("example") NewsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int updateByExample(@Param("record") News record,
			@Param("example") NewsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int updateByPrimaryKeySelective(News record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table RESTAURANT.NEWS
	 * @mbggenerated  Thu Nov 26 13:19:00 CAT 2015
	 */
	int updateByPrimaryKey(News record);
}