package com.sathish.am.idao;

import java.util.List;

import com.sathish.am.pojo.AssetPojo;

public interface Iassetdao {
	public abstract void delRecord(AssetPojo pojo);
	public abstract List<AssetPojo> getAllRec();
	public abstract AssetPojo getRecord(Integer id);
	public abstract void insertAsset(AssetPojo pojo);
}
