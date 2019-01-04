package com.wangxiamomei.demo.Controller;

import com.wangxiamomei.demo.dao.ProductCategoryDao;
import com.wangxiamomei.demo.dataobject.productCategory;
import com.wangxiamomei.demo.exception.SellException;
import com.wangxiamomei.demo.form.CategoryForm;
import com.wangxiamomei.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map){
        List<productCategory> productCategoryList = categoryService.findAll();
        map.put("productCategoryList",productCategoryList);
        return new ModelAndView("category/lists",map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId" ,required = false) Integer categoryId,
                              Map<String,Object> map){
        if (categoryId != null){
            productCategory productCategory = categoryService.findById(categoryId);
            map.put("productCategory",productCategory);
        }
        return new ModelAndView("category/index",map);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        productCategory productcategory = new productCategory();
        try {
            if (form.getCategoryId() != null) {
                productcategory = categoryService.findById(form.getCategoryId());
            }
            BeanUtils.copyProperties(form, productcategory);
            categoryService.save(productcategory);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/category/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/seller/category/list");
        return new ModelAndView("common/success", map);
    }


}
