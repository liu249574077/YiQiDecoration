package com.yqd.yiqi.Mosaic;

import com.finesdk.util.common.StringUtil;

/**
 * Created by Administrator on 2017/1/10.
 */

public class MosaicURL {
   public static final String BASE_STR="http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid=1216903&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1\n";
   public static final String BASE_STR1="http://bbs.17house.com/motnt/index.php?a=viewThread&c=forumThread&imgwidth=330&uuid=86305803367590&tid=";
   public static final String BASE_STR2="&m=forum&haspermission=yes&model=android&app_version=android_com.aiyiqi.galaxy_1.1\n";
   StringBuffer str_URL;
    public MosaicURL() {
    }
    public String getStrURL(String str){
        str_URL=new StringBuffer();
        str_URL.append(BASE_STR1);
        str_URL.append(str);
        str_URL.append(BASE_STR2);
        return str_URL.toString();
    }
}
