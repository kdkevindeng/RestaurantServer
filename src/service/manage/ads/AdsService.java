package service.manage.ads;

import java.util.List;

import dao.mybatis.mapper.AdsMapper;
import dao.mybatis.model.Ads;

public class AdsService {
	AdsMapper adsMapper;

	public AdsMapper getAdsMapper() {
		return adsMapper;
	}

	public void setAdsMapper(AdsMapper adsMapper) {
		this.adsMapper = adsMapper;
	}

	
	public String addSingleAds(Ads ads) {
		// TODO Auto-generated method stub
		String result = "";
		int res = this.adsMapper.insertSelective(ads);
		if (res > 0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	
	public Ads getSingleAds(Ads ads) {// only use adsid
		// TODO Auto-generated method stub
		return this.adsMapper.selectByPrimaryKey(ads.getId());
	}

	
	public String updateSingleAds(Ads ads) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.adsMapper.updateByPrimaryKeySelective(ads);
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public String deleteSingleAds(Ads ads) {//only use adsid
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.adsMapper.deleteByPrimaryKey(ads.getId());
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public List<Ads> getListOfAds(Ads ads) {
		// TODO Auto-generated method stub
		return null;
	}


}
