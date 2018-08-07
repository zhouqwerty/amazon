package com.amazon.module.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.amazon.base.util.CommonUtil;
import com.amazon.module.constant.CommonValue;
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
        resultMap.put(CommonValue.PAGE_COUNT_KEY,pd.queryProductCountBySearch(params.getPpDto().getSearch()));
        //商品
        paramMap.put(CommonValue.PAGE_SEARCH_KEY,params.getPpDto().getSearch());
        paramMap.put(CommonValue.PAGE_START_KEY,params.getPage().getStart());
        paramMap.put(CommonValue.PAGE_END_KEY,params.getPage().getEnd());
        resultMap.put(CommonValue.PAGE_PRODUCT_KEY,pd.queryProductsBySearch(paramMap));
        return resultMap;
    }

    @Override
    public Map<String, Object> getProductPageByCategory(ParamsDto params) {
        Map<String,Object> paramMap=new HashMap<>();
        Map<String,Object> resultMap=new HashMap<>();
        paramMap.put(CommonValue.PAGE_START_KEY,params.getPage().getStart());
        paramMap.put(CommonValue.PAGE_END_KEY,params.getPage().getEnd());
        if(!CommonUtil.isNullOrEmpty(params.getPpDto().getCpcid())){
            resultMap.put(CommonValue.PAGE_COUNT_KEY,pd.queryProductCountByCpcid(params.getPpDto().getCpcid()));
            paramMap.put(CommonValue.PAGE_CID_KEY,params.getPpDto().getCpcid());
            resultMap.put(CommonValue.PAGE_PRODUCT_KEY,pd.queryProductsByCpcid(paramMap));
        }else if(!CommonUtil.isNullOrEmpty(params.getPpDto().getPcid())){
            resultMap.put(CommonValue.PAGE_COUNT_KEY,pd.queryProductCountByPcid(params.getPpDto().getPcid()));
            paramMap.put(CommonValue.PAGE_CID_KEY,params.getPpDto().getPcid());
            resultMap.put(CommonValue.PAGE_PRODUCT_KEY,pd.queryProductsByPcid(paramMap));
        }
        return resultMap;
    }

    @Override
    public Product getProductInfoByPid(ParamsDto params) {
        return pd.queryProductByPid(params);
    }

    /*--------------------------------------分割线（私有方法）------------------------------------------*/

    /**
     * @function 遍历商品分类表的递归方法
     * @param pcid 商品分类id
     * @return 根据pcid查询到的商品分类对象（封装成JSONArray）
     * @datetime 2018.8.2 19:16
     * */
    private JSONArray getProductCategory(String pcid){
        List<ProductCategory> parents=pcd.queryProductCategoryByParentId(pcid);
        JSONArray all=new JSONArray();
        if(!CommonUtil.isNullOrEmpty(parents)){
            for(ProductCategory pc:parents){
                JSONObject parent=new JSONObject();
                parent.put(CommonValue.PC_PCID_KEY,pc.getPc_id());
                parent.put(CommonValue.PC_NAME_KEY,pc.getName());
                JSONArray children=getProductCategory(pc.getPc_id());
                if(children!=null){
                    parent.put(CommonValue.PC_CHILDREN_KEY,children);
                }
                all.add(parent);
            }
            return all;
        }
        return null;
    }

}
