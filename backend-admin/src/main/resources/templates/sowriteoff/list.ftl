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
    <div class="headline">详情核销票量<input id="guanbi" type="button" value="关闭"/><span id="dztotal"></span></div>

    <table id="tablest">

    </table>


</div>
<#--</div>-->
<#--查看明细弹窗-->

<script>
    var thshopId;
    var thbegainTime;
    var thendTime;

    $(document).ready(function() {
        $("#calendar").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#calendar1").bootstrapDatepickr({date_format: "h:m:s"});
        $("#calendar2").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#calendar3").bootstrapDatepickr({date_format: "hh:ii:ss"});
    });
    /**
     * 操作按钮
     * @param code
     * @param row
     * @param index
     * @returns {string}
     */
    function operateFormatter(code, row, index) {
        var currentShopId = '${shop.id}';
        /*alert(currentShopId);*/
        var trShopId = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="bill:detail"><a class="btn btn-xs btn-info btn-allot" data-id="' + trShopId + '"><i class="fa fa-trash-o"></i>查看明细</a></@shiro.hasPermission>',
        ];
        if (currentShopId != trShopId) {
            operateBtn.push('<@shiro.hasPermission name="shop:edit"><a class="btn btn-xs btn-primary btn-update" data-id="' + trShopId + '"><i class="fa fa-edit"></i>结算</a></@shiro.hasPermission>');
        }
        return operateBtn.join('');
    }


    $(function () {
        var options = {
            url: "/bill/list",//
            getInfoUrl: "/bill/get/{id}",
            updateUrl: "/bill/updateSoList",
            queryParams :function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                var tamp =  {
                    pageSize: params.limit, // 每页要显示的数据条数
                    offset: params.offset, // 每页显示数据的开始行号
                    /*keywords:params.searchText?params.searchText:"",*/
                    keywords:params.searchText?params.searchText:"",
                    beginTime:$("#calendar").val()?$("#calendar").val():"",
                    endTime:$("#calendar2").val()?$("#calendar2").val():""
                };
                console.log("tamp:",tamp);
                return tamp;
            },
            columns: [
                {
                    checkbox: true
                }, {
                    field: 'id',
                    title: '商家id',
                    editable: false,
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
            modalName: "结算"
        };

        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        //$.buttonUtil.init(options);

        $('#guanbi').on('click',function(){
            $("#tablest").bootstrapTable('destroy');
            $("#dztotal").html("");
            $('.listbox').hide();
        });
        /* 分配用户角色  --查看明细弹窗 */
        $('#tablelist').on('click', '.btn-allot', function (e) {
            var start=$("#calendar").val();
            var end=$("#calendar2").val();
            console.log(new Date(start).getTime())
            $('.listbox').show();
            if(new Date(start).getTime()>new Date(end).getTime()){
                alert("结束日期不能小于开始日期");
                $("#calendar").val("");
                $("#calendar2").val("");
                return;
            }
            thshopId=e.target.dataset.id;
            thbegainTime=$("#calendar").val();
            thendTime=$("#calendar2").val();

            $.ajax({
                type: "post",
                url: "/bill/writePrice",
                data:{shopId:thshopId, beginTime:thbegainTime,endTime:thendTime},
                dataType: "json",
                success: function (data) {
                    console.log("data:",data);
                    data.totalService?data.totalService:"0"
                    $("#dztotal").html("合计￥"+data.totalService);
                },
                //error: $.tool.ajaxError
            });
            newtable();
            //alert("进入方法")

        });
        // 查看明细弹窗


        function newtable(){
            $("#tablest").bootstrapTable({ // 对应table标签的id
                method: "post",//请求方式
                contentType : "application/x-www-form-urlencoded; charset=UTF-8",
                url: "/bill/getSoWriteOfflist", // 获取表格数据的url
                cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
                striped: true,  //表格显示条纹，默认为false
                pagination: true, // 在表格底部显示分页组件，默认false
                pageList: [10, 20], // 设置页面可以显示的数据条数
                pageSize: 10, // 页面数据条数
                pageNumber: 1, // 首页页码
                sidePagination: 'server', // 设置为服务器端分页
                //queryParamsType: "limit", //参数格式,发送标准的RESTFul类型的参数请求0
                queryParams: function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
//                    console.log("params:",params);
                    var _offset = params.offset/10+1;
                    var tamp =  {
                        pageSize: params.limit, // 每页要显示的数据条数
                        offset: params.offset, // 每页显示数据的开始行号
                        pageNumber:_offset,
//                        sort: params.sort, // 要排序的字段
                        //dataId: $("#dataId").val(), // 额外添加的参数
                        shopId:thshopId,
                        beginTime:thbegainTime,
                        endTime:thendTime
                    };
//                    console.log("tamp:",tamp);
                    return tamp;
                },
                sortName: 'id', // 要排序的字段
                sortOrder: 'desc', // 排序规则
                columns: [
                    {
                        field: 'soId', // 返回json数据中的name
                        title: '订单号', // 表格表头显示文字
                        align: 'center', // 左右居中
                        valign: 'middle' // 上下居中
                    }, {
                        field: 'userName',
                        title: '下单人',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        field: 'shopName',
                        title: '商家名',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        field: 'soPrice',
                        title: '单笔服务费',
                        align: 'center',
                        valign: 'middle',
                        editable: true
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
                        field: 'isBill',
                        title: '结清状态(0未结清,1已结清)',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        //paidAmount
                        field: 'paidAmount',
                        title: '支付金额',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        field: 'couponAmount',
                        title: '卷面值',
                        align: 'center',
                        valign: 'middle'
                    }, {
                        field: 'couponCode',
                        title: '电子券编码',
                        align: 'center',
                        valign: 'middle'
                    }
                ],
                onLoadSuccess: function(){  //加载成功时执行
                    console.info("加载成功");
                    console.log(this)
                },
                onLoadError: function(){  //加载失败时执行
                    console.info("加载数据失败");
                }
            })
        };

        /* 结算 */
        $('#tablelist').on('click', '.btn-update', function (e) {

            var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。")
            if (truthBeTold) {
                /*window.alert("欢迎访问我们的 Web 页！");*/
            } else{
                window.alert("再见啦！");
                return;
            }
            //var $this = $(this);
            var userId = e.target.dataset.id;
            console.log("userid:",userId);
            $.ajax({
                type: "post",
                url: "/bill/updateWriteList",
                data:{shopId:userId, beginTime:$("#calendar").val(),endTime:$("#calendar2").val()},
                dataType: "json",
                success: function (data) {
                    console.log("data:",data);
                    alert(data.message)
                },
                error: $.tool.ajaxError
            });
        });


    });


</script>
