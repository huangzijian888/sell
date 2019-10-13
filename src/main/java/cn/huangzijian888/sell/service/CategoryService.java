package cn.huangzijian888.sell.service;

import cn.huangzijian888.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @author huangzijian888
 */
public interface CategoryService {

    /**
     * 根据id查询
     *
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     *
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目编号数组查询
     *
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 保存
     *
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
