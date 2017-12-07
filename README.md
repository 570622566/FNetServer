## 框架功能及使用

### 1. 框架功能介绍

这是根据**NanoHttpd**二次开发的一个轻量级,使用简单,功能比较强大的一个http服务框架.

可以实现:

1. 支持get请求

2. 支持post请求

3. 支持文件上传

4. 支持文件下载

5. 支持自定义端口号

6. 支持自定义静态资源目录(默认assets的根目录,也可以指定sd卡的自定义目录)

7. 支持静态资源文件过滤(由于指定的是assets根目录,会有很多系统自带的xml文件,就做了这个)

8. 支持注解的使用(这框架不用注解还真没法用)

9. 支持以对象来响应

10. 支持请求以对象接收

11. ...

基本满足http服务的正常使用需求(硬是瞎编了那么多功能...)


###  2.框架里的几个注解


 注解 | 含义
--- | ---
@RequestBody | 方法里的属性注解,使用该注解可指定以对象返回 主要用于处理json请求
@RequestParam("") |  方法里的属性注解,使用该注解可指定param值返回 主要用于处理get,post的请求
@RequestMapping("") | 方法注解, 使用该注解是映射url ,把url 指定到对应的方法中处理数据
|@ResponseBody | 方法注解,使用该方法可以对象返回经过处理吐出json数据返回给客户端


以上注解的使用可看前面的图片

### 3. 框架使用

1. gradle添加

```
compile 'cn.hotapk:fhttpserver:0.1.0'
```

2. manifest添加权限
```
  <uses-permission android:name="android.permission.INTERNET" />
  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

3. 初始化

```
fHttpManager = FHttpManager.init(this, UserController.class);
fHttpManager.setPort(9999);
...
```

> UserController.class 是进行url映射的类, 可添加多个这样的类


```
public class UserController {

    @RequestMapping("userls")
    public NanoHTTPD.Response getUserLs() {
        return setResponse("user列表");
    }

    @ResponseBody
    @RequestMapping("getuser")
    public UserBean getUser() {
        return new UserBean("admin", "admin");
    }
...
```


4. 开启http服务


```
fHttpManager.startServer();
```

### 4. 框架使用demo

这块就不出详细demo了

可以到我另外一个项目查看

[这是一个android调试数据库的神器](https://github.com/570622566/FastandrDb)

### 5.框架代码讲解

这方面就不讲了,主要使用注解反射实现,其它也没什么的了

### 6.框架名称

> **FHttpServer**

以上是**FHttpServer**框架的全部内容,谢谢观看,欢迎使用.

同时希望各位在使用中遇到什么问题或建议可以用以下联系方式进行反馈

![android开发讨论群 320120776](http://upload-images.jianshu.io/upload_images/2383936-982bdf5358cb0ddf.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**[个人博客](http://www.hotapk.cn)**

**[简书地址](http://www.jianshu.com/u/976c86b6ee10)**
(感兴趣的话，不妨点赞支持下)