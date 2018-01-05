# Xutilslibrary使用方法（此封装包含Xutlis所有方法，可直接使用Xutlis包含的任何方法）

#### 在Activity实现implements requestNetwork.xutilsRequest方法即可接入请求网络后的回调方法
##### xutilsRequest需传入方法使用说明
| 方法            | 说明           |
|:-------------: |:-------------:|
| mContext       | 当前Activity                                       |
| url            | 请求地址                                           |
| identifier     | 请求返回识别Key                                    |
| method         | 请求类型get、post                                  |
| map            | params 传入参数值，可填可不填                       |
| addHeaderState | 是否带头部参数请求，可填可不填                       |
| addHeaderKey   | 头部Key，如addHeaderState填入则此项需填入           |
| addHeaderValue | 头部Key对应的Value，如addHeaderState填入则此项需填入 |
| isDialog       | 是否显示等待动画                                   |

