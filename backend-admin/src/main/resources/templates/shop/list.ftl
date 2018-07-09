<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">商家管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">
                <div class="<#--table-responsive-->">
                    <div class="btn-group hidden-xs" id="toolbar">
                        <@shiro.hasPermission name="shop:add">
                        <button id="btn_add" type="button" class="btn btn-default" title="新增商家">
                            <i class="fa fa-plus"></i> 新增商家
                        </button>
                        </@shiro.hasPermission>
                        <@shiro.hasPermission name="shop:batchDelete">
                            <button id="btn_delete_ids" type="button" class="btn btn-default" title="删除选中">
                                <i class="fa fa-trash-o"></i> 批量删除
                            </button>
                        </@shiro.hasPermission>
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
                <h4 class="modal-title" id="selectRoleLabel">分配角色</h4>
            </div>
            <div class="modal-body">
                <form id="boxRoleForm">
                    <div class="zTreeDemoBackground left">
                        <ul id="treeDemo" class="ztree"></ul>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--/弹框-->
<!--添加用户弹框-->
<div class="modal fade" id="addOrUpdateModal" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">添加商家</h4>
            </div>
            <div class="modal-body">
                <form id="addOrUpdateForm" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shopName">商户名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="shopName" id="shopName" required="required" placeholder="请输入商户名称"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="mobile">手机号: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="mobile" name="mobile" required="required" placeholder="请输入联系手机号"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">地址:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="address" id="address" placeholder="请输入地址"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logoUrl">主图:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="logoUrl" id="logoUrl" data-validate-length-range="8,500" placeholder="请输入主图地址"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shopInfo">商家简介:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="shopInfo" id="shopInfo" placeholder="请输入商家简介"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="city">城市:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="city" id="city" placeholder="请输入城市"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary addOrUpdateBtn">保存</button>
            </div>
        </div>
    </div>
</div>
<!--/添加用户弹框-->
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
            '<@shiro.hasPermission name="shop:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trShopId + '"><i class="fa fa-edit"></i>编辑</a></@shiro.hasPermission>',
        ];
        if (currentShopId != trShopId) {
            operateBtn.push('<@shiro.hasPermission name="shop:delete"><a class="btn btn-xs btn-danger btn-remove" data-id="' + trShopId + '"><i class="fa fa-trash-o"></i>删除</a></@shiro.hasPermission>');
            operateBtn.push('<@shiro.hasPermission name="shop:allotRole"><a class="btn btn-xs btn-info btn-allot" data-id="' + trShopId + '"><i class="fa fa-circle-thin"></i>分配角色</a></@shiro.hasPermission>')
        }
        return operateBtn.join('');
    }

    $(function () {
        var options = {
            url: "/shop/list",
            getInfoUrl: "/shop/get/{id}",
            updateUrl: "/shop/edit",
            removeUrl: "/shop/remove",
            createUrl: "/shop/add",
            saveRolesUrl: "/shop/saveUserRoles",
            queryParams :function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                var tamp =  {
                    pageSize: params.limit, // 每页要显示的数据条数
                    offset: params.offset, // 每页显示数据的开始行号
                    keywords:params.searchText?params.searchText:"",
                   /* beginTime:$("#startDate").val()?$("#startDate").val():"",
                    endTime:$("#endDate").val()?$("#endDate").val():""*/
                };
                return tamp;
            },
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'shopName',
                    title: '商家名称',
                    editable: false
                }, {
                    field: 'mobile',
                    title: '手机',
                    editable: true
                }, {
                    field: 'address',
                    title: '地址',
                    editable: true
                }, {
                    field: 'logoUrl',
                    title: '主图URL',
                    editable: false
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    editable: false,
                    formatter: function (code) {
                        return new Date(code).format("yyyy-MM-dd hh:mm:ss")
                    }
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ]
        };

        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);

        /* 分配用户角色 */
        $('#tablelist').on('click', '.btn-allot', function () {
            console.log("分配权限");
            var $this = $(this);
            var userId = $this.attr("data-id");
            $.ajax({
                async: false,
                type: "POST",
                data: {uid: userId},
                url: '/roles/rolesWithSelected',
                dataType: 'json',
                success: function (json) {
                    var data = json.data;
                    console.log(data);
                    var setting = {
                        check: {
                            enable: true,
                            chkboxType: {"Y": "ps", "N": "ps"},
                            chkStyle: "radio"
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        },
                        callback: {
                            onCheck: function (event, treeId, treeNode) {
                                console.log(treeNode.tId + ", " + treeNode.name + "," + treeNode.checked);
                                var treeObj = $.fn.zTree.getZTreeObj(treeId);
                                var nodes = treeObj.getCheckedNodes(true);
                                var ids = new Array();
                                for (var i = 0; i < nodes.length; i++) {
                                    //获取选中节点的值
                                    ids.push(nodes[i].id);
                                }
                                console.log(ids);
                                console.log(userId);
                                $.post(options.saveRolesUrl, {"userId": userId, "roleIds": ids.join(",")}, function (obj) {
                                }, 'json');
                            }
                        }
                    };
                    var tree = $.fn.zTree.init($("#treeDemo"), setting, data);
                    tree.expandAll(true);//全部展开

                    $('#selectRole').modal('show');
                }
            });
        });
    });
</script>