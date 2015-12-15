package service.manage.news;

import java.util.List;

import dao.mybatis.mapper.NewsMapper;
import dao.mybatis.model.News;

public class NewsService{
	NewsMapper newsMapper;

	public NewsMapper getNewsMapper() {
		return newsMapper;
	}

	public void setNewsMapper(NewsMapper newsMapper) {
		this.newsMapper = newsMapper;
	}

	
	public String addSingleNews(News news) {
		// TODO Auto-generated method stub
		String result = "";
		int res = this.newsMapper.insertSelective(news);
		if (res > 0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	
	public News getSingleNews(News news) {// only use newsid
		// TODO Auto-generated method stub
		return this.newsMapper.selectByPrimaryKey(news.getId());
	}

	
	public String updateSingleNews(News news) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.newsMapper.updateByPrimaryKeySelective(news);
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public String deleteSingleNews(News news) {//only use newsid
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.newsMapper.deleteByPrimaryKey(news.getId());
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public List<News> getListOfNews(News news) {
		// TODO Auto-generated method stub
		return null;
	}


}
