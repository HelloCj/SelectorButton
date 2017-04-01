# SelectorButton
在开发过程中为了满足各种各样的button效果，通常是在drawable文件下新建selector.xml,还可能需要新建shape.xml,随着项目的推进发现drawable文件夹下的selector和shape越来越多，重复操作和命名词穷令我感到深深的痛苦。
有了痛苦就有动力，自定义SelectorButton就这么诞生了。

贴张效果图：

![](https://github.com/HelloCj/SelectorButton/blob/master/Screenshot.png)


## Step 1. Add the JitPack repository to your build file 
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
## Step 2. Add the dependency
  
  dependencies {
	        compile 'com.github.HelloCj:SelectorButton:1.0'
	}
  
## 属性介绍
 属性 | 介绍 | 类型 | 默认 | 是否必须 
 ---- | ---- | ---- | ---- | ----
 bg_pressed_color | 按下背景颜色 | color | #4db6ac | 否
 bg_normal_color | 正常背景颜色 | color | #009688 | 否
 bg_unable_color | 不可点击背景颜色 | color | #80cbc4 | 否
 text_pressed_color | 按下文字颜色 | color | Color.White | 否
 text_normal_color | 正常文字颜色 | color | Color.White | 否
 text_unable_color | 不可点击文字颜色 | color | Color.White | 否
 corner_radius | 圆角半径 | dimension | Color.White | 否
 round | 两侧是否为半球形 | boolean | false | 否
 animation_duration | 动画持续时间 | int | 100 | 否
 
## 用法
```
<com.richsoft.selectorlibrary.SelectorButton
        android:id="@+id/btn_blue"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="按钮"
        app:bg_normal_color="@color/bule500"
        app:bg_pressed_color="@color/bule300"
        app:bg_unable_color="@color/bule200"
        app:corner_radius="5dp"
        />
```

 
