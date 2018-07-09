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
                        <input type="text" id="startDate" placeholder="test" class="form-control">
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">结束时间</span>
                        <input type="text" id="endDate" placeholder="test" class="form-control">
                    </div>
                </div>
                <div class="">
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
<div class="listbox">
    <div class="headline">详情详情<input id="guanbi" class="closebtn_bill" type="button" value="关闭"/><span id="dztotal"></span></div>
    <table id="tablest">
    </table>
</div>
<#--查看明细弹窗-->
<script>
    var thshopId;
    var thbegainTime;
    var thendTime;

    var today = new Date();
    var tomorrow = new Date().getTime() + 86400000;
    tomorrow=new Date(tomorrow);
    tomorrow=this.dateConv(tomorrow);
    today = this.dateConv(today);

    /*$(document).ready(function() {
        $("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#endDate").bootstrapDatepickr({date_format: "Y-m-d"});
    });*/
    function  dateConv(dateStr,type) { // yyyy/mm/dd
        let year = dateStr.getFullYear(),
                month = dateStr.getMonth() + 1,
                today = dateStr.getDate();
        month = month > 9 ? month : "0" + month;
        today = today > 9 ? today : "0" + today;
        return year + "-" + month + "-" + today;
    }

/*关闭明细弹窗*/
    $('#guanbi').on('click',function(){
        $("#tablest").bootstrapTable('destroy');
        $("#dztotal").html("");
        $('.listbox').hide();
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
        var trShopId = row.id;
        $("#startDate").val(today);
        $("#endDate").val(tomorrow);
        var operateBtn = [
            '<@shiro.hasPermission name="bill:getSoWriteOfflist"><a class="btn btn-xs btn-info btn-allot" data-id="' + trShopId + '"><i class="fa fa-trash-o"></i>查看明细</a></@shiro.hasPermission>',
        ];
        if (currentShopId != trShopId) {
            operateBtn.push('<@shiro.hasPermission name="bill:updateWriteList"><a class="btn btn-xs btn-primary btn-bill" data-id="' + trShopId + '"><i class="fa fa-edit"></i>结算</a></@shiro.hasPermission>');
        }
        return operateBtn.join('');
    }

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
            queryParams: function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                var _offset = params.offset/10+1;
                var tamp =  {
                    pageSize: params.limit, // 每页要显示的数据条数
                    offset: params.offset, // 每页显示数据的开始行号
                    pageNumber:_offset,
                    shopId:thshopId,
                    beginTime:thbegainTime,
                    endTime:thendTime
                };
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
            },
            onLoadError: function(){  //加载失败时执行
            }
        })
    };

    /* 结算 */
    $('#tablelist').on('click', '.btn-bill', function (e) {
        var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。")
        if (truthBeTold) {
        } else{
            return;
        }
        var shopid = e.target.dataset.id;
        //console.log("userid:",userId);
        $.ajax({
            type: "post",
            url: "/bill/updateWriteList",
            data:{shopId:shopid, beginTime:$("#startDate").val(),endTime:$("#endDate").val()},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                alert(data.message)
            },
            error: $.tool.ajaxError
        });
    });

    /* 分配用户角色  --查看明细弹窗 */
    $('#tablelist').on('click', '.btn-allot', function (e) {
        var start=$("#startDate").val();
        var end=$("#endDate").val();
        console.log(new Date(start).getTime())
        $('.listbox').show();
        if(new Date(start).getTime()>new Date(end).getTime()){
            alert("结束日期不能小于开始日期");
            $("#startDate").val("");
            $("#endDate").val("");
            return;
        }
        thshopId=e.target.dataset.id;
        thbegainTime=$("#startDate").val();
        thendTime=$("#endDate").val();
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
        });
        newtable();
    });

    /*初始化加载表格*/
    $(function () {

        $("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#endDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#startDate").val(today);
        $("#endDate").val(tomorrow);
        var options = {
            url: "/bill/list",//
            getInfoUrl: "/bill/get/{id}",
            updateUrl: "/bill/updateSoList",
            queryParams :function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                var start=$("#startDate").val();
                var end=$("#endDate").val();
                var tamp =  {
                    pageSize: params.limit, // 每页要显示的数据条数
                    offset: params.offset, // 每页显示数据的开始行号
                    keywords:params.searchText?params.searchText:"",
                    beginTime:start?start:today,
                    endTime:end?end:tomorrow
                };
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
    });
</script>
