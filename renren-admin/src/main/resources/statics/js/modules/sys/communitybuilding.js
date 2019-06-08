$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/communitybuilding/list',
        datatype: "json",
        colModel: [
            { label: 'id', name: 'id', index: 'id', width: 50, key: true, hidden:true},
			{ label: '楼号', name: 'no', index: 'no', width: 120 ,sortable: false},
			{ label: '所属小区', name: 'communityName', index: 'community_name', width: 80, sortable: false},
			{ label: '房间数目', name: 'roomCount', index: 'room_count', width: 80, sortable: false}
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
            records: "page.totalCount"
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
var com_ztree;

var com_setting={
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
        }
       
    }
}

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		come:{
			id:null,
			name:null
		},
		communityBuilding: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.communityBuilding = {};
			vm.queryAllCom();
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.communityBuilding.id == null ? "sys/communitybuilding/save" : "sys/communitybuilding/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.communityBuilding),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/communitybuilding/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/communitybuilding/info/"+id, function(r){
                vm.communityBuilding = r.communityBuilding;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        queryAllCom:function () {
			$.get(baseURL+"sys/unitcommunity/all",function (data) {
					if (data == null){
                        alert('未查询小区,请先添加小区', function(){
                        });
					}else {
                        com_ztree =$.fn.zTree.init($("#deptTree"), com_setting, data);
                        com_ztree.expandAll(true);
					}
            })

        },
		showComDialog:function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择小区",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = com_ztree.getSelectedNodes();
                    //选择上级部门
                    vm.communityBuilding.communityId = node[0].id;
                    vm.come.name = node[0].name;

                    layer.close(index);
                }
            });
        }
	}
});