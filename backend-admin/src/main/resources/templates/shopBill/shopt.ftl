<#include "/layout/header.ftl"/>
<div id="app">
    <el-row :gutter="20">
        <el-col :span="4">
            <div class="grid-content bg-purple">
                <ul class="left_dire">
                    <li class="dire_li" v-for="(item,index) in directory" :key="index" @click="handclick(index)">
                        {{item.name}}
                    </li>
                </ul>
            </div>
        </el-col>
        <el-col :span="1">
            <div class="grid-content bg-purple"></div>
        </el-col>
        <el-col :span="19">
            <div class="grid-content bg-purple">
                <el-row type="flex" class="row-bg" justify="space-around">
                    <el-col :span="4">
                        <div class="grid-content bg-purple">
                            <el-autocomplete
                                    class="inline-input"
                                    v-model="state1"
                                    :fetch-suggestions="querySearch"
                                    placeholder="请输入店名"
                                    @select="handleSelect"
                                    ></el-autocomplete>
                        </div>
                    </el-col>
                    <el-col :span="8">
                        <div class="grid-content bg-purple-light">
                            <div class="block">
                                <el-date-picker
                                        v-model="value5"
                                        type="datetimerange"
                                        :picker-options="pickerOptions2"
                                        range-separator="至"
                                        start-placeholder="开始日期"
                                        end-placeholder="结束日期"
                                        align="right">
                                </el-date-picker>
                            </div>
                        </div>
                    </el-col>
                    <el-col :span="6">
                        <div class="grid-content bg-purple">
                            <el-button type="primary" @click="search">开始搜索</el-button>
                            <el-button type="primary" @click="allpass">全部对账</el-button>
                        </div>
                    </el-col>

                </el-row>
                <el-table
                        ref="multipleTable"
                        :data="listdata"
                        tooltip-effect="dark"
                        style="width: 100%"
                        @selection-change="handleSelectionChange">
                    <el-table-column
                            type="selection"
                            width="55">
                    </el-table-column>
                    <el-table-column
                            prop="value"
                            label="店名">
                    </el-table-column>
                    <el-table-column
                            prop="address"
                            label="地址"
                            show-overflow-tooltip>
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)">对账
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        @size-change="handleSizeChange"
                        @current-change="handleCurrentChange"
                        :current-page.sync="currentPage"
                        :page-sizes="[100, 200, 300, 400]"
                        :page-size="100"
                        layout="sizes, prev, pager, next"
                        :total="1000">
                </el-pagination>

            </div>
        </el-col>
    </el-row>

</div>


<script>

    new Vue({
        el: '#app',
        data: function () {
            return {
                restaurants: [],
                state1: '',
                currentPage: 5,
                pickerOptions2: {
                    shortcuts: [{
                        text: '最近一周',
                        onClick(picker) {
                        const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
            picker.$emit('pick', [start, end]);
        }
    }, {
        text: '最近一个月',
        onClick(picker)
    {
        const end = new Date();
        const start = new Date();
        start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
        picker.$emit('pick', [start, end]);
    }
    },
    {
        text: '最近三个月',
                onClick(picker)
        {
            const end = new Date();
            const start = new Date();
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
            picker.$emit('pick', [start, end]);
        }
    }
    ]
    },
    value4: [new Date(2018, 10, 10, 10, 10), new Date(2018, 10, 11, 10, 10)],
            value5
    :
    '',
            visible
    :
    false,
            msg
    :
    '平台对账功能',
            directory
    :
    [
        {
            name: '平台对账功能',
            ind: 1,
            type: 1
        },
        {
            name: '商家入驻审核',
            ind: 1,
            type: 1
        },
        {
            name: '文章视频审核',
            ind: 1,
            type: 1
        }
    ],
            listdata
    :
    [
        {"value": "三全鲜食（北新泾店）", "address": "长宁区新渔路144号"},
        {"value": "Hot honey 首尔炸鸡（仙霞路）", "address": "上海市长宁区淞虹路661号"},
        {"value": "新旺角茶餐厅", "address": "上海市普陀区真北路988号创邑金沙谷6号楼113"},
        {"value": "泷千家(天山西路店)", "address": "天山西路438号"},
        {"value": "胖仙女纸杯蛋糕（上海凌空店）", "address": "上海市长宁区金钟路968号1幢18号楼一层商铺18-101"},
        {"value": "贡茶", "address": "上海市长宁区金钟路633号"},
        {"value": "豪大大香鸡排超级奶爸", "address": "上海市嘉定区曹安公路曹安路1685号"},
        {"value": "茶芝兰（奶茶，手抓饼）", "address": "上海市普陀区同普路1435号"},
        {"value": "十二泷町", "address": "上海市北翟路1444弄81号B幢-107"}
    ]
    }
    },
    methods:{
        handclick:function (val) {
            console.log('val:', val)
            if (val != 0) {
                this.$message({
                    showClose: true,
                    message: '功能开发中。。。'
                });
            }
        }
    ,
        search:function () {
            console.log('search')
        }
    ,
        handleSelect(item)
        {
            console.log(item);
        }
    ,
        allpass:function () {
            this.listdata = [];
            this.$message({
                message: '全部对帐成功！',
                type: 'success'
            });
        }
    ,
        querySearch(queryString, cb)
        {
            var restaurants = this.restaurants;
            var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
            // 调用 callback 返回建议列表的数据
            cb(results);
        }
    ,
        createFilter:function(queryString)
        {
            return (restaurant) =
        >
            {
                return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
            }
            ;
        }
    ,
        handleSelectionChange(val)
        {
            this.multipleSelection = val;
        }
    ,
        handleEdit(index, row)
        {
            console.log(index, row);
        }
    ,
        handleDelete(index, row)
        {
            console.log(index, row);
            this.listdata.splice(index, 1);
            this.$message({
                message: '对帐成功！',
                type: 'success'
            });
        }
    ,
        handleSizeChange(val)
        {
            console.log(`每页 ${val} 条`)
            ;
        }
    ,
        handleCurrentChange(val)
        {
            console.log(`当前页: ${val}`
        )
            ;
        }
    }
    ,
    mounted()
    {
        this.restaurants = this.listdata;
    }

    })
</script>
