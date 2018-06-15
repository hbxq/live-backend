<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">对账管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                    </div>
                    <table id="tablelist">
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "/layout/footer.ftl"/>
<!--弹框-->
<div class="modal fade bs-example-modal-sm" id="selectRole" tabindex="-1" role="dialog" aria-labelledby="selectRoleLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="selectRoleLabel">对账明细</h4>
            </div>
            <div class="modal-body">
                <table id="ordertablelist">
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--/弹框-->
<script>
    /**
     * 操作按钮
     * @param code
     * @param row
     * @param index
     * @returns {string}
     */
    function operateFormatter(code, row, index) {
        var currentShopId = '${shop.id}';
        var trShopId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="bill:detail"><a class="btn btn-xs btn-info btn-allot" data-id="' + trShopId + '"><i class="fa fa-trash-o"></i>查看明细</a></@shiro.hasPermission>',
        ];
        if (currentShopId != trShopId) {
            operateBtn.push('<@shiro.hasPermission name="shop:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trShopId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>');
        }
        return operateBtn.join('');
    }

    $(function () {
        var options = {
            url: "/bill/list",
            getInfoUrl: "/bill/get/{id}",
            updateUrl: "/shop/edit",
            removeUrl: "/shop/remove",
            createUrl: "/shop/add",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'shopName',
                    title: '商家名称',
                    editable: false,
                }, {
                    field: 'mobile',
                    title: '手机',
                    editable: true
                }, {
                    field: 'address',
                    title: '地址',
                    editable: true
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ],
            modalName: "对账"
        };

        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);

        /* 分配用户角色 */
        $('#tablelist').on('click', '.btn-allot', function () {
            console.log("查看明细");
            var $this = $(this);
            var shopId = $this.attr("data-id");
            $.ajax({
                async: false,
                type: "POST",
                data: {shopId: shopId},
                url: '/shop/list',
                dataType: 'json',
                success: function (json) {
                    var data = json.data;
                    console.log(data);
                    $('#ordertablelist').bootstrapTable({
                        url: 'data1.json',
                        columns: [{
                            field: 'id',
                            title: 'Item ID'
                        }, {
                            field: 'name',
                            title: 'Item Name'
                        }, {
                            field: 'price',
                            title: 'Item Price'
                        }, ]
                    });
                }
            });
        });
    });
</script>