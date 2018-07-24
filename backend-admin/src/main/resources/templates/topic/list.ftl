<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">视频管理</li>
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

<!--视频明细弹框-->
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
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nickName">昵称: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="nickName" id="nickName" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="summary">摘要: <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" id="summary" name="summary" readonly="true"/>
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="homePic">封面:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="homePic"  id="homePic" readonly="true"/>
                        <#--<img type="img" class="image-detail" src="">-->
                        </div>
                    </div>
                    <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="content">内容:</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" class="form-control col-md-7 col-xs-12" name="content" id="content" data-validate-length-range="8,500" readonly="true"/>
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

<script>
    var thbegainTime;
    var thendTime;

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
            url: "/topic/inreject",
            data:{id:enter.topicid},
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
            url: "/topic/outreject",
            data:{id:enter.topicid},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                $.tableUtil.refresh();
                alert(data.message)
            },
            error: $.tool.ajaxError
        });
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
        var operateBtn = [
            '<@shiro.hasPermission name="topic:detail"><a class="btn btn-xs btn-primary btn-detail" data-id="' + id + '"><i class="fa fa-edit"></i>查看明细</a></@shiro.hasPermission>',
        ];
        return operateBtn.join('');
    }

    /*初始化加载表格*/
    $(function () {
        $("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#endDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#startDate").val(today);
        $("#endDate").val(tomorrow);
        var options = {
            url: "/topic/seelist",
            getInfoUrl: "/topic/detail",
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
                    field: 'id',
                    title: 'topicid',
                    editable: false,
                }, {
                    field: 'userName',
                    title: '用户账号',
                    editable: false,
                }, {
                    field: 'nickName',
                    title: '昵称',
                    editable: false,
                }, {
                    field: 'title',
                    title: '文章标题',
                    editable: true
                }, {
                    field: 'tpStatus',
                    title: '审核状态',
                    editable: false,
                    formatter: function (code) {
                        if(code==0){
                            return "待审批";
                        }else if(code==1){
                            return "审批通过";
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
                    field: 'topicType',
                    title: '文章类型',
                    editable: false,
                    formatter: function (code) {
                        if(code==1){
                            return "文章";
                        }else if(code==2){
                            return "视频";
                        }
                    }
                }, {
                    field: 'actName',
                    title: '参与活动',
                    editable: true
                }
            ],
            modalName: "视频审核"
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
            enter.topicid=selectedJson[i].id;
        });
        return enter;
    }

</script>
