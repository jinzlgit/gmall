package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {
    /**
     * 获取一级分类列表
     *
     * @return
     */
    List<PmsBaseCatalog1> getCatalog1();

    /**
     * 根据一级分类ID获取二级分类列表
     *
     * @param catalog1Id
     * @return
     */
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级分类ID获取三级分类列表
     *
     * @param catalog2Id
     * @return
     */
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
