<!DOCTYPE html>
<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏的样式-->
    <#include "../common/nav.ftl">

<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="col-md-12 column">
                <form role="form" method="post" action="/sell/seller/product/save">
                    <div class="form-group">
                        <label>名称</label>
                        <input name="productName" class="form-control" value="${(productInfo.productName)!''}" />
                    </div>
                    <div class="form-group">
                        <label>价格</label>
                        <input name="productPrice" class="form-control" value="${(productInfo.productPrice)!''}"/>
                    </div>
                    <div class="form-group">
                        <label>库存</label>
                        <input name="productStock" class="form-control" value="${(productInfo.productStock)!''}"/>
                    </div>
                    <div class="form-group">
                        <label>描述</label>
                        <input name="productDescription" class="form-control" value="${(productInfo.productDescription)!''}"/>
                    </div>
                    <div class="form-group">
                        <label>图片</label>
                        <img height="200" width="200" src="${(productInfo.productIcon)!''}" rel="">
                        <input name="productIcon" class="form-control" value="${(productInfo.productIcon)!''}" />
                    </div>
                    <div class="form-group">
                        <label>类目</label>
                        <select name="categoryType" class="form-control">
                            <#list productCategoryList as productcategory>
                                <option value="${productcategory.categoryType}"
                                        <#if (productInfo.categoryType)?? && productInfo.categoryType == productcategory.categoryType>
                                            selected
                                        </#if>
                                    >${productcategory.categoryName}
                                </option>
                            </#list>
                        </select>
                    </div>
                    <input hidden name="productId" value="${(productInfo.productId)!''}">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>