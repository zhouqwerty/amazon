package com.amazon.module.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amazon.base.util.CommonUtil;
import com.amazon.module.dao.ProductCategoryDao;
import com.amazon.module.dao.ProductDao;
import com.amazon.module.dto.ParamsDto;
import com.amazon.module.entity.Product;
import com.amazon.module.entity.ProductCategory;
import com.amazon.module.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getProductPageBySearch(ParamsDto params) {
        Map<String,Object> paramMap=new HashMap<>();
        Map<String,Object> resultMap=new HashMap<>();
        //数量
        resultMap.put("count",pd.queryProductCountBySearch(params.getSearch()));
        //商品
        paramMap.put("search",params.getSearch());
        paramMap.put("start",params.getPage().getStart());
        paramMap.put("end",params.getPage().getEnd());
        resultMap.put("product",pd.queryProductsBySearch(paramMap));
        return resultMap;
    }

    @Override
    public Map<String, Object> getProductPageByCategory(ParamsDto params) {
        Map<String,Object> paramMap=new HashMap<>();
        Map<String,Object> resultMap=new HashMap<>();
        paramMap.put("start",params.getPage().getStart());
        paramMap.put("end",params.getPage().getEnd());
        if(!CommonUtil.isNullOrEmpty(params.getpCate().getPcid())){
            resultMap.put("count",pd.queryProductCountByPcid(params.getpCate().getPcid()));
            paramMap.put("cid",params.getpCate().getPcid());
            resultMap.put("product",pd.queryProductsByPcid(paramMap));
        }else if(!CommonUtil.isNullOrEmpty(params.getpCate().getCpcid())){
            resultMap.put("count",pd.queryProductCountByCpcid(params.getpCate().getCpcid()));
            paramMap.put("cid",params.getpCate().getCpcid());
            resultMap.put("product",pd.queryProductsByCpcid(paramMap));
        }
        return resultMap;
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
