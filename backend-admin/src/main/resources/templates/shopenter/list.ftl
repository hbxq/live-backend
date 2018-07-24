<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">商家入驻管理</li>
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
                <#--审核-->
                        <div id="remak-status">
                            <input id="status_pass" type="button" value="审核通过"/>
                            <input id="status_reject" type="button" value="审核驳回"/>
                        </div>
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
<!--入驻明细弹框-->
<div class="modal fade" id="detail_Modal" tabindex="-1" role="dialog" aria-labelledby="addroleLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="addroleLabel">入驻明细</h4>
            </div>
            <div class="modal-body">
                <form id="detail_Form" class="form-horizontal form-label-left" novalidate>
                    <input type="hidden" name="id">
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="shopName">店铺名称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="shopName" id="shopName" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">店铺地址: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="address" name="address" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logoPic">logo:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="logoPic"  id="logoPic" readonly="true"/>
                            <#--<img type="img" class="image-detail" src="">-->
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="businessCate">经营品类:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="businessCate" id="businessCate" data-validate-length-range="8,500" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="licensePic">营业执照:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12"  name="licensePic" id="licensePic" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="healthPic">卫生许可证:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="healthPic" id="healthPic" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="doorPic">门头照:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="doorPic" id="doorPic" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="otherService">其他服务:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="otherService" id="otherService" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="remark">备注:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="remark" id="remark" readonly="true"/>
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
<#--备注弹框-->
<div class="box-remark-text">
    <div id="remark-text">
        <span>备注内容</span>
        <textarea id="remark-txt" rows="3" cols="20"></textarea>
    </div>
    <input id="on-remark" type="button" value="提交"/>
    <input id="out-remark" type="button" value="关闭"/>
</div>

<script>
    var thbegainTime;
    var thendTime;
    var enterid;

    var today = new Date();
    var tomorrow = new Date().getTime() + 86400000;
    tomorrow=new Date(tomorrow);
    tomorrow=this.dateConv(tomorrow);
    today = this.dateConv(today);

    function  dateConv(dateStr,type) { // yyyy/mm/dd
        let year = dateStr.getFullYear(),
                month = dateStr.getMonth() + 1,
                today = dateStr.getDate();
        month = month > 9 ? month : "0" + month;
        today = today > 9 ? today : "0" + today;
        return year + "-" + month + "-" + today;
    }

    $('#guanbi').on('click',function(){
        $("#tablest").bootstrapTable('destroy');
        $('.listbox').hide();
    });

    $('#guanbicompile').on('click',function(){
        $('.compilebox').hide();
    });

    /*审核通过*/
    $('#status_pass').on('click',function(){
        var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。")
        if (truthBeTold) {
        } else{
            return;
        }
        var enter = getSelectedenter();
        if (!enter || enter == null) {
            $.tool.alertError("请至少选择一条记录");
            return;
        }
        $.ajax({
            type: "post",
            url: "/enter/addShop",
            data:{id:enter.enterid, userId:enter.userId, shopName:enter.shopName},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                $.tableUtil.refresh();
                alert(data.message)
            },
            error: $.tool.ajaxError
        });
    });
    /*审核驳回*/
    $('#status_reject').on('click',function(){
        var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。")
        if (truthBeTold) {
        } else{
            return;
        }
        var enter = getSelectedenter();
        if (!enter || enter == null) {
            $.tool.alertError("请至少选择一条记录");
            return;
        }
         $.ajax({
             type: "post",
             url: "/enter/toreject",
             data:{id:enter.enterid, status:2},
             dataType: "json",
             success: function (data) {
                 console.log("data:",data);
                 $.tableUtil.refresh();
                 alert(data.message)
             },
             error: $.tool.ajaxError
         });
    });

    /* 编写备注 */
    $('#tablelist').on('click', '.btn-remark', function (e) {
        enterid = e.target.dataset.id;

        $('.box-remark-text').show();
    });

    $('#on-remark').on('click',function(){
        if ($('#remark-txt').val()==null||$('#remark-txt').val()=="") {
            var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。")
            if (truthBeTold) {
            } else{
                return;
            }
        }

        $.ajax({
            type: "post",
            url: "/enter/toremark",
            data:{id:enterid, remark:$("#remark-txt").val()},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                $.tableUtil.refresh();
                alert(data.message)
            },
            error: $.tool.ajaxError
        });
        $('#remark-txt').val("");
        return;
    });

    $('#out-remark').on('click',function(){
        $('.box-remark-text').hide();
        $('#remark-txt').val("");
    });

    /**
     * 操作按钮
     * @param code
     * @param row
     * @param index
     * @returns {string}
     */
    function operateFormatter(code, row, index) {
        var id = row.id;
        var user = row.userId;
        var name=row.shopName;
        var operateBtn = [
           '<@shiro.hasPermission name="enter:detail"><a class="btn btn-xs btn-primary btn-detail" data-id="' + id + '"><i class="fa fa-edit"></i>查看明细</a></@shiro.hasPermission>',
        ];
        operateBtn.push('<@shiro.hasPermission name="enter:toremark"><a class="btn btn-xs btn-primary btn-remark" data-id="' + id + '"><i class="fa fa-edit"></i>编写备注</a></@shiro.hasPermission>');
        return operateBtn.join('');
    }

    /*初始化加载表格*/
    $(function () {
        $("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#endDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#startDate").val(today);
        $("#endDate").val(tomorrow);
        var options = {
            url: "/enter/seelist",
            getInfoUrl: "/enter/detail",
            queryParams :function queryParams(params) { // 请求服务器数据时发送的参数，可以在这里添加额外的查询参数，返回false则终止请求
                var start=$("#startDate").val();
                var end=$("#endDate").val();

                var tamp =  {
                    pageSize: params.pageSize, // 每页要显示的数据条数
                    pageNumber:params.pageNumber,
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
                    field: 'userName',
                    title: '用户名称',
                    editable: false,
                }, {
                    field: 'mobile',
                    title: '联系方式',
                    editable: false,
                }, {
                    field: 'shopName',
                    title: '店铺名称',
                    editable: true
                },{
                    field: 'shopHours',
                    title: '营业时间',
                    editable: true,

                }, {
                    field: 'status',
                    title: '审核状态',
                    editable: false,
                    formatter: function (code) {
                        if(code==0){
                            return "待审批";
                        }else if(code==2){
                            return "审批不通过";
                        }
                    }
                }, {
                    field: 'createTime',
                    title: '创建时间',
                    editable: true,
                    sortable: true,
                    //——修改——获取日期列的值进行转换
                    formatter: function (value, row, index) {
                        return changeDateFormat(value)
                    }
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }, {
                    field: 'remark',
                    title: '备注',
                    editable: true
                }, {
                    field: 'city',
                    title: '城市',
                    editable: true
                }
            ],
            modalName: "商家入驻"
        };
        //1.初始化Table
        $.tableUtil.init(options);
        //2.初始化Button的点击事件
        $.buttonUtil.init(options);
    });

    //修改——转换日期格式(时间戳转换为datetime格式)
    function changeDateFormat(cellval) {
        var dateVal = cellval + "";
        if (cellval != null) {
            var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }

    /**
     * 获取选中的信息
     * @returns {Array}
     */
    function getSelectedenter() {
        var selectedJson = $("#tablelist").bootstrapTable('getAllSelections');
        var enter = new Object();
        $.each(selectedJson, function (i) {
            enter.enterid=selectedJson[i].id;
            enter.userId=selectedJson[i].userId;
            enter.shopName=selectedJson[i].shopName;
        });
        return enter;
    }

</script>
