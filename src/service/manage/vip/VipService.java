package service.manage.vip;

import java.util.List;

import dao.mybatis.mapper.VipMapper;
import dao.mybatis.model.Vip;

public class VipService{
	VipMapper vipMapper;

	public VipMapper getVipMapper() {
		return vipMapper;
	}

	public void setVipMapper(VipMapper vipMapper) {
		this.vipMapper = vipMapper;
	}

	
	public String addSingleVip(Vip vip) {
		// TODO Auto-generated method stub
		String result = "";
		int res = this.vipMapper.insertSelective(vip);
		if (res > 0) {
			result = "success";
		} else {
			result = "failed";
		}
		return result;
	}

	
	public Vip getSingleVip(Vip vip) {// only use vipid
		// TODO Auto-generated method stub
		return this.vipMapper.selectByPrimaryKey(vip.getId());
	}

	
	public String updateSingleVip(Vip vip) {
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.vipMapper.updateByPrimaryKeySelective(vip);
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public String deleteSingleVip(Vip vip) {//only use vipid
		// TODO Auto-generated method stub
		String result = "";
		int ret = this.vipMapper.deleteByPrimaryKey(vip.getId());
		if (ret > 0) {
			result="success";
		} else {
			result="failed";
		}
		return result;
	}

	
	public List<Vip> getListOfVip(Vip vip) {
		// TODO Auto-generated method stub
		return null;
	}

}
