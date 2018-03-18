package com.lingang.utils.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lingang.greendao.BannerLocalDao;
import com.lingang.greendao.DaoMaster;
import com.lingang.greendao.SearchHistoryDao;
import com.lingang.greendao.StudentDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by jason on 17/7/12.
 * 重写数据库升级
 */
public class DBOpenHelper extends DaoMaster.OpenHelper {
    public DBOpenHelper(Context context, String name) {
        super(context, name);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        //数据库升级
        MigrationHelper.getInstance().migrate(db,
                SearchHistoryDao.class,
                StudentDao.class,
                BannerLocalDao.class);
    }
}
