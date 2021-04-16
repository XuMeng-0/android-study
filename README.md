# android-study

## finish() 和 startActivity()

探究在启动另外一个 Activity 并结束当前 Activity 时， finish() 和 startActivity() 调用顺序的影响。

## 退出应用

用 Activity 的 singleTask 启动模式，实现在 ActivityA 点击返回键退出应用的功能。

## 强制退出的状态保存和再次启动的状态恢复

用 SharedPreferences 数据存储技术，实现在近期任务中滑动关闭应用后，再次启动时恢复退出时的 Activity 的功能。