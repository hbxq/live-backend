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

<#--查看明细弹窗-->
<#--<div class="Wbutton">-->
    <div class="listbox">
        <div class="headline">详情订单量</div>
        <table border="1" cellspacing="0">
            <thead>
            <th>订单号</th>
            <th>下单人</th>
            <th>时间</th>
            <th>服务费</th>
            <th>对账状态</th>
            <th>金额</th>
            </thead>
            <tfoot>
            <tr>
                <td class="total" colspan="6">合计:888</td>
            </tr>
            </tfoot>
            <tfoot>
            <tr>
                <td>8882323</td>
                <td>李四</td>
                <td>2018/6/91</td>
                <td>1</td>
                <td>未对账</td>
                <td>80</td>
            </tr>
            </tfoot>
            <tfoot>
            <tr>
                <td>8882323</td>
                <td>李四</td>
                <td>2018/6/91</td>
                <td>1</td>
                <td>未对账</td>
                <td>80</td>
            </tr>
            </tfoot>
        </table>
    </div>
<#--</div>-->
<#--查看明细弹窗-->

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

//        $('.btn-info').click(function (event) {
//            event.stopPropagation();
//            $('.listbox').toggle('slow');
//        });
//        $('.btn-info').click(function () { $('.listbox').fadeOut(200) });

        /* 分配用户角色  --查看明细弹窗 */
        $('#tablelist').on('click', '.btn-allot', function () {
//            event.stopPropagation();
            $('.listbox').toggle();
        });
            $('.btn-allot').click(function () { $('.listbox').fadeOut() });
    // 查看明细弹窗
    });
</script>
