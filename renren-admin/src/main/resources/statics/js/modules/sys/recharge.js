$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/recharge/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true , hidden:true},
            {label: '房间号id', name: 'roomId', index: 'room_id', width: 80, hidden:true},
            {label: '小区', name: 'comName', index: 'comName', width: 80},
            {label: '楼号', name: 'buildingNo', index: 'buildingNo', width: 80},
            {label: '单元室', name: 'cell', index: 'cell', width: 80},
            {label: '房间号', name: 'room', index: 'room', width: 80},
            {label: '给水号', name: 'waterNo', index: 'water_no', width: 80},
            {label: '余额', name: 'money', index: 'money', width: 80},
            {label: '上次更新时间', name: 'updateTime', index: 'update_time', width: 80},
			{label: '操作', width: 40,formatter:function (cellvalue, options, rowObject) {
					return "<a class=\"btn btn-primary\" @click=\"add("+cellvalue+","+options+","+rowObject+")\"><i class=\"plus\"></i>充值</a>"
                }}
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount",
			cell:"page.list"
        },
        prmNames : {
            page:"page",
            rows:"limit",
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" });
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		recharge: {}
	},
	methods: {
		add:function (waterNo) {
			vm.title;
        }
	}
});