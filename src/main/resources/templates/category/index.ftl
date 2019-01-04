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
                <form role="form" method="post" action="/sell/seller/category/save">
                    <div class="form-group">
                        <label>名字</label>
                        <input name="categoryName" class="form-control" value="${(productCategory.categoryName)!''}" />
                    </div>
                    <div class="form-group">
                        <label>type</label>
                        <input name="categoryType" class="form-control" value="${(productCategory.categoryType)!''}" />
                    </div>
                    <input hidden name="categoryId" value="${(productCategory.categoryId)!''}">
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>


</body>
</html>