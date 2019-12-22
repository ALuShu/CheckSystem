<%--
  User: lushu
  Date: 2019/11/26
  Time: 10:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交作业</title>
</head>
<body>
<div class="layui-layout layui-layout-admin">

    <div class="layui-header layui-bg-gray">

        <div class="layui-logo" style="font-size: 20px; color: #393D49">作业查重系统</div>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;" style="color: #393D49">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    贤心
                </a>
            </li>
            <li class="layui-nav-item"><a href="" style="color: #393D49">退了</a></li>
        </ul>
    </div>

    <div class="layui-bg-green">
        <!-- 内容主体区域 -->
        <div style="padding: 15px; width: 80%; margin: auto">
            <div class="layui-row layui-col-space5 layui-bg-gray">
                <div class="layui-col-md12">
                    <div class="layui-row grid-demo">

                        <%-- 路径 --%>
                        <div class="layui-col-md12 layui-form-item">
                            <label class="layui-form-label">单行输入框</label>
                        </div>

                        <%-- 搜索框 --%>
                        <div class="layui-col-md12" style="background: #00FF00; padding-top: 15px; padding-left: 20px">
                            <form class="layui-form" action="">
                                <div class="layui-form-item">
                                    <div class="layui-input-inline" style="width: 66%">
                                        <input type="text" name="title" lay-verify="title" autocomplete="off"
                                               placeholder="输入教师姓名" class="layui-input">
                                    </div>
                                    <div class="layui-input-inline">
                                        <button type="submit" class="layui-btn layui-btn-warm" lay-submit="" lay-filter="demo1">搜索</button>
                                    </div>
                                </div>
                            </form>
                            <form method="post" action="/upload" enctype="multipart/form-data">
                                <input type="file" name="file"><br>
                                <input type="submit" value="提交">
                            </form>
                        </div>

                        <%-- 列表 --%>
                        <div class="layui-col-md12" style="background: #1E9FFF">
                            <div class="layui-btn-group demoTable" style="margin-bottom: 10px;">
                                <button class="layui-btn" data-type="parseTable">立即转化为数据表格</button>
                            </div>
                            <table lay-filter="parse-table-demo">
                                <thead>
                                <tr>
                                    <th lay-data="{field:'username', width:200}">昵称</th>
                                    <th lay-data="{field:'joinTime', width:150}">加入时间</th>
                                    <th lay-data="{field:'sign', minWidth: 180}">签名</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>贤心1</td>
                                    <td>2016-11-28</td>
                                    <td>人生就像是一场修行 A</td>
                                </tr>
                                <tr>
                                    <td>贤心2</td>
                                    <td>2016-11-29</td>
                                    <td>人生就像是一场修行 B</td>
                                </tr>
                                <tr>
                                    <td>贤心3</td>
                                    <td>2016-11-30</td>
                                    <td>人生就像是一场修行 C</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="../layui/layui.js"></script>
<script>
    layui.use(['form','table'], function () {
        var form = layui.form
            ,table = layui.table;

        var $ = layui.$, active = {
            parseTable: function(){
                table.init('parse-table-demo', { //转化静态表格
                    //height: 'full-500'
                });
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        //监听提交
        form.on('submit(demo1)', function(data){
            layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            })
            return false;
        });

        //但是，如果你的HTML是动态生成的，自动渲染就会失效
        //因此你需要在相应的地方，执行下述方法来进行渲染
        form.render();
    });


</script>
</body>
</html>