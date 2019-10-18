package cn.huangzijian888.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: huangzijian888
 * @date: 2019/10/13 17:48
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -3459058004450182507L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;

    public ProductVO(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductVO(String categoryName, Integer categoryType, List<ProductInfoVO> productInfoVOList) {
        this(categoryName, categoryType);
        this.productInfoVOList = productInfoVOList;
    }
}
