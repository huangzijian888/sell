package cn.huangzijian888.sell.service.impl;

import cn.huangzijian888.sell.dataobject.ProductCategory;
import cn.huangzijian888.sell.enums.ResultEnum;
import cn.huangzijian888.sell.exception.SellException;
import cn.huangzijian888.sell.repository.ProductCategoryRepository;
import cn.huangzijian888.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangzijian888
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductCategoryRepository repository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);

    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategory category;
        try {
            category = repository.save(productCategory);
        } catch (Exception e) {
            throw new SellException(ResultEnum.UNKNOWN_MISTAKE.getCode(), "SQL执行错误");
        }
        return category;
    }
}
