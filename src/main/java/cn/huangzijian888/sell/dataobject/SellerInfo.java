package cn.huangzijian888.sell.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author: huangzijian888
 * @date: 2019/10/17 17:07
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SellerInfo {
    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
}
