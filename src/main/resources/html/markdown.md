# springboot利用swagger构建api文档


<a name="overview"></a>
## 概览
简单优雅的restfun风格


### 版本信息
*版本* : 1.0


### 许可信息
*服务条款* : http://www.zimug.com


### URI scheme
*域名* : localhost:8888  
*基础路径* : /


### 标签

* article-rest-controller : Article Rest Controller




<a name="paths"></a>
## 资源

<a name="article-rest-controller_resource"></a>
### Article-rest-controller
Article Rest Controller


<a name="savearticleusingpost"></a>
#### saveArticle
```
POST /rest/article
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**article**  <br>*必填*|article|[Article](#article)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[AjaxResponse](#ajaxresponse)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/rest/article
```


###### 请求 body
```
json :
{
  "author" : "string",
  "content" : "string",
  "createTime" : "string",
  "id" : 0,
  "reader" : [ {
    "age" : 0,
    "name" : "string"
  } ],
  "title" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="getarticleusingget"></a>
#### getArticle
```
GET /rest/article/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[AjaxResponse](#ajaxresponse)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/rest/article/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="updatearticleusingput"></a>
#### updateArticle
```
PUT /rest/article/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int64)|
|**Body**|**article**  <br>*必填*|article|[Article](#article)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[AjaxResponse](#ajaxresponse)|
|**201**|Created|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/rest/article/0
```


###### 请求 body
```
json :
{
  "author" : "string",
  "content" : "string",
  "createTime" : "string",
  "id" : 0,
  "reader" : [ {
    "age" : 0,
    "name" : "string"
  } ],
  "title" : "string"
}
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```


<a name="deletearticleusingdelete"></a>
#### deleteArticle
```
DELETE /rest/article/{id}
```


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int64)|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[AjaxResponse](#ajaxresponse)|
|**204**|No Content|无内容|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/rest/article/0
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : 0,
  "data" : "object",
  "isok" : true,
  "message" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="ajaxresponse"></a>
### AjaxResponse

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|**样例** : `0`|integer (int32)|
|**data**  <br>*可选*|**样例** : `"object"`|object|
|**isok**  <br>*可选*|**样例** : `true`|boolean|
|**message**  <br>*可选*|**样例** : `"string"`|string|


<a name="article"></a>
### Article

|名称|说明|类型|
|---|---|---|
|**author**  <br>*可选*|**样例** : `"string"`|string|
|**content**  <br>*可选*|**样例** : `"string"`|string|
|**createTime**  <br>*可选*|**样例** : `"string"`|string (date-time)|
|**id**  <br>*可选*|**样例** : `0`|integer (int64)|
|**reader**  <br>*可选*|**样例** : `[ "[reader](#reader)" ]`|< [Reader](#reader) > array|
|**title**  <br>*可选*|**样例** : `"string"`|string|


<a name="reader"></a>
### Reader

|名称|说明|类型|
|---|---|---|
|**age**  <br>*可选*|**样例** : `0`|integer (int32)|
|**name**  <br>*可选*|**样例** : `"string"`|string|





