<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">订单管理</li>
        </ol>
        <div class="x_panel">
            <div class="x_content">


                <div class="row">

                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">开始时间</span>
                            <input type="text" id="calendar" placeholder="test" class="form-control">
                            <#--<input type="text" id="calendar1" placeholder="test" class="form-control">-->
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">结束时间</span>
                            <input type="text" id="calendar2" placeholder="test" class="form-control">
                            <#--<input type="text" id="calendar3" placeholder="test" class="form-control">-->
                        </div>
                    </div>
                </div>



                <div class="input-group dropdown col-lg-3  pull-left">
                    <span class="input-group-addon">输入店铺名称搜索</span>
                    <input type="text" class="form-control" id="shop_name">
                </div>

                <div class="dropdown pull-left">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">订单类型
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="order_type">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" id="-1" href="#">Java</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="1" id="1" href="#">数据挖掘</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="2" id="2" href="#">数据通信/网络</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown pull-left">
                    <button type="button" class="btn dropdown-toggle" id="dropdownMenu12" data-toggle="dropdown">订单状态
                        <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu12" id="order_status">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" id="-1" href="#">订单状态1</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="1" id="1" href="#">订单状态2</a>
                        </li>
                        <li role="presentation">
                            <a role="menuitem" tabindex="2" id="2" href="#">订单状态3</a>
                        </li>
                    </ul>
                </div>


                <button type="button" class="btn btn-primary" id="search">搜索</button>
                <div class="<#--table-responsive-->">
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shopName">订单号: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="shopName" id="shopName" required="required" placeholder="请输入商户名称" />
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="mobile">订单金额: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="mobile" name="mobile" required="required" placeholder="请输入联系手机号"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">下单人:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="address" id="address" placeholder="请输入地址"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logoUrl">支付类型:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="logoUrl" id="logoUrl" data-validate-length-range="8,500" placeholder="请输入主图地址"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shopInfo">订单状态:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="shopInfo" id="shopInfo" placeholder="请输入商家简介"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="city">订单类型:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="city" id="city" placeholder="请输入城市"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="city">创建时间:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="city" id="city" placeholder="请输入城市"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="city">付款时间:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="city" id="city" placeholder="请输入城市"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="city">核销时间:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="city" id="city" placeholder="请输入城市"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
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
    var _status='', _type='',shop_name=''
    $("#order_type li").click(function(event){
        //获取选择的订单类型
        _type =  event.target.id;
        var newname =$(this).find("a").eq(0).text();
        $("#dropdownMenu1").text(newname);
        $("<span class='caret'></span>").appendTo("#dropdownMenu1");
    });
    $("#order_status li").click(function(event){
        //获取选择的订单状态
        console.log( event.target)
        _status =  event.target.id;
        var newname =$(this).find("a").eq(0).text();
        $("#dropdownMenu12").text(newname);
        $("<span class='caret'></span>").appendTo("#dropdownMenu12");
    });

    $('#shop_name').bind('input propertychange', function() {
        //实时监听input框中输入的值
        console.log($(this).val());
        shop_name=$("#shop_name").val();
    });
    $("#search").click(function(){
        //点击搜索按钮，执行搜索事件
        var start=$("#calendar").val();
        var end=$("#calendar2").val();

        console.log("start:",start);
        console.log("end:",end);
        console.log("shop_name:",shop_name);
        console.log("_type:",_type)
        console.log("_status:",_status)


    });
    $(document).ready(function() {
        $("#calendar").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#calendar1").bootstrapDatepickr({date_format: "h:m:s"});
        $("#calendar2").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#calendar3").bootstrapDatepickr({date_format: "hh:ii:ss"});
    });
    function operateFormatter(code, row, index) {
        var trId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="order:detail"><a class="btn btn-xs btn-info btn-allot" data-id="' + trId + '"><i class="fa fa-trash-o"></i>查看明细</a></@shiro.hasPermission>'
        ];
        return operateBtn.join('');
    }

    $(function () {
        var options = {
            url: "/order/list",
            getInfoUrl: "/shop/get/{id}",
            updateUrl: "/shop/edit",
            removeUrl: "/shop/remove",
            createUrl: "/shop/add",
            saveRolesUrl: "/shop/saveUserRoles",
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'id',
                    title: '订单号',
                    editable: false
                }, {
                    field: 'soAmount',
                    title: '订单金额',
                    editable: true,
                    formatter: function (code) {
                        return '￥'+code.toFixed(2)
                    }
                }, {
                    field: 'userName',
                    title: '下单人',
                    editable: true
                }, {
                    field: 'payType',
                    title: '支付类型',
                    editable: false,
                    formatter: function (code) {
                        if(code==1){
                            return "享七支付";
                        }else if(code==2){
                            return "微信支付";
                        }else if(code==3){
                            return "支付宝支付"
                        }
                    }
                }, {
                    field: 'soStatus',
                    title: '订单状态',
                    editable: false,
                    formatter: function (code) {
                        if(code==1){
                            return "待支付";
                        }else if(code==2){
                            return "已支付";
                        }else if(code==3){
                            return "已核销";
                        }else if(code==4){
                            return "取消";
                        }
                    }
                }, {
                    field: 'soType',
                    title: '订单类型',
                    editable: false,
                    formatter: function (code) {
                        if(code==1){
                            return "平台订单";
                        }else if(code==2){
                            return "商家订单";
                        }
                    }
                }, {
                    field: 'shopName',
                    title: '商家店铺',
                    editable: true
                },{
                    field: 'createTime',
                    title: '创建时间',
                    editable: false,
                    formatter: function (code) {
                        return new Date(code).format("yyyy-MM-dd hh:mm:ss")
                    }
                }, {
                    field: 'paidTime',
                    title: '付款时间',
                    editable: false,
                    formatter: function (code) {
                        return new Date(code).format("yyyy-MM-dd hh:mm:ss")
                    }
                }, {
                    field: 'hxTime',
                    title: '核销时间',
                    editable: false,
                    formatter: function (code) {
                        return new Date(code).format("yyyy-MM-dd hh:mm:ss")
                    }
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ],
            modalName: "用户"
        };

        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);

        /* 分配用户角色 */
        /*$('#tablelist').on('click', '.btn-allot', function () {
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
        });*/
    });
</script>
