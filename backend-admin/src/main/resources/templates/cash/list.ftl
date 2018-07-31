<#include "/layout/header.ftl"/>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <ol class="breadcrumb">
            <li><a href="/">首页</a></li>
            <li class="active">申请管理</li>
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

<script>
    var thbegainTime;
    var thendTime;

    var today = new Date();
    var tomorrow = new Date().getTime() + 86400000;
    tomorrow=new Date(tomorrow);
    tomorrow=this.dateConv(tomorrow);
    today = this.dateConv(today);


    function  dateConv(dateStr,type) { // yyyy/mm/dd
        var year = dateStr.getFullYear(),
                month = dateStr.getMonth() + 1,
                today = dateStr.getDate();
        month = month > 9 ? month : "0" + month;
        today = today > 9 ? today : "0" + today;
        return year + "-" + month + "-" + today;
    }


    /*审批通过*/
    $('#tablelist').on('click', '.btn-consent', function (e) {
        var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
        if (truthBeTold) {
        } else{
            return;
        }
        var start=$("#startDate").val();
        var end=$("#endDate").val();
        $('.listbox').show();
        var Id=e.target.dataset.id;
        // 2 审批通过 3 审批不通过
        $.ajax({
            type: "post",
            url: "/cash/updatestart",
            data:{id:Id,applyStatus:2},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                alert(data.message);
                $.tableUtil.refresh();
            },
        });
    });

    /*审批通过*/
    $('#tablelist').on('click', '.btn-reject', function (e) {
        var truthBeTold = window.confirm("单击“确定”继续。单击“取消”停止。");
        if (truthBeTold) {
        } else{
            return;
        }
        var start=$("#startDate").val();
        var end=$("#endDate").val();
        $('.listbox').show();
        var Id=e.target.dataset.id;
        // 2 审批通过 3 审批不通过
        $.ajax({
            type: "post",
            url: "/cash/updatestart",
            data:{id:Id,applyStatus:3},
            dataType: "json",
            success: function (data) {
                console.log("data:",data);
                alert(data.message);
                $.tableUtil.refresh();
            },
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
        var Id = row.id;
        var operateBtn = [
            '<@shiro.hasPermission name="bill:sotimeList"><a class="btn btn-xs btn-info btn-consent" data-id="' + Id + '"><i class="fa fa-trash-o"></i>同意申请</a></@shiro.hasPermission>',
        ];
        operateBtn.push('<@shiro.hasPermission name="bill:updateSoList"><a class="btn btn-xs btn-primary btn-reject" data-id="' + Id + '"><i class="fa fa-edit"></i>驳回申请</a></@shiro.hasPermission>');
        return operateBtn.join('');
    }

    /*初始化加载表格*/
    $(function () {
        $("#startDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#endDate").bootstrapDatepickr({date_format: "Y-m-d"});
        $("#startDate").val(today);
        $("#endDate").val(tomorrow);
        var options = {
            url: "/cash/seelist",
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
                    title: '商家id',
                    editable: false
                }, {
                    field: 'userName',
                    title: '用户账号',
                    editable: false
                }, {
                    field: 'nickName',
                    title: '昵称',
                    editable: true
                }, {
                    field: 'mobile',
                    title: '手机',
                    editable: true
                }, {
                    field: 'cashAmount',
                    title: '提现金额',
                    editable: true
                }, {
                    field: 'applyStatus',
                    title: '审批状态',
                    editable: false,
                    formatter: function (code) {
                        if(code==1){
                            return "待审批";
                        }else if(code==2){
                            return "审批通过";
                        }else if(code==3){
                            return "审批不通过";
                        }else if(code==4){
                            return "取消";
                        }else if(code==5){
                            return "终止";
                        }
                    }
                }, {
                    field: 'paidTime',
                    title: '打款时间',
                    editable: true,
                    sortable: true,
                    //——修改——获取日期列的值进行转换
                    formatter: function (value, row, index) {
                        return changeDateFormat(value)
                    }
                }, {
                    field: 'paidUserId',
                    title: '打款人id',
                    editable: true
                }, {
                    field: 'paidUserName',
                    title: '打款人姓名',
                    editable: true
                }, {
                    field: 'operate',
                    title: '操作',
                    formatter: operateFormatter //自定义方法，添加操作按钮
                }
            ]
        };
        //1.初始化Table
        $.tableUtil.init(options);
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

</script>
