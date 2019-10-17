package cn.huangzijian888.sell.form;

import lombok.Data;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 16:11
 */
@Data
public class CategoryForm {

    /**
     * 类目id.
     */
    private Integer categoryId;

    /**
     * 类目名称.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
