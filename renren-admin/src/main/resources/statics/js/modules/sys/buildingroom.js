$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/buildingroom/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', width: 50, key: true},
            {label: '小区名', name: 'comName', index: 'comName', width: 40, sortable: false},
            {label: '楼幢', name: 'buildingNo', index: 'building_no', width: 40, sortable: false},
            {label: '单元室', name: 'cell', index: 'cell', width: 40, sortable: false},
            {label: '房号', name: 'room', index: 'room', width: 40, sortable: false},
            {label: '给水号', name: 'waterNo', index: 'waterNo', width: 40, sortable: false},
            {label: '用户是否绑定', name: 'bindStatus', index: 'bind_status', width: 40, sortable: false},
            {label: '所属用户名', name: 'bindUserName', index: 'bindUser_name', width: 40, sortable: false}
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount",
            cell:"page.list"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
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

var bui_ztree;
var bui_setting={
    data: {
        simpleData: {
            enable: true,
            idKey: "id"
        },
        key:{
            name:"no"
        }

    }
}
var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        buildingRoom: {},
        come:{
            id:null,
            name:null
        },
        bui:{
            id:null,
            name:null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.buildingRoom = {};
            vm.queryAllCom();
        },
        update: function (event) {
            var id = getSelectedRow();
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function (event) {
            if (vm.bui.id==null){
                alert('请先选择楼幢', function () {
                });
                return;
            }
            if (vm.buildingRoom.cell==null){
                alert('请填写单元室', function () {
                });
                return;
            }
            if (vm.buildingRoom.room==null){
                alert('请填写房号', function () {
                });
                return;
            }

            var url = vm.buildingRoom.id == null ? "sys/buildingroom/save" : "sys/buildingroom/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.buildingRoom),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/buildingroom/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (id) {
            $.get(baseURL + "sys/buildingroom/info/" + id, function (r) {
                vm.buildingRoom = r.buildingRoom;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        },
        queryAllCom: function () {
            $.get(baseURL + "sys/unitcommunity/all", function (data) {
                if (data == null) {
                    alert('未查询到小区,请先添加小区', function () {
                    });
                } else {
                    com_ztree = $.fn.zTree.init($("#deptTree"), com_setting, data);
                    com_ztree.expandAll(true);
                }
            })

        },
        showComDialog: function () {
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
                    vm.come.id = node[0].id;
                    vm.come.name = node[0].name;

                    vm.queryBuilding(vm.come.id);

                    layer.close(index);
                }
            });
        },
        // 根据小区id查询楼幢
        queryBuilding:function (id) {
            $.get(baseURL + "sys/communitybuilding/query/"+id,function (data) {
                if (data.code!=0){
                    alert('查询楼幢失败', function () {
                    });
                }else if (data.list==null ||data.list.size==0){
                    alert('未查询到楼幢,请先添加楼幢', function () {
                    });
                }else{
                    bui_ztree = $.fn.zTree.init($("#build_deptTree"), bui_setting, data.list);
                    bui_ztree.expandAll(true);
                }
            })
        },
        showbuiDialog: function () {
            if (vm.come.id==null){
                alert('请先选择小区', function () {
                });
                return;
            }

            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择楼幢",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#build_deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = bui_ztree.getSelectedNodes();
                    //选择上级部门
                    vm.bui.id = node[0].id;
                    vm.bui.name = node[0].no;
                    vm.buildingRoom.buildingId = vm.bui.id;
                    layer.close(index);
                }
            });
        }
    }
});