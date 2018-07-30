package com.amazon.module.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amazon.base.util.CommonUtil;
import com.amazon.module.dao.ProductCategoryDao;
import com.amazon.module.dao.ProductDao;
import com.amazon.module.entity.ProductCategory;
import com.amazon.module.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao pd;
    @Autowired
    private ProductCategoryDao pcd;

    @Override
    public JSONArray getProductCategory() {
        return getProductCategory(null);
    }

    private JSONArray getProductCategory(String pcid){
        List<ProductCategory> parents=pcd.queryProductCategoryByParentId(pcid);
        JSONArray all=new JSONArray();
        if(!CommonUtil.isNullOrEmpty(parents)){
            for(ProductCategory pc:parents){
                JSONObject parent=new JSONObject();
                parent.put("pcid",pc.getPc_id());
                parent.put("name",pc.getName());
                JSONArray children=getProductCategory(pc.getPc_id());
                if(children!=null){
                    parent.put("children",children);
                }
                all.add(parent);
            }
            return all;
        }
        return null;
    }

}
