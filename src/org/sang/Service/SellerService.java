package org.sang.Service;

import org.sang.Dao.Insert_seller;
import org.sang.Beans.Seller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Komachi on 2017/5/19.
 */
@Service
public class SellerService {
    @Resource
    Insert_seller insert_seller;

    public int register(Seller seller){
        return insert_seller.add_seller(seller);
    }
}
