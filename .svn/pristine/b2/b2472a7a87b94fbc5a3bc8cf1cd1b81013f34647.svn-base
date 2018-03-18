package com.lingang.common;

import com.lingang.App;
import com.lingang.bean.BannerLocal;
import com.lingang.greendao.BannerLocalDao;
import com.lingang.greendao.DaoSession;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 17/7/12.
 */

public class BannerLocalManager {

    private DaoSession daoSession;
    private BannerLocalDao bannerLocalDao;
    /**
     * 单例
     */
    private static BannerLocalManager  instance;
    public static BannerLocalManager getInstance() {
        if (null == instance) {
            synchronized (BannerLocalManager.class) {
                if (null == instance) {
                    instance = new BannerLocalManager();
                }
            }
        }
        return instance;
    }

    /**
     *构造初始化BannerLocalDao
     */
    public BannerLocalManager() {
        daoSession = App.getInstance().getDaoSession();
        bannerLocalDao=daoSession.getBannerLocalDao();
    }

    /**
     * 清楚所有本地数据
     */
    public void clearBannerLocal()
    {
        //考虑本地图片删除,对比只删除修改数据的图片，后期考虑
        if(bannerLocalDao !=null)
        {
            bannerLocalDao.deleteAll();
        }
    }
    /**
     * 返回所有数据
     * @return
     */
    public List<BannerLocal> getAll()
    {
        if(bannerLocalDao !=null) {
            return bannerLocalDao.loadAll();
        }else{
            return new ArrayList<BannerLocal>();
        }
    }

    /**
     * 添加数据
     * @param bannerLocal
     */
    public void save(BannerLocal bannerLocal)
    {
        if(bannerLocalDao !=null)
        {
            bannerLocalDao.save(bannerLocal);
        }
    }
}
