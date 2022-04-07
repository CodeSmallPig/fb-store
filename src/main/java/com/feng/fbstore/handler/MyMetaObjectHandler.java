package com.feng.fbstore.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by FengBin on 2021/4/24 15:44
 * 自定义一个处理器,实现MetaObjectHandler
 */
@Slf4j
@Component   //将MyMetaObjectHandler组件加入到IOC容器中
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //插入时的填充策略
        //log.info("start to insert fill...");
        //setFieldValByName(String fieldName, Object fieldVal, MetaObject metaObject)
        //boolean createTime = metaObject.hasSetter("createTime");
        //boolean updateTime = metaObject.hasSetter("updateTime");
        //SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        //bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //更新时的填充策略
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
