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
  
