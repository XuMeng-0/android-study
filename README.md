# android-study

## [启动另外一个 Activity 并结束当前 Activity](https://www.jianshu.com/p/21ab5f8c4c93)

探究在启动另外一个 Activity 并结束当前 Activity 时， finish() 和 startActivity() 调用顺序的影响。

## [退出应用](https://www.jianshu.com/p/e6dda43d22e8)

用 Activity 的 singleTask 启动模式，实现在 ActivityA 点击返回键退出应用的功能。

## [强制退出的状态保存和再次启动的状态恢复](https://www.jianshu.com/p/bc71f25e2f35)

用 SharedPreferences 数据存储技术，实现在近期任务中滑动关闭应用后，再次启动时恢复退出时的 Activity 的功能。

## 请求相机应用拍照

需求一：拍照并展示

-   方案一：不给出照片的保存位置，返回照片的缩略图。
-   方案二：给出照片的保存位置，将照片保存到指定位置。

方案一的照片不会保存。  
方案二的照片保存在应用私有存储区域，会随着应用的卸载被清除。

需求二：拍照展示并添加到相册  
拍照得到的照片保存在公共存储区域，可以通过相册查看，应用卸载仍将保留。
