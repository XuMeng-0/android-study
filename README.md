# android-study

## [启动另外一个 Activity 并结束当前 Activity](https://www.jianshu.com/p/21ab5f8c4c93)

探究在启动另外一个 Activity 并结束当前 Activity 时， finish() 和 startActivity() 调用顺序的影响。

## [退出应用](https://www.jianshu.com/p/e6dda43d22e8)

用 Activity 的 singleTask 启动模式，实现在 ActivityA 点击返回键退出应用的功能。

## [强制退出的状态保存和再次启动的状态恢复](https://www.jianshu.com/p/bc71f25e2f35)

用 SharedPreferences 数据存储技术，实现在近期任务中滑动关闭应用后，再次启动时恢复退出时的 Activity 的功能。

## 委托相机应用拍照

### [拍照并展示](https://www.jianshu.com/p/f95468ecb292)

-   方案一：不给出照片的保存位置，返回照片的缩略图，照片不会保存。
-   方案二：给出照片的保存位置，将照片保存到指定位置。照片保存在应用私有存储区域，会随着应用的卸载被清除。

### [拍照展示并添加到相册](https://www.jianshu.com/p/c596590b5624)

拍照得到的照片保存在公共存储区域，可以通过相册查看，应用卸载仍将保留。

## [底部导航栏](https://www.jianshu.com/p/961213149215)

借助 BottomNavigationView 实现常见的底部导航栏效果。

## 单个变量保存多个状态

### [单个变量保存多个状态](https://www.jianshu.com/p/1ef149fd3ecd)

使用一个 byte 类型的变量保存多个 boolean 类型的值。

### [设置复选框的颜色](https://www.jianshu.com/p/694c1744108d)

使用 CheckBox 的 android:theme 属性设置复选框的选中和未选中状态的颜色。

## [实现签名功能](https://www.jianshu.com/p/bddc62bd4c55)

使用 [gcacace / android-signaturepad](https://github.com/gcacace/android-signaturepad) 库提供的 `SignaturePad` 控件，实现清空和保存控件内容功能。

## [选择其他应用打开文件](https://www.jianshu.com/p/f7bbaf90c2b7)

借助隐式 `Intent` ， 实现在其他应用中浏览文件内容的功能。

## [IPC](https://www.jianshu.com/p/795553849acf)
- Messenger
- AIDL
- ContentProvider
- Socket

## HTTP 访问网络
- [方案一 OkHttp](https://www.jianshu.com/p/246021fa050d)
- [方案二 OkHttp + Retrofit](https://www.jianshu.com/p/9c3432bbcc57)
- [方案三 OkHttp + Retrofit + RxJava](https://www.jianshu.com/p/f449feacce62)