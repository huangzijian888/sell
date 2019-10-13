package cn.huangzijian888.sell.repository;

import cn.huangzijian888.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCategoryRepositoryTest {
    @Autowired
    ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> option = repository.findById(1);
        if (option.isPresent()) {
            System.out.println(option.get());

        } else {
            System.out.println("查无此人");
        }
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = repository.findById(2).get();
        productCategory.setCategoryType(10);
        repository.save(productCategory);

    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 4);
        List<ProductCategory> categoryType = repository.findByCategoryTypeIn(list);
        for (ProductCategory category : categoryType) {
            System.out.println(category);
        }
        Assert.assertNotEquals(0, categoryType);
    }

}