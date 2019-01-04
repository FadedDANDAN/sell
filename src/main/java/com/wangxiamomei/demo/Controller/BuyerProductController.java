package com.wangxiamomei.demo.Controller;

import com.wangxiamomei.demo.Utils.ResultVOUtil;
import com.wangxiamomei.demo.VO.ProductInfoVO;
import com.wangxiamomei.demo.VO.ProductorVO;
import com.wangxiamomei.demo.VO.ResultVO;
import com.wangxiamomei.demo.dataobject.ProductInfo;
import com.wangxiamomei.demo.dataobject.productCategory;
import com.wangxiamomei.demo.service.CategoryService;
import com.wangxiamomei.demo.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){

        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询完）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType()).collect(Collectors.toList());
        List<productCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);


        //3.数据拼接
        List<ProductorVO> productorVOS = new ArrayList<>();
        for (productCategory productcategory : productCategoryList){
            ProductorVO productorVO = new ProductorVO();
            productorVO.setCategoryType(productcategory.getCategoryType());
            productorVO.setCategoryName(productcategory.getCategoryName());

            List<ProductInfoVO> productinVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList){

                if (productcategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productinVOList.add(productInfoVO);
                }
            }
            productorVO.setProductInfoVOList(productinVOList);
            productorVOS.add(productorVO);
        }

        return ResultVOUtil.success(productorVOS);

    }
}
